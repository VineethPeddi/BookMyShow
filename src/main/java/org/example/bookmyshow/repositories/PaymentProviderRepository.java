package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.PaymentProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentProviderRepository extends JpaRepository<PaymentProvider,Long> {
    @Override
    Optional<PaymentProvider> findById(Long aLong);
}
