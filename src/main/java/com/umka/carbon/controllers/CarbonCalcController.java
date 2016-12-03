package com.umka.carbon.controllers;

import com.umka.carbon.model.Car;
import com.umka.carbon.model.CarbonFootprint;
import com.umka.carbon.model.Person;
import com.umka.carbon.repositories.CarbonFootprintRepository;
import com.umka.carbon.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ARudyk on 12/3/2016.
 */
@RestController
public class CarbonCalcController {

    @Autowired
    private CarbonFootprintRepository carbonFootprintRepository;

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/carboncalc")
    public String index() {
        Person person = new Person();
        person.setName("test");

        Car car1 = new Car();
        car1.setEngineVolume(2.4);

        Car car2 = new Car();
        car2.setEngineVolume(77.7);

        CarbonFootprint footprint1 = new CarbonFootprint();
        footprint1.setCountriesTraveled("Ukraine, USA");

        footprint1.setCar(car1);

        CarbonFootprint footprint2 = new CarbonFootprint();
        footprint2.setCountriesTraveled("France, UK");

        footprint2.setCar(car2);

        person.addCarbonFootprint(footprint1);
        person.addCarbonFootprint(footprint2);

        personRepository.save(person);

//        carbonFootprintRepository.save(footprint1);
        return "Greetings from Umka Carbon Calculator!";
    }

    // Save carbon footprint
    @RequestMapping("/carboncalc/create")
    @ResponseBody
    public String saveCarbonFootprint(String title, int year) {
        CarbonFootprint carbonFootprint = new CarbonFootprint();

        try {
            carbonFootprintRepository.save(carbonFootprint);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "creation successful: " + String.valueOf(carbonFootprint.getId());
    }

}
