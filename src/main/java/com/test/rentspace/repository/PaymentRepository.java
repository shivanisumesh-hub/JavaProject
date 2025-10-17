package com.test.rentspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.rentspace.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
