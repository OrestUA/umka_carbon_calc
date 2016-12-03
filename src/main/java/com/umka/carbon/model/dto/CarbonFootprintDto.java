package com.umka.carbon.model.dto;

/**
 * Created by ARudyk on 12/3/2016.
 */
public class CarbonFootprintDto {

    private double electricity;
    private double gas;
    private double car;
    private double hotWater;

    public CarbonFootprintDto() {
    }

    public double getElectricity() {
        return electricity;
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public double getCar() {
        return car;
    }

    public void setCar(double car) {
        this.car = car;
    }

    public double getHotWater() {
        return hotWater;
    }

    public void setHotWater(double hotWater) {
        this.hotWater = hotWater;
    }
}
