package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.sunbeam.entities.Room;

public interface RoomService {

	Room addNewRoom(Room room);
	
	List<Room> getAvailableRooms(LocalDate checkInDate);
}
