package com.practice.springboot_jpa.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long movieId;
	
	public String title;
	
	public String  localdate;
	
	public String genere;
	
	public double rating;
	public double getRating() {
        return rating;
    }

}
