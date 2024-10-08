package com.practice.springboot_jpa.repsitory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.springboot_jpa.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findByGenere(String genere);
	Page<Movie> findAll(Pageable page);
	Movie findByTitle(String title);
	
	@Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
	List<Movie> findMoviesByPartialTitle(@Param("title") String title);
}

