package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Feature;
import org.example.bookmyshow.models.Movie;
import org.example.bookmyshow.models.Screen;
import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.repositories.FeatureRepository;
import org.example.bookmyshow.repositories.MovieRepository;
import org.example.bookmyshow.repositories.ScreenRepository;
import org.example.bookmyshow.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private FeatureRepository featureRepository;
    public Show createShow(
            Date startTime,
            Date endTime,
            long screenId,
            long movieId,
            List<Long> featureIds
    ) throws RuntimeException{
        Optional<Screen> optionalScreen=screenRepository.findById(screenId);
        if (optionalScreen.isEmpty())throw new RuntimeException("Screen not found");
        Optional<Movie> optionalMovie=movieRepository.findById(movieId);
        if (optionalMovie.isEmpty())throw new RuntimeException("Movie not found");
        List<Feature> features=new ArrayList<>();
        for(long featureId:featureIds){
            Optional<Feature> optionalFeature=featureRepository.findById(featureId);
            if(optionalFeature.isEmpty())throw new RuntimeException("Feature not found");
            features.add(optionalFeature.get());
        }
        Screen screen=optionalScreen.get();
        Movie movie=optionalMovie.get();

        Show show=new Show();
        show.setFeatures(features);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(startTime);
        show.setEndTime(endTime);
        return showRepository.save(show);
    }
}
