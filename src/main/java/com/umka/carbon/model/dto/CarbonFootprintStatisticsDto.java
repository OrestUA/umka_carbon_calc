package com.umka.carbon.model.dto;

/**
 * Created by ARudyk on 12/4/2016.
 */
public class CarbonFootprintStatisticsDto {

    private String name;
    private double amount;

    public CarbonFootprintStatisticsDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
