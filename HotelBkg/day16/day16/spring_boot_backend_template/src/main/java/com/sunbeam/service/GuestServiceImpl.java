package com.sunbeam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.GuestDao;
import com.sunbeam.entities.Guest;

@Service
@Transactional
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestDao guestDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Guest addNewGuest(Guest guest) {
		Guest persistentGuest = guestDao.save(guest);
		return persistentGuest;
	}

	@Override
	public List<Guest> getAllGuests() {
		
		return guestDao.findAll();
	}



}
