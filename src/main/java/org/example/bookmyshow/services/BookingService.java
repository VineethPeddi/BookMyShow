package org.example.bookmyshow.services;

import org.example.bookmyshow.exceptions.ShowNotFoundException;
import org.example.bookmyshow.exceptions.ShowSeatNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repositories.BookingRepository;
import org.example.bookmyshow.repositories.ShowRepository;
import org.example.bookmyshow.repositories.ShowSeatRepository;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private PricingStrategy pricingStrategy;
    public Booking bookTicket(Long userId, List<Long> showSeatIds, long showId) throws ShowSeatNotFoundException,UserNotFoundException,ShowNotFoundException {
        Optional<User> optionalUser=userRepository.findById(userId);
        if(optionalUser.isEmpty())throw new UserNotFoundException("User not found");
        User user=optionalUser.get();

        Optional<Show> optionalShow=showRepository.findById(showId);
        if (optionalShow.isEmpty())throw new ShowNotFoundException("Show not found");
        Show show=optionalShow.get();

        List<ShowSeat> showSeats=new ArrayList<>();
        for(Long showSeatId:showSeatIds){
            Optional<ShowSeat> optionalShowSeat =showSeatRepository.findById(showSeatId);
            if(optionalShowSeat.isEmpty())throw new ShowSeatNotFoundException("ShowSeat not found");
            ShowSeat showSeat=optionalShowSeat.get();
            if(showSeat.getStatus()!= ShowSeatStatus.EMPTY){
                throw new RuntimeException("Seat not available");
            }
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            showSeats.add(showSeat);
        }
        int amount=pricingStrategy.calculateAmount(showSeats,show);

        Booking booking=new Booking();
        booking.setBookedAt(new Date());
        booking.setShow(show);
        booking.setAmount(amount);
        booking.setUser(user);
        booking.setShowSeats(showSeats);
        bookingRepository.save(booking);
        showSeatRepository.saveAll(showSeats);
        return booking;
    }
}
