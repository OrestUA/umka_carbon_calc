package com.umka.carbon.service;

import com.umka.carbon.model.dto.CarbonFootprintDto;
import com.umka.carbon.model.dto.QuestionnaireDto;
import com.umka.carbon.repositories.CarbonFootprintRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ARudyk on 12/3/2016.
 */
public class CarbonCalcService {

    private static final int EF_CO2_ELECTRICITY = 816;
    private static final int EF_CO2_GAS = 1953;
    private static final int EF_CO2_HOT_WATER = 1035;
    private static final int EF_CO2_CAR = 216;


    @Autowired
    private CarbonFootprintRepository carbonFootprintRepository;

    public CarbonFootprintDto calculateCarbonFootprint(QuestionnaireDto dto){
        CarbonFootprintDto resultDto = new CarbonFootprintDto();
        resultDto.setElectricity(dto.getElectricity() * EF_CO2_ELECTRICITY);
        resultDto.setGas(dto.getGas() * EF_CO2_GAS);
        resultDto.setCar(dto.getCarEngineVolume() * EF_CO2_CAR);
        resultDto.setHotWater(dto.getHotWater() * EF_CO2_HOT_WATER);
        return resultDto;
    }
}
