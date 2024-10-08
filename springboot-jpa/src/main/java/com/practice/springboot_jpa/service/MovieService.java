package com.practice.springboot_jpa.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.practice.springboot_jpa.model.Movie;
import com.practice.springboot_jpa.repsitory.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
//
//    PageRequest pageRequest = PageRequest.of(page, size);
//    Page<Movie> moviePage = movieRepository.findAll(pageRequest);
//    return moviePage.getContent();  // Convert Page to List
//	
	public List<Movie> getmoviedetails(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size,Sort.by("rating").descending());
        Page<Movie> moviePage = movieRepository.findAll(pageRequest);
        return moviePage.getContent();
	}
	
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
		
	}
	
	public void deletemoviebyId(long movieId) {
		movieRepository.deleteById(movieId);
	}

	public List<Movie> saveMovies(List<Movie> movies) {
		
		return movieRepository.saveAll(movies);//.save(movies);
	}

	@Cacheable(value="moviesByGenere", key="#genere")
	public List<Movie> getmoviedetails(String genere) {
		return movieRepository.findByGenere(genere);
	}

	public Movie getmoviebytitle(String title) {
		// TODO Auto-generated method stub
		return movieRepository.findByTitle(title);
	}
	
	public List<Movie> getmovieliketitle(String title){
		
		return movieRepository.findMoviesByPartialTitle(title);
	}


}
