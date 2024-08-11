package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Region;
import org.example.bookmyshow.models.Theater;
import org.example.bookmyshow.repositories.RegionRepository;
import org.example.bookmyshow.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private TheaterRepository theaterRepository;

    public Region addRegion(String name, List<Long> theaterIds){
        List<Theater> theaters=new ArrayList<>();
        for (Long theaterId:theaterIds){
            Optional<Theater> optionalTheater=theaterRepository.findById(theaterId);
            if (optionalTheater.isEmpty())throw new RuntimeException("Theater not found");
            theaters.add(optionalTheater.get());
        }
        Region region=new Region();
        region.setName(name);
        region.setTheaterList(theaters);
        return regionRepository.save(region);
    }
}
