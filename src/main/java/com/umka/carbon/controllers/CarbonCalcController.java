package com.umka.carbon.controllers;

import com.umka.carbon.model.Car;
import com.umka.carbon.model.CarbonFootprint;
import com.umka.carbon.model.Person;
import com.umka.carbon.model.dto.CarbonFootprintDto;
import com.umka.carbon.model.dto.QuestionnaireDto;
import com.umka.carbon.repositories.CarbonFootprintRepository;
import com.umka.carbon.repositories.PersonRepository;
import com.umka.carbon.service.CarbonCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ARudyk on 12/3/2016.
 */
@RestController
public class CarbonCalcController {

    @Autowired
    private CarbonCalcService service;

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/carboncalc", method = RequestMethod.GET)
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

    // Calculate carbon footprint
    @RequestMapping(value="/carboncalc", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarbonFootprintDto saveCarbonFootprint(@RequestBody QuestionnaireDto dto) {

        return service.calculateCarbonFootprint(dto);
    }
}
