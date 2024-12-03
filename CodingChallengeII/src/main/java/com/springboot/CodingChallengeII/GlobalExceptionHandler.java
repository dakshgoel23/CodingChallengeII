package com.springboot.CodingChallengeII;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.CodingChallengeII.dto.ResponseMessageDto;
import com.springboot.CodingChallengeII.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private ResponseMessageDto dto;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFound(Exception e){
		dto.setMsg(e.getMessage());
		return ResponseEntity.badRequest().body(dto);
	}
	

}
