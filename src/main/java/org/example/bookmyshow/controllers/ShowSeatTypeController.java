package org.example.bookmyshow.controllers;

import org.example.bookmyshow.services.ShowSeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ShowSeatTypeController {
    @Autowired
    private ShowSeatTypeService showSeatTypeService;
}
