package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "guests")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Guest extends BaseEntity {
    @Column(name = "first_name", length = 25)
	private String firstName;
    @Column(name = "last_name", length = 25)
	private String lastName;
	private LocalDate dob;
	public Guest(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	
	
}
