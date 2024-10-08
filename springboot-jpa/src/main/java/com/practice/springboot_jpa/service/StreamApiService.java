package com.practice.springboot_jpa.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springboot_jpa.model.Movie;
import com.practice.springboot_jpa.repsitory.MovieRepository;

@Service
public class StreamApiService {
	
	@Autowired
	MovieRepository movieReository;
	
	public List<Movie> getHighRatedMovies(){
		List<Movie> allmovies=movieReository.findAll();
		List<Movie> movies = allmovies.stream().filter(x->x.getRating()  > 9).collect(Collectors.toList());
		return movies;
	}
	// Filter movies with rating > 4.5
//    return movies.stream()
//                 .filter(movie -> movie.getRating() > 4.5)
//                 .collect(Collectors.toList());
//		
}
