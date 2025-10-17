package com.test.rentspace.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Booking booking;

    private Double amount;
    private String status;
    private LocalDateTime paidAt = LocalDateTime.now();

    public Payment() {}

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Booking getBooking(){return booking;}
    public void setBooking(Booking booking){this.booking=booking;}
    public Double getAmount(){return amount;}
    public void setAmount(Double amount){this.amount=amount;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
    public LocalDateTime getPaidAt(){return paidAt;}
    public void setPaidAt(LocalDateTime paidAt){this.paidAt=paidAt;}
}
