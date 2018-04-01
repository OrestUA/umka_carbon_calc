package com.umka.carbon.service;

import com.umka.carbon.model.Car;
import com.umka.carbon.model.CarbonFootprint;
import com.umka.carbon.model.Person;
import com.umka.carbon.model.dto.QuestionnaireDto;
import com.umka.carbon.repositories.CarbonFootprintRepository;
import com.umka.carbon.repositories.PersonRepository;
import com.umka.carbon.service.mappers.QuestionnaireToCarMapper;
import com.umka.carbon.service.mappers.QuestionnaireToCarbonFootprintMapper;
import com.umka.carbon.service.mappers.QuestionnaireToPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ARudyk on 12/4/2016.
 */
@Service
public class SaveService {

    @Autowired
    private CarbonFootprintRepository carbonFootprintRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private QuestionnaireToCarbonFootprintMapper footprintMapper;

    @Autowired
    private QuestionnaireToCarMapper carMapper;

    @Autowired
    private QuestionnaireToPersonMapper personMapper;

    public void saveCarbonFootprintInfo (QuestionnaireDto dto){
        Person person = personRepository.findByEmail(dto.getEmail());
        if (person == null){
            person = personMapper.getPerson(dto);
        }
        CarbonFootprint footprint = footprintMapper.getCarbonFootprint(dto);
        if (dto.getCarEngineVolume() != null && dto.getCarEngineVolume() != 0) {
            Car car = carMapper.getCar(dto);
            footprint.setCar(car);
        }
        person.addCarbonFootprint(footprint);
        personRepository.save(person);
        carbonFootprintRepository.save(footprint);
    }
}
