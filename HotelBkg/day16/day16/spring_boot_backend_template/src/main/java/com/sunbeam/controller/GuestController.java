package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Guest;
import com.sunbeam.service.GuestService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/guests")
public class GuestController {

	@Autowired
	private GuestService guestService;
	
	public GuestController() {
		System.out.println("in ctor " + getClass());
	}
	
	@PostMapping
	@Operation(description = "Create New Guest")
	public ResponseEntity<?> addCategory(@RequestBody Guest newGuest) {
		System.out.println("in add guest " + newGuest);
		try {
			// invoke service layer
			return ResponseEntity.status(HttpStatus.CREATED).body(guestService.addNewGuest(newGuest));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}

	@GetMapping
	public List<Guest> listAllCategories() {
		System.out.println("in list");
		return guestService.getAllGuests();
	}

	
	
}
