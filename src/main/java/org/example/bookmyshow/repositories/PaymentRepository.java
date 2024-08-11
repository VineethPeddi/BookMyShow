package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    @Override
    Optional<Payment> findById(Long aLong);

    @Override
    <S extends Payment> S save(S entity);
}
