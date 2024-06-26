package com.sunbeam.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Room;
import com.sunbeam.service.RoomService;

import io.swagger.v3.oas.annotations.Operation;




@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	private RoomService roomService;

	public RoomController() {
		System.out.println("in ctor " + getClass());
	}
	
	@PostMapping
	@Operation(description = "Create New Room")
	public ResponseEntity<?> addRoom(@RequestBody Room newRoom ){
		System.out.println("in add room " + newRoom);
		try {
			// invoke service layer
			return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addNewRoom(newRoom));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	
	@GetMapping("/available/{checkInDate}")
    @Operation(description = "Get Available Rooms on Given Check-in Date")
    public ResponseEntity<?> getAvailableRooms(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate) {
        try {
            List<Room> availableRooms = roomService.getAvailableRooms(checkInDate);
            return ResponseEntity.ok(availableRooms);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid date format or no rooms available"));
        }
    }
}
