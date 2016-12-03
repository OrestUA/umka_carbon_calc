package com.umka.carbon.model;

import com.umka.carbon.enums.Gender;
import com.umka.carbon.enums.Salary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YSkakun on 12/3/2016.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Gender gender;

    private Integer age;

    private String email;

    private Boolean subscribed;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<CarbonFootprint> carbonFootprints = new ArrayList<>();

    public Person() {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public List<CarbonFootprint> getCarbonFootprints() {
        return carbonFootprints;
    }

    public void setCarbonFootprints(List<CarbonFootprint> carbonFootprints) {
        this.carbonFootprints = carbonFootprints;
    }

    public void addCarbonFootprint(CarbonFootprint carbonFootprint) {
        carbonFootprints.add(carbonFootprint);
        carbonFootprint.setPerson(this);
    }

    public void removeCarbonFootprint(CarbonFootprint carbonFootprint) {
        carbonFootprint.setPerson(null);
        carbonFootprints.remove(carbonFootprint);
    }

}
