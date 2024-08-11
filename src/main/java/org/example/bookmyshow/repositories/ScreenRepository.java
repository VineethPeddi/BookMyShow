package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long> {
    @Override
    <S extends Screen> S save(S entity);

    @Override
    Optional<Screen> findById(Long aLong);
}
