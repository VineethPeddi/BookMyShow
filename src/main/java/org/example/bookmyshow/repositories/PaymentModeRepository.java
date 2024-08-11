package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.PaymentMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentModeRepository extends JpaRepository<PaymentMode,Long> {
    @Override
    Optional<PaymentMode> findById(Long aLong);
}
