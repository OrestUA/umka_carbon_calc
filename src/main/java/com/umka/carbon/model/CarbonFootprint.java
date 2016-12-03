package com.umka.carbon.model;

import com.umka.carbon.config.LocalDateTimeAttributeConverter;
import com.umka.carbon.enums.Salary;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    private Integer electricityPerYear;

    private Integer gasPerYear;

    private Integer hotWaterPerYear;

    private Boolean airTravel;

    private Salary salary;

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

    public Integer getElectricityPerYear() {
        return electricityPerYear;
    }

    public void setElectricityPerYear(Integer electricityPerYear) {
        this.electricityPerYear = electricityPerYear;
    }

    public Integer getGasPerYear() {
        return gasPerYear;
    }

    public void setGasPerYear(Integer gasPerYear) {
        this.gasPerYear = gasPerYear;
    }

    public Integer getHotWaterPerYear() {
        return hotWaterPerYear;
    }

    public void setHotWaterPerYear(Integer hotWaterPerYear) {
        this.hotWaterPerYear = hotWaterPerYear;
    }

    public Boolean getAirTravel() {
        return airTravel;
    }

    public void setAirTravel(Boolean airTravel) {
        this.airTravel = airTravel;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
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

    @PrePersist
    protected void onCreate() {
        dateCreated = LocalDateTime.now();
    }
}
