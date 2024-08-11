package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Movie;
import org.example.bookmyshow.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public Movie addMovie(String name, List<String> actors){
        Movie movie=new Movie();
        movie.setActors(actors);
        movie.setName(name);
        return movieRepository.save(movie);
    }
}
