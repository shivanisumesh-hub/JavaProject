package com.test.rentspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.rentspace.model.Accommodation;
import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    List<Accommodation> findByAvailableTrue();
}
