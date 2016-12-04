package com.umka.carbon.service.mappers;

import com.umka.carbon.enums.Gender;
import com.umka.carbon.model.Person;
import com.umka.carbon.model.dto.QuestionnaireDto;
import org.springframework.stereotype.Service;

/**
 * Created by ARudyk on 12/3/2016.
 */
@Service
public class QuestionnaireToPersonMapper {
    public Person getPerson(QuestionnaireDto dto){
        Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        person.setGender(Gender.valueOf(dto.getGender().toUpperCase()));
        person.setEmail(dto.getEmail());
        person.setSubscribed(dto.getSubscription());
        return person;
    }
}
