package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    @Override
    Optional<ShowSeat> findById(Long id);

    @Override
    <S extends ShowSeat> S save(S entity);
}
