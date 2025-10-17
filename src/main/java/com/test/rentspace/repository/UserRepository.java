package com.test.rentspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.rentspace.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
}
