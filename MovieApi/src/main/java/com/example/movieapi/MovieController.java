package com.example.movieapi;

import com.example.movieapi.Impl.MovieServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin("*")
public class MovieController {
    private final MovieServiceImpl movieService;

    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

//    @GetMapping
//    public ResponseEntity<List<Movie>> getAll(){
//        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK) ;
//    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllMovies(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {

        List<Movie> movies = movieService.getAllMovies(page, pageSize);
        int totalItems = movieService.countMovies();

        Map<String, Object> response = new HashMap<>();
        response.put("movies", movies);
        response.put("totalItems", totalItems);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody List<Movie> movies){
        for(Movie movie:movies){
        movieService.addMovie(movie);}
        return new ResponseEntity<>("Movie added successfully", HttpStatus.OK) ;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovie(@RequestParam String title){
        List<Movie> movies = movieService.searchMoviesByTitle(title);
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }


//    @GetMapping("/search")
//    public ResponseEntity<Map<String, Object>> searchMovie(
//            @RequestParam String title,
//            @RequestParam(defaultValue = "1") int page,
//            @RequestParam(defaultValue = "10") int pageSize) {
//
//        Pageable pageable = PageRequest.of(page - 1, pageSize);
//        Page<Movie> moviesPage = movieService.searchMoviesByTitle(title, pageable);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("results", moviesPage.getContent());
//        response.put("total_results", moviesPage.getTotalElements());
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

}
