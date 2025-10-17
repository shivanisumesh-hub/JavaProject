package com.test.rentspace.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Accommodation accommodation;

    private LocalDate startDate;
    private LocalDate endDate;

    public Booking() {}

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public User getUser(){return user;}
    public void setUser(User user){this.user=user;}
    public Accommodation getAccommodation(){return accommodation;}
    public void setAccommodation(Accommodation accommodation){this.accommodation=accommodation;}
    public LocalDate getStartDate(){return startDate;}
    public void setStartDate(LocalDate startDate){this.startDate=startDate;}
    public LocalDate getEndDate(){return endDate;}
    public void setEndDate(LocalDate endDate){this.endDate=endDate;}
}
