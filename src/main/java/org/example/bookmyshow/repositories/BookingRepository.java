package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    @Override
    <S extends Booking> S save(S entity);

    @Override
    Optional<Booking> findById(Long aLong);
}
