package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.AddUserRequestDTO;
import org.example.bookmyshow.dtos.AddUserResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public AddUserResponseDTO signUpUser(AddUserRequestDTO requestDTO){
        AddUserResponseDTO response=new AddUserResponseDTO();
        try{
            User user=userService.signUpUser(requestDTO.getName(),requestDTO.getEmail(),requestDTO.getPassword());
            response.setId(user.getId());
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(e.getMessage());
        }
        return response;
    }
}
