package com.springboot.CodingChallengeII.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.CodingChallengeII.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{


}
