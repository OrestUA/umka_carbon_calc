package com.umka.carbon.service.mappers;

import com.umka.carbon.model.CarbonFootprint;
import com.umka.carbon.model.dto.QuestionnaireDto;
import org.springframework.stereotype.Service;

/**
 * Created by ARudyk on 12/3/2016.
 */
@Service
public class QuestionnaireToCarbonFootprintMapper {

    private static final int MONTHS_IN_YEAR = 12;

    public CarbonFootprint getCarbonFootprint(QuestionnaireDto dto) {
        CarbonFootprint carbonFootprint = new CarbonFootprint();
        carbonFootprint.setRoommates(dto.getRoommates());
        carbonFootprint.setRoomsInFlat(dto.getRooms());
        carbonFootprint.setSalary(dto.getSalary());

        carbonFootprint.setAirTravel(dto.getAirTravel());
        carbonFootprint.setCountriesTraveled(dto.getCountries());

        carbonFootprint.setElectricityPerYear(dto.getElectricity() * MONTHS_IN_YEAR);
        carbonFootprint.setGasPerYear(dto.getGas() * MONTHS_IN_YEAR);
        carbonFootprint.setHotWaterPerYear(dto.getHotWater() * MONTHS_IN_YEAR);
        return carbonFootprint;
    }
}
