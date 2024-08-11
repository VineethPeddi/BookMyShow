package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.AddRegionRequestDTO;
import org.example.bookmyshow.dtos.AddRegionResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Region;
import org.example.bookmyshow.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegionController {
    @Autowired
    private RegionService regionService;
    public AddRegionResponseDTO addRegion(AddRegionRequestDTO requestDTO){
        AddRegionResponseDTO response=new AddRegionResponseDTO();
        try {
            Region region=regionService.addRegion(requestDTO.getName(),requestDTO.getTheaterIds());
            response.setId(region.getId());
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(e.getMessage());
        }
        return response;

    }
}
