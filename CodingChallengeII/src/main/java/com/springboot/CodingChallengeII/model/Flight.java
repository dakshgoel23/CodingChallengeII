package com.springboot.CodingChallengeII.model;

import com.springboot.CodingChallengeII.enums.Airline;
import com.springboot.CodingChallengeII.enums.Destination;
import com.springboot.CodingChallengeII.enums.Source;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String flight_number;
	
	@Enumerated(EnumType.STRING)
	private Airline airline;
	
	@Enumerated(EnumType.STRING)
	private Source source;
	

	@Enumerated(EnumType.STRING)
	private Destination destination;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	
	
	
	
	

}
