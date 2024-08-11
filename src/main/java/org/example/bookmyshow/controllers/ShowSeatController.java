package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.dtos.ShowSeatRequestDTO;
import org.example.bookmyshow.dtos.ShowSeatResponseDTO;
import org.example.bookmyshow.models.ShowSeat;
import org.example.bookmyshow.repositories.SeatRepository;
import org.example.bookmyshow.repositories.ShowSeatRepository;
import org.example.bookmyshow.services.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ShowSeatController {
    @Autowired
    private ShowSeatService showSeatService;
    public ShowSeatResponseDTO createShowSeat(ShowSeatRequestDTO requestDTO){
        ShowSeatResponseDTO response = new ShowSeatResponseDTO();
        try{
            ShowSeat showSeat=showSeatService.createShowSeat(requestDTO.getSeatId(),requestDTO.getShowId());
            response.setId(showSeat.getId());
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(e.getMessage());
        }
        return response;
    }
}
