package com.test.rentspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.rentspace.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {}
