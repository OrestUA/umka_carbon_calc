package com.umka.carbon.service;

import com.umka.carbon.model.dto.CarbonFootprintDto;
import com.umka.carbon.model.dto.CarbonFootprintStatisticsDto;
import com.umka.carbon.model.dto.QuestionnaireDto;
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
    private static final int MONTHS_IN_YEAR = 12;

    private static final String YOU = "Ти";
    private static final String UKRAINE = "Україна";
    private static final String WORLD = "Світ";

    private static final int UKRAINE_EMISSION = 5500;
    private static final int WORLD_EMISSION = 5000;

    public CarbonFootprintDto calculateCarbonFootprint(QuestionnaireDto dto){
        CarbonFootprintDto resultDto = new CarbonFootprintDto();
        resultDto.setElectricity(dto.getElectricity() * EF_CO2_ELECTRICITY);
        resultDto.setGas(dto.getGas() * EF_CO2_GAS);
        resultDto.setCar(dto.getCarEngineVolume() * EF_CO2_CAR);
        resultDto.setHotWater(dto.getHotWater() * EF_CO2_HOT_WATER);
        return resultDto;
    }

    public List<CarbonFootprintStatisticsDto> calculateCarbonFootprintStatistics(QuestionnaireDto dto){
        List<CarbonFootprintStatisticsDto> results = new ArrayList<>();

        double electricityEmission = dto.getElectricity()* MONTHS_IN_YEAR * EF_CO2_ELECTRICITY;
        double gasEmission = dto.getGas()* MONTHS_IN_YEAR * EF_CO2_GAS;
        double carEmission = dto.getCarEngineVolume() != null ?
                dto.getCarEngineVolume()* dto.getCarDistance() * EF_CO2_CAR : 0;
        double hotWaterEmission = dto.getHotWater() * MONTHS_IN_YEAR * EF_CO2_HOT_WATER;
        double yourTotal = electricityEmission + carEmission + gasEmission + hotWaterEmission;
        results.add(new CarbonFootprintStatisticsDto (YOU, yourTotal) );;
        results.add(new CarbonFootprintStatisticsDto (UKRAINE, UKRAINE_EMISSION));
        results.add(new CarbonFootprintStatisticsDto (WORLD, WORLD_EMISSION));

        return results;
    }
}
