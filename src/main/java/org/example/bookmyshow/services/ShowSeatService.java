package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Seat;
import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeat;
import org.example.bookmyshow.models.ShowSeatStatus;
import org.example.bookmyshow.repositories.SeatRepository;
import org.example.bookmyshow.repositories.ShowRepository;
import org.example.bookmyshow.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    public ShowSeat createShowSeat(long seatId,long showId){
        Optional<Seat> optionalSeat=seatRepository.findById(seatId);
        if (optionalSeat.isEmpty())throw new RuntimeException("Seat not found");
        Optional<Show> optionalShow=showRepository.findById(showId);
        if (optionalShow.isEmpty())throw new RuntimeException("Show not found");
        ShowSeat showSeat=new ShowSeat();
        showSeat.setShow(optionalShow.get());
        showSeat.setSeat(optionalSeat.get());
        showSeat.setStatus(ShowSeatStatus.EMPTY);
        return showSeatRepository.save(showSeat);
    }
}
