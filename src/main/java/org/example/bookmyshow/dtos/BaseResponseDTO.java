package org.example.bookmyshow.dtos;

import lombok.Setter;

@Setter
public class BaseResponseDTO {
    private long id;
    private ResponseStatus status;
    private String failureMessage;
}
