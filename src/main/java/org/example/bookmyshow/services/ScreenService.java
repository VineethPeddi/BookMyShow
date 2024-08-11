package org.example.bookmyshow.services;
import org.example.bookmyshow.models.Feature;
import org.example.bookmyshow.models.Seat;
import org.example.bookmyshow.models.Theater;
import org.example.bookmyshow.models.Screen;
import org.example.bookmyshow.repositories.FeatureRepository;
import org.example.bookmyshow.repositories.ScreenRepository;
import org.example.bookmyshow.repositories.SeatRepository;
import org.example.bookmyshow.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public Screen addScreen(String name, List<Long> featureIds, List<Long> seatIds, long theaterId) {
        // Retrieve the theater by ID
        Optional<Theater> theaterOpt = theaterRepository.findById(theaterId);
        if (theaterOpt.isEmpty()) {
            throw new RuntimeException("Theater not found with ID: " + theaterId);
        }
        Theater theater = theaterOpt.get();

        // Retrieve the features by their IDs
        List<Feature> features = featureRepository.findAllById(featureIds);
        if (features.size() != featureIds.size()) {
            throw new RuntimeException("Some features not found");
        }

        // Retrieve the seats by their IDs
        List<Seat> seats = seatRepository.findAllById(seatIds);
        if (seats.size() != seatIds.size()) {
            throw new RuntimeException("Some seats not found");
        }

        // Create a new Screen instance
        Screen screen = new Screen();
        screen.setName(name);
        screen.setFeatures(features);
        screen.setSeats(seats);
        screen.setTheater(theater);

        // Save the Screen to the database
        return screenRepository.save(screen);
    }
}
