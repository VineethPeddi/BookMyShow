package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Region;
import org.example.bookmyshow.models.Screen;
import org.example.bookmyshow.models.Theater;
import org.example.bookmyshow.repositories.RegionRepository;
import org.example.bookmyshow.repositories.ScreenRepository;
import org.example.bookmyshow.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private ScreenRepository screenRepository;

    public Theater addTheater(String name, long regionId, List<Long> screenIds){
        Optional<Region> optionalRegion=regionRepository.findById(regionId);
        if (optionalRegion.isEmpty())throw new RuntimeException("Region not found");
        List<Screen> screens=new ArrayList<>();
        for (long screenId:screenIds){
            Optional<Screen> optionalScreen=screenRepository.findById(screenId);
            if (optionalScreen.isEmpty())throw new RuntimeException("Screen not found");
            screens.add(optionalScreen.get());
        }

        Theater theater=new Theater();
        theater.setName(name);
        theater.setRegion(optionalRegion.get());
        theater.setScreens(screens);
        return theaterRepository.save(theater);
    }
}
