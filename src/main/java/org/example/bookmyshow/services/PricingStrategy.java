package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PricingStrategy {
    int calculateAmount(List<ShowSeat> showSeats, Show show);
}
