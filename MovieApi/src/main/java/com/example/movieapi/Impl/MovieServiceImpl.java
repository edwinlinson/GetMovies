package com.example.movieapi.Impl;

import com.example.movieapi.Movie;
import com.example.movieapi.MovieRepo;
import com.example.movieapi.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepo movieRepo;

    public MovieServiceImpl(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

//    @Override
//    public List<Movie> getAll() {
//        return movieRepo.findAll();
//    }
//
//    @Override
//    public Movie searchMovie(String title) {
//        return movieRepo.findMovieByTitle(title);
//    }

    public List<Movie> getAllMovies(int page, int pageSize) {
        Pageable paging = PageRequest.of(page - 1, pageSize);
        Page<Movie> pagedResult = movieRepo.findAll(paging);
        return pagedResult.hasContent() ? pagedResult.getContent() : new ArrayList<>();
    }
    @Override
    public void addMovie(Movie movie) {
        movieRepo.save(movie);
    }

//    @Override
//    public List<Movie> searchMoviesByTitle(String title) {
//        return null;
//    }

    public int countMovies() {
        return (int) movieRepo.count();
    }

    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepo.findByTitleContainingIgnoreCase(title);
    }
//    public Page<Movie> searchMoviesByTitle(String title, Pageable pageable) {
//        return movieRepo.findByTitleContainingIgnoreCase(title, pageable);
//    }
}
