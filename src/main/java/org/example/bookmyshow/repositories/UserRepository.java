package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    <S extends User> S save(S entity);

    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findByEmail(String email);
}
