package com.umka.carbon.service;

import com.umka.carbon.model.dto.CarbonFootprintDto;
import com.umka.carbon.model.dto.CarbonFootprintStatisticsDto;
import com.umka.carbon.model.dto.QuestionnaireDto;
import com.umka.carbon.repositories.CarbonFootprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARudyk on 12/3/2016.
 */
@Service
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

    public List<CarbonFootprintStatisticsDto> calculateCarbonFootprintStatistics(QuestionnaireDto dto){
//        CarbonFootprintDto resultDto = new CarbonFootprintDto();
//        resultDto.setElectricity(dto.getElectricity() * EF_CO2_ELECTRICITY);
//        resultDto.setGas(dto.getGas() * EF_CO2_GAS);
//        resultDto.setCar(dto.getCarEngineVolume() * EF_CO2_CAR);
//        resultDto.setHotWater(dto.getHotWater() * EF_CO2_HOT_WATER);

        List<CarbonFootprintStatisticsDto> results = new ArrayList<>();

        CarbonFootprintStatisticsDto yourStatistic = new CarbonFootprintStatisticsDto();
        double electricityEmission = dto.getElectricity() * EF_CO2_ELECTRICITY;
        double gasEmission = dto.getGas() * EF_CO2_GAS;
        double carEmission = dto.getCarEngineVolume() * EF_CO2_CAR;
        double hotWaterEmission = dto.getHotWater() * EF_CO2_HOT_WATER;
        double yourTotal = electricityEmission + carEmission + gasEmission + hotWaterEmission;
        yourStatistic.setName("Ти");
        yourStatistic.setAmount(yourTotal);
        results.add(yourStatistic);

        CarbonFootprintStatisticsDto ukraineStatistic = new CarbonFootprintStatisticsDto();
        ukraineStatistic.setName("Україна");
        ukraineStatistic.setAmount(5500);
        results.add(ukraineStatistic);

        CarbonFootprintStatisticsDto worldStatistic = new CarbonFootprintStatisticsDto();
        worldStatistic.setName("Світ");
        worldStatistic.setAmount(5000);
        results.add(worldStatistic);

        return results;
    }
}
