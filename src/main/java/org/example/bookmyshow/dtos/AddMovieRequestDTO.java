package org.example.bookmyshow.dtos;

import lombok.Getter;

import java.util.List;

@Getter
public class AddMovieRequestDTO {
    private String name;
    private List<String> actors;
}
