package com.springboot.CodingChallengeII.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserFlight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Flight flight;
	
	private LocalDate date_of_journey;
	private int no_of_passangers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public LocalDate getDate_of_journey() {
		return date_of_journey;
	}
	public void setDate_of_journey(LocalDate date_of_journey) {
		this.date_of_journey = date_of_journey;
	}
	public int getNo_of_passangers() {
		return no_of_passangers;
	}
	public void setNo_of_passangers(int no_of_passangers) {
		this.no_of_passangers = no_of_passangers;
	}
	
	
	

}
