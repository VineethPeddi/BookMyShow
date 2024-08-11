package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType,Long> {

    @Override
    Optional<SeatType> findById(Long aLong);

    @Override
    <S extends SeatType> S save(S entity);
}
