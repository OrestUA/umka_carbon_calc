package com.umka.carbon.controllers;

import com.umka.carbon.model.CarbonFootprint;
import com.umka.carbon.repositories.CarbonFootprintRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ARudyk on 12/3/2016.
 */
@RestController
public class CarbonCalcController {

    @Autowired
    private
    CarbonFootprintRepository carbonFootprintRepository;

    @RequestMapping("/carboncalc")
    public String index() {
        return "Greetings from Umka Carbon Calculator!";
    }

    // Save carbon footprint
    @RequestMapping("/carboncalc/create")
    @ResponseBody
    public String saveCarbonFootprint(String title, int year) {
        CarbonFootprint carbonFootprint = new CarbonFootprint();
        try {
            carbonFootprintRepository.save(carbonFootprint);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "creation successful: " + String.valueOf(carbonFootprint.getId());
    }

}
