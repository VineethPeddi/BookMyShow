package org.example.bookmyshow.dtos;

import lombok.Getter;

import java.util.List;

@Getter
public class AddTheaterRequestDTO {
    private String name;
    private long regionId;
    private List<Long> screenIds;
}
