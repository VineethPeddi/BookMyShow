package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.CreateShowRequestDTO;
import org.example.bookmyshow.dtos.CreateShowResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ShowController {
    @Autowired
    private ShowService showService;
    public CreateShowResponseDTO createShow(CreateShowRequestDTO requestDTO){
        CreateShowResponseDTO response=new CreateShowResponseDTO();
        try{
            Show show=showService.createShow(requestDTO.getStartTime(),requestDTO.getEndTime(),requestDTO.getScreenId(),requestDTO.getMovieId(),requestDTO.getFeatureIds());
            response.setId(show.getId());
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
