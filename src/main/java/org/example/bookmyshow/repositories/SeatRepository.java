package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Override
    Optional<Seat> findById(Long aLong);

    @Override
    <S extends Seat> S save(S entity);
}
