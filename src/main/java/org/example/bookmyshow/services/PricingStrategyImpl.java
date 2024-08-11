package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeat;
import org.example.bookmyshow.models.ShowSeatType;
import org.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PricingStrategyImpl implements PricingStrategy{

    @Autowired
    private ShowSeatTypeRepository showSeatTypeRepository;
    @Override
    public int calculateAmount(List<ShowSeat> showSeats, Show show) {
        List<ShowSeatType> showSeatTypes= showSeatTypeRepository.findAll(show);
        int sum=0;
        for (ShowSeat showSeat:showSeats){
            for(ShowSeatType showSeatType:showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType()))sum+=showSeatType.getPrice();
            }
        }
        return sum;
    }
}
