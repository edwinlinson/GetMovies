package com.example.movieapi;

import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie,Long> {
    Movie findMovieByTitle(String title);
    List<Movie> findByTitleContainingIgnoreCase(String title);
}
