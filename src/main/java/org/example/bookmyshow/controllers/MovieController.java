package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.AddMovieRequestDTO;
import org.example.bookmyshow.dtos.AddMovieResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Movie;
import org.example.bookmyshow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;
    public AddMovieResponseDTO addMovie(AddMovieRequestDTO requestDTO){
        AddMovieResponseDTO response=new AddMovieResponseDTO();
        try{
            Movie movie= movieService.addMovie(requestDTO.getName(),requestDTO.getActors());
            response.setId(movie.getId());
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(e.getMessage());
        }
        return response;
    }
}
