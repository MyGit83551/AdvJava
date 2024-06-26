package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Reservation;
import com.sunbeam.service.ReservationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    public ReservationController() {
        System.out.println("in ctor " + getClass());
    }

    @PostMapping
    @Operation(description = "Create New Reservation")
    public ResponseEntity<?> addReservation(@RequestBody Reservation newReservation) {
        System.out.println("in add reservation " + newReservation);
        try {
            
            return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addNewReservation(newReservation));
        } catch (RuntimeException e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
        }
    }
    
    
    @DeleteMapping("/{reservationId}")
    @Operation(description = "Cancel Reservation")
    public ResponseEntity<?> cancelReservation(@PathVariable Long reservationId) {
        try {
            reservationService.cancelReservation(reservationId);
            return ResponseEntity.ok(new ApiResponse("Reservation canceled successfully"));
        } catch (RuntimeException e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
        }
    }

//    @GetMapping
//    public List<Reservation> listAllReservations() {
//        System.out.println("in list");
//        return reservationService.getAllReservations();
//    }
}
