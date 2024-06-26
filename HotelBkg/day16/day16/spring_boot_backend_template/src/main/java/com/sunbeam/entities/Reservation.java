package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Reservation extends BaseEntity{
    @Column(name = "checkIn_date")
	private LocalDate checkInDate;
    @Column(name = "checkOut_date")
	private LocalDate checkOutDate;
    @Column(name = "total_price")
	private double totalprice;
	//reservation*----->1guest
	//many to one
    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
	private Guest guest;
	//reservation1------>1room
	//one to one
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", nullable = false)
	private Room room;
    
    
	public Reservation(LocalDate checkInDate, LocalDate checkOutDate, double totalprice, Guest guest, Room room) {
		super();
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalprice = totalprice;
		this.guest = guest;
		this.room = room;
	}
    
    
	
}
