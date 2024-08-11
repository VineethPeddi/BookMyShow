package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeatureRepository extends JpaRepository<Feature,Long> {
    @Override
    Optional<Feature> findById(Long aLong);

    @Override
    <S extends Feature> S save(S entity);

    @Override
    List<Feature> findAllById(Iterable<Long> longs);
}
