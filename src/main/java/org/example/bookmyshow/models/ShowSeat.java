package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.exception.DataException;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Seat seat;

    @Enumerated
    private ShowSeatStatus status;

    @ManyToOne
    private Show show;

    private Date blockedAt;
}
