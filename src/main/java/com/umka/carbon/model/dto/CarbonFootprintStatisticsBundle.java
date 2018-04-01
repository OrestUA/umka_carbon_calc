package com.umka.carbon.model.dto;

import java.util.List;

/**
 * Created by ARudyk on 12/4/2016.
 */
public class CarbonFootprintStatisticsBundle {
    private List<CarbonFootprintStatisticsDto> barChart;
    private List<CarbonFootprintStatisticsDto> pieChart;
    private QuestionnaireDto userInput;

    public CarbonFootprintStatisticsBundle() {
    }

    public List<CarbonFootprintStatisticsDto> getBarChart() {
        return barChart;
    }

    public void setBarChart(List<CarbonFootprintStatisticsDto> barChart) {
        this.barChart = barChart;
    }

    public List<CarbonFootprintStatisticsDto> getPieChart() {
        return pieChart;
    }

    public void setPieChart(List<CarbonFootprintStatisticsDto> pieChart) {
        this.pieChart = pieChart;
    }

    public QuestionnaireDto getUserInput() {
        return userInput;
    }

    public void setUserInput(QuestionnaireDto userInput) {
        this.userInput = userInput;
    }
}
