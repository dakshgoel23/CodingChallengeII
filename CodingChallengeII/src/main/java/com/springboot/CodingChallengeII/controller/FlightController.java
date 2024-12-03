package com.springboot.CodingChallengeII.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.CodingChallengeII.exception.ResourceNotFoundException;
import com.springboot.CodingChallengeII.model.Flight;
import com.springboot.CodingChallengeII.model.User;
import com.springboot.CodingChallengeII.model.UserFlight;
import com.springboot.CodingChallengeII.service.FlightService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping("/api/flight/add")
	public Flight addFlight(@RequestBody Flight flight) {
		return flightService.insertFlight(flight);
	}
	
	@PostMapping("/api/user/add")
	public User addUser(@RequestBody User user) {
		return flightService.insertUser(user);
	}
	
	@PostMapping("/api/flight/add/batch")
	public void addFlightInBatch(@RequestBody List<Flight> flights) {
		flightService.insertFlghtInBatch(flights);
		
	}
	
	@PostMapping("api/book/flight")
	public UserFlight bookFlight(@RequestParam int flight_id,@RequestParam int user_id,
			                     @RequestBody UserFlight userFlight) throws ResourceNotFoundException {
		return flightService.book(flight_id,user_id,userFlight);
	}
	
	@GetMapping("/api/flight/all")
	public List<Flight> showAllFlights() {
		return flightService.showAll();
	}
	
	
	
	

	
	

}
