package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.AddTheaterRequestDTO;
import org.example.bookmyshow.dtos.AddTheaterResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Theater;
import org.example.bookmyshow.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TheaterController {
    @Autowired
    private TheaterService theaterService;
    public AddTheaterResponseDTO addTheater(AddTheaterRequestDTO requestDTO){
        AddTheaterResponseDTO response=new AddTheaterResponseDTO();
        try{
            Theater theater=theaterService.addTheater(requestDTO.getName(),requestDTO.getRegionId(),requestDTO.getScreenIds());
            response.setId(theater.getId());
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(e.getMessage());
        }
        return response;
    }
}
