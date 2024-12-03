package com.springboot.CodingChallengeII.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.CodingChallengeII.exception.ResourceNotFoundException;
import com.springboot.CodingChallengeII.model.Flight;
import com.springboot.CodingChallengeII.model.User;
import com.springboot.CodingChallengeII.model.UserFlight;
import com.springboot.CodingChallengeII.repository.FlightRepository;
import com.springboot.CodingChallengeII.repository.UserFlightRepository;
import com.springboot.CodingChallengeII.repository.UserRepository;

@Service
public class FlightService {
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserFlightRepository userFlightRepository;

	public Flight insertFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	public User insertUser(User user) {
		return userRepository.save(user);
	}
	
	public Flight validateFlight(int flight_id) throws ResourceNotFoundException {
		Optional<Flight> optional=flightRepository.findById(flight_id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException(" Flight Id Not Found");
		
		Flight flight=optional.get();
		return flight;
	}
	
	public User validateUser(int user_id) throws ResourceNotFoundException {
		Optional<User> optional=userRepository.findById(user_id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException(" User Id Not Found");
		
		User user=optional.get();
		return user;
	}

	public UserFlight book(int flight_id, int user_id, UserFlight userFlight) throws ResourceNotFoundException {
		
		Flight flight=validateFlight(flight_id);
		User user=validateUser(user_id);
		
		userFlight.setFlight(flight);
		userFlight.setUser(user);
		
		return userFlightRepository.save(userFlight);
		
	}

	public List<Flight> showAll() {
		return flightRepository.findAll();
	}

	public void insertFlghtInBatch(List<Flight> flights) {
		
		flightRepository.saveAll(flights);
		
	}




}
