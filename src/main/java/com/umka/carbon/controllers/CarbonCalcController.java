package com.umka.carbon.controllers;

import com.umka.carbon.model.dto.CarbonFootprintDto;
import com.umka.carbon.model.dto.QuestionnaireDto;
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

    @RequestMapping(value = "/carboncalc", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Umka Carbon Calculator!";
    }

    // Calculate carbon footprint
    @RequestMapping(value="/carboncalc", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarbonFootprintDto saveCarbonFootprint(@RequestBody QuestionnaireDto dto) {

        return service.calculateCarbonFootprint(dto);
    }
}
