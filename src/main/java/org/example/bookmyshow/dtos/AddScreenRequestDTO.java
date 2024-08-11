package org.example.bookmyshow.dtos;

import lombok.Getter;

import java.util.List;

@Getter
public class AddScreenRequestDTO {
    private String name;
    private List<Long> featureIds;
    private List<Long> seatIds;
    private long theaterId;
}
