package com.practice.springboot_jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot_jpa.model.Movie;
import com.practice.springboot_jpa.service.StreamApiService;

@RestController
@RequestMapping("/streamoperation")
public class SteamApiController {
	
	@Autowired
	StreamApiService streamApiService;	

	@GetMapping("/high-rated")
	public ResponseEntity<List<Movie>> getHighRatedMovies(){
		return ResponseEntity.ok(streamApiService.getHighRatedMovies());
	}
	

}
