package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingTicketRequestDTO {
    private long userId;
    private List<Long> showSeatsIds;
    private long showId;
}
