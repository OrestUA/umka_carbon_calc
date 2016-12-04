package com.umka.carbon.controllers;

import com.umka.carbon.model.dto.CarbonFootprintStatisticsBundle;
import com.umka.carbon.model.dto.QuestionnaireDto;
import com.umka.carbon.service.CarbonCalcService;
import com.umka.carbon.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ARudyk on 12/3/2016.
 */
@RestController
@CrossOrigin(maxAge = 3600)
public class CarbonCalcController {

    @Autowired
    private CarbonCalcService calcService;
    @Autowired
    private SaveService saveService;

    @RequestMapping(value = "/carbon_footprint", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Umka Carbon Calculator!";
    }

    @RequestMapping(value = "/carbon_footprint", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarbonFootprintStatisticsBundle saveCarbonFootprint(@RequestBody QuestionnaireDto dto) {
        saveService.saveCarbonFootprintInfo(dto);
        return calcService.getStatistics(dto);
    }
}
