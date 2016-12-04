package com.umka.carbon.controllers;

import com.umka.carbon.model.dto.CarbonFootprintStatisticsDto;
import com.umka.carbon.model.dto.QuestionnaireDto;
import com.umka.carbon.service.CarbonCalcService;
import com.umka.carbon.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ARudyk on 12/3/2016.
 */
@RestController
public class CarbonCalcController {

    @Autowired
    private CarbonCalcService calcService;
    @Autowired
    private SaveService saveService;

    @RequestMapping(value = "/carbon_footprint", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Umka Carbon Calculator!";
    }

    // Calculate carbon footprint
//    @RequestMapping(value="/carboncalc", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public CarbonFootprintDto saveCarbonFootprint(@RequestBody QuestionnaireDto dto) {
//
//        return calcService.calculateCarbonFootprint(dto);
//    }

    @RequestMapping(value = "/carbon_footprint", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarbonFootprintStatisticsDto> saveCarbonFootprint(@RequestBody QuestionnaireDto dto) {
        saveService.saveCarbonFootprintInfo(dto);
        return calcService.calculateCarbonFootprintStatistics(dto);
    }
}
