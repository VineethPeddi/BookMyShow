package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long> {

    @Override
    Optional<Theater> findById(Long aLong);

    @Override
    <S extends Theater> S save(S entity);
}
