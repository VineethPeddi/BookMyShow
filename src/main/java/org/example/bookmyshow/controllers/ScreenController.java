package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.AddScreenRequestDTO;
import org.example.bookmyshow.dtos.AddScreenResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Screen;
import org.example.bookmyshow.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ScreenController {
    @Autowired
    private ScreenService screenService;
    public AddScreenResponseDTO addScreen(AddScreenRequestDTO requestDTO){
        AddScreenResponseDTO response=new AddScreenResponseDTO();
        try{
            Screen screen=screenService.addScreen(requestDTO.getName(),requestDTO.getFeatureIds(),requestDTO.getSeatIds(),requestDTO.getTheaterId());
            response.setId(screen.getId());
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setFailureMessage(e.getMessage());
            response.setStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
