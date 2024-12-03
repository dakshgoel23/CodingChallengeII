package com.springboot.CodingChallengeII.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.CodingChallengeII.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
