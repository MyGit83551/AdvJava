package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Room extends BaseEntity{
    @Column(name = "room_no", unique = true, length = 25 )
	private String roomNo;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
	private Type type;
    @Column(nullable = true)
	private double price;
	private boolean availability;
	
	public Room(String roomNo, Type type, double price, boolean availability) {
		super();
		this.roomNo = roomNo;
		this.type = type;
		this.price = price;
		this.availability = availability;
	}
	
	
	
}
