package com.umka.carbon.model;

import com.umka.carbon.config.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.*;

/**
 * Created by ARudyk on 12/3/2016.
 */
@Entity
@Table(name = "carbon_footprint")
public class CarbonFootprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Person person;

    @OneToOne (cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    private Car car;

    private Integer roomsInFlat;

    private Integer roommates;

    private Double electricityPerYear;

    private Double gasPerYear;

    private Double hotWaterPerYear;

    private Boolean airTravel;

    private String salary;

    private String countriesTraveled;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(updatable = false)
    private LocalDateTime dateCreated;

    public CarbonFootprint() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getRoomsInFlat() {
        return roomsInFlat;
    }

    public void setRoomsInFlat(Integer roomsInFlat) {
        this.roomsInFlat = roomsInFlat;
    }

    public Integer getRoommates() {
        return roommates;
    }

    public void setRoommates(Integer roommates) {
        this.roommates = roommates;
    }

    public Boolean getAirTravel() {
        return airTravel;
    }

    public void setAirTravel(Boolean airTravel) {
        this.airTravel = airTravel;
    }

    public String getCountriesTraveled() {
        return countriesTraveled;
    }

    public void setCountriesTraveled(String countriesTraveled) {
        this.countriesTraveled = countriesTraveled;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Double getElectricityPerYear() {
        return electricityPerYear;
    }

    public void setElectricityPerYear(Double electricityPerYear) {
        this.electricityPerYear = electricityPerYear;
    }

    public Double getGasPerYear() {
        return gasPerYear;
    }

    public void setGasPerYear(Double gasPerYear) {
        this.gasPerYear = gasPerYear;
    }

    public Double getHotWaterPerYear() {
        return hotWaterPerYear;
    }

    public void setHotWaterPerYear(Double hotWaterPerYear) {
        this.hotWaterPerYear = hotWaterPerYear;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @PrePersist
    protected void onCreate() {
        dateCreated = LocalDateTime.now();
    }
}
