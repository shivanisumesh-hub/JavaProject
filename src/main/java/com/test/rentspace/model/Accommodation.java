package com.test.rentspace.model;

import jakarta.persistence.*;

@Entity
public class Accommodation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 500)
    private String description;
    private String location;
    private Double pricePerMonth;
    private Boolean available = true;

    public Accommodation() {}

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    public String getLocation(){return location;}
    public void setLocation(String location){this.location=location;}
    public Double getPricePerMonth(){return pricePerMonth;}
    public void setPricePerMonth(Double pricePerMonth){this.pricePerMonth=pricePerMonth;}
    public Boolean getAvailable(){return available;}
    public void setAvailable(Boolean available){this.available=available;}
}
