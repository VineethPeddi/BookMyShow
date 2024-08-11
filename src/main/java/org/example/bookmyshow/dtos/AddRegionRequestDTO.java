package org.example.bookmyshow.dtos;

import lombok.Getter;

import java.util.List;

@Getter
public class AddRegionRequestDTO {
    private String name;
    private List<Long> theaterIds;
}
