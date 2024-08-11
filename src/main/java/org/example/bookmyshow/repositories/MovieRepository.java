package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Override
    <S extends Movie> S save(S entity);

    @Override
    Optional<Movie> findById(Long aLong);
}
