package com.practice.springboot_jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot_jpa.model.Movie;
import com.practice.springboot_jpa.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService movieservice;

	@GetMapping("/list")
	public ResponseEntity<List<Movie>> getallMovies(  @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {

		return ResponseEntity.ok(movieservice.getmoviedetails(page ,size));

	}

	@GetMapping("/list/{genere}")
	public ResponseEntity<List<Movie>> getMoviesforgenere(@PathVariable String genere ) {

		return ResponseEntity.ok(movieservice.getmoviedetails(genere));

	}
	
	@GetMapping("find/{title}")
	public ResponseEntity<Movie> getMoviebyTitle(@PathVariable String title ) {

		return ResponseEntity.ok(movieservice.getmoviebytitle(title));

	}
	
	@GetMapping("/title/like")
	public ResponseEntity<List<Movie>> getMoviesByPartialTitle(@RequestParam String title) {
	    List<Movie> movies = movieservice.getmovieliketitle(title);
	    return ResponseEntity.ok(movies);
	}
	

	@PostMapping("/addmovie")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movieservice.createMovie(movie));
	}

	@PostMapping("/addmultiplemovies")
	public ResponseEntity<List<Movie>> addAllMovies(@RequestBody List<Movie> movies) {
		List<Movie> savedMovies = movieservice.saveMovies(movies);
		return ResponseEntity.ok(savedMovies);
	}

	// @PutMapping

	@DeleteMapping("/{movieId}")
	public String deleteMovie(@PathVariable long movieId) {
		movieservice.deletemoviebyId(movieId);
		return "MovieDeleted";

	}

}
