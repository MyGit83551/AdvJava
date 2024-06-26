package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.Guest;

public interface GuestService {
   Guest addNewGuest(Guest guest);
   List<Guest> getAllGuests();
}
