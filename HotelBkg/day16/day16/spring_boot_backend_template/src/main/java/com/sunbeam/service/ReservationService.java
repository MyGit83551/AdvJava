package com.sunbeam.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.sunbeam.entities.Reservation;

public interface ReservationService {
   Reservation addNewReservation(Reservation reservation);
  
   public ResponseEntity<?> cancelReservation(@PathVariable Long reservationId);
}
