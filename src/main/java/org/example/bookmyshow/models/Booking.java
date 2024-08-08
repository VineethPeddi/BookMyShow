package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private int amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    BookingStatus status;

    Date bookedAt;

}
