package org.example.bookmyshow.services;

import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeatType;
import org.example.bookmyshow.repositories.SeatTypeRepository;
import org.example.bookmyshow.repositories.ShowRepository;
import org.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowSeatTypeService {
    @Autowired
    private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatTypeRepository seatTypeRepository;

    public ShowSeatType createShowSeat(long showId,long seatTypeId,int price) {
        Optional<Show> optionalShow = showRepository.findById(showId);
        if (optionalShow.isEmpty()) throw new RuntimeException("Show not found");
        Optional<SeatType> optionalSeatType = seatTypeRepository.findById(seatTypeId);
        if (optionalSeatType.isEmpty()) throw new RuntimeException("SeatType not found");

        ShowSeatType showSeatType = new ShowSeatType();
        showSeatType.setSeatType(optionalSeatType.get());
        showSeatType.setShow(optionalShow.get());
        showSeatType.setPrice(price);
        return showSeatTypeRepository.save(showSeatType);
    }
}
