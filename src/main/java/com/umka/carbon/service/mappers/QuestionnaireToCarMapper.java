package com.umka.carbon.service.mappers;

import com.umka.carbon.model.Car;
import com.umka.carbon.model.dto.QuestionnaireDto;
import org.springframework.stereotype.Service;

/**
 * Created by ARudyk on 12/4/2016.
 */
@Service
public class QuestionnaireToCarMapper {

    public Car getCar(QuestionnaireDto dto){
        Car car = new Car();
        car.setEngineVolume(dto.getCarEngineVolume());
        car.setRun(dto.getCarDistance());
        return car;
    }
}
