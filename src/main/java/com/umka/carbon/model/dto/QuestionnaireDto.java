package com.umka.carbon.model.dto;

/**
 * Created by ARudyk on 12/3/2016.
 */
public class QuestionnaireDto {

    private String name;
    private String email;
    private String gender;
    private Integer age;
    private Boolean subscription;

    private Integer rooms;
    private Integer roommates;

    private Double electricity;
    private Double gas;
    private Double hotWater;

    private Double carEngineVolume;
    private Double carDistance;

    private Boolean airTravel;
    private String countries;

    private String salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSubscription() {
        return subscription;
    }

    public void setSubscription(Boolean subscription) {
        this.subscription = subscription;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getRoommates() {
        return roommates;
    }

    public void setRoommates(Integer roommates) {
        this.roommates = roommates;
    }

    public Double getElectricity() {
        return electricity;
    }

    public void setElectricity(Double electricity) {
        this.electricity = electricity;
    }

    public Double getGas() {
        return gas;
    }

    public void setGas(Double gas) {
        this.gas = gas;
    }

    public Double getHotWater() {
        return hotWater;
    }

    public void setHotWater(Double hotWater) {
        this.hotWater = hotWater;
    }

    public Double getCarEngineVolume() {
        return carEngineVolume;
    }

    public void setCarEngineVolume(Double carEngineVolume) {
        this.carEngineVolume = carEngineVolume;
    }

    public Double getCarDistance() {
        return carDistance;
    }

    public void setCarDistance(Double carDistance) {
        this.carDistance = carDistance;
    }

    public Boolean getAirTravel() {
        return airTravel;
    }

    public void setAirTravel(Boolean airTravel) {
        this.airTravel = airTravel;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "QuestionnaireDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", subscription=" + subscription +
                ", rooms=" + rooms +
                ", roommates=" + roommates +
                ", electricity=" + electricity +
                ", gas=" + gas +
                ", hotWater=" + hotWater +
                ", carEngineVolume=" + carEngineVolume +
                ", carDistance=" + carDistance +
                ", airTravel=" + airTravel +
                ", countries='" + countries + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
