package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
    
    @Query("SELECT r FROM Reservation r WHERE r.room.id = :roomId AND " +
           "(r.checkInDate <= :checkOutDate AND r.checkOutDate >= :checkInDate)")
    
    List<Reservation> findByRoomIdAndDateRange(@Param("roomId") Long roomId, 
                                               @Param("checkInDate") LocalDate checkInDate, 
                                               @Param("checkOutDate") LocalDate checkOutDate);
}
