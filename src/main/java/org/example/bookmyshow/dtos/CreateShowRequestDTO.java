package org.example.bookmyshow.dtos;

import lombok.Getter;
import org.example.bookmyshow.models.Feature;

import java.util.Date;
import java.util.List;

@Getter
public class CreateShowRequestDTO {
    private Date startTime;
    private Date endTime;
    private long screenId;
    private long movieId;
    private List<Long> featureIds;
}
