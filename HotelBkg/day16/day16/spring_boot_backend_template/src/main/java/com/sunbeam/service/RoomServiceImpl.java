package com.sunbeam.service;


import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.RoomDao;
import com.sunbeam.entities.Room;
@Service 
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;
	
	private ModelMapper modelMapper;
	
	@Override
	public Room addNewRoom(Room room) {
	   Room persistentRoom = roomDao.save(room);
		return persistentRoom;
	}
	
	@Override
    public List<Room> getAvailableRooms(LocalDate checkInDate) {
        return roomDao.findAvailableRoomsByDate(checkInDate);
    }

}
