package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.BookingTicketRequestDTO;
import org.example.bookmyshow.dtos.BookingTicketResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Booking;
import org.example.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;
    public BookingTicketResponseDTO bookTickets(BookingTicketRequestDTO requestDTO){
        BookingTicketResponseDTO response=new BookingTicketResponseDTO();
        try{
            Booking booking=bookingService.bookTicket(requestDTO.getUserId(),requestDTO.getShowSeatsIds(),requestDTO.getShowId());
            response.setBooking(booking);
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(e.getMessage());
        }

        return response;
    }
}
