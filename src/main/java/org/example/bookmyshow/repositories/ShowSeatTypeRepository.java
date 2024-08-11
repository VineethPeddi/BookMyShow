package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeatType;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
    <S extends ShowSeatType> List<S> findAll(Show show);
}
