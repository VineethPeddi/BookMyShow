package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {
    @Override
    Optional<Region> findById(Long aLong);

    @Override
    <S extends Region> S save(S entity);
}
