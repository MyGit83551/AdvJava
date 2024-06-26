package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.GuestDao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private GuestDao guestDao;

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public Reservation addNewReservation(Reservation reservation) {
        // Validate guest
        Guest guest = guestDao.findById(reservation.getGuest().getId())
                .orElseThrow(() -> new RuntimeException("Guest not found"));

        // Validate room
        Room room = roomDao.findById(reservation.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // Validate dates
        if (reservation.getCheckInDate().isAfter(reservation.getCheckOutDate())) {
            throw new RuntimeException("Check-in date must be before check-out date");
        }

        // Additional business logic (e.g., check for room availability)
        if (!isRoomAvailable(reservation.getRoom().getId(), reservation.getCheckInDate(), reservation.getCheckOutDate())) {
            throw new RuntimeException("Room is not available for the selected dates");
        }

        // Set the validated guest and room
        reservation.setGuest(guest);
        reservation.setRoom(room);

        return reservationDao.save(reservation);
    }

//    @Override
//    public List<Reservation> getAllReservations() {
//        return reservationDao.findAll();
//    }

     
    private boolean isRoomAvailable(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Reservation> reservations = reservationDao.findByRoomIdAndDateRange(roomId, checkInDate, checkOutDate);
        return reservations.isEmpty();
    }
    @Override
    public ResponseEntity<?> cancelReservation(Long reservationId) {
        try {
            Optional<Reservation> optionalReservation = reservationDao.findById(reservationId);
            if (optionalReservation.isPresent()) {
                Reservation reservation = optionalReservation.get();
                reservationDao.delete(reservation);
                return ResponseEntity.ok(new ApiResponse("Reservation cancelled successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Reservation not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failed to cancel reservation"));
        }
    }

}
