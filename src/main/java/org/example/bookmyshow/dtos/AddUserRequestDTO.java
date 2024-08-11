package org.example.bookmyshow.dtos;

import lombok.Getter;

@Getter
public class AddUserRequestDTO {
    private String name;
    private String email;
    private String password;
}
