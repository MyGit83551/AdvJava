package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Room;


public interface RoomDao extends JpaRepository<Room,Long>
{
	@Query("SELECT r FROM Room r WHERE r.id NOT IN (SELECT res.room.id FROM Reservation res WHERE res.checkInDate = :checkInDate)")
    List<Room> findAvailableRoomsByDate(LocalDate checkInDate);
	
	
	
}
