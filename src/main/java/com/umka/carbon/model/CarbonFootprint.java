package com.umka.carbon.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ARudyk on 12/3/2016.
 */
@Entity
@Table(name = "carbon_footprint")
public class CarbonFootprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    //    private Gender gender;
    private Integer age;

    private Integer roomsInFlat;
    private Integer roommates;
    private Integer electricityPerYear;
    private Integer gasPerYear;
    private Integer hotWaterPerYear;
    private Boolean airTravel;
//    private List<String> countriesTravel;

//    private CarQuestionnaire carQuestionnaire;

    public CarbonFootprint() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

//    public List<String> getCountriesTravel() {
//        return countriesTravel;
//    }
//
//    public void setCountriesTravel(List<String> countriesTravel) {
//        this.countriesTravel = countriesTravel;
//    }
}
