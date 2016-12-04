package com.umka.carbon.model.dto;

/**
 * Created by ARudyk on 12/4/2016.
 */
public class CarbonFootprintStatisticsDto {

    private String name;
    private Double amount;

    public CarbonFootprintStatisticsDto() {
    }

    public CarbonFootprintStatisticsDto(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarbonFootprintStatisticsDto that = (CarbonFootprintStatisticsDto) o;

        return Double.compare(that.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(amount);
        return (int) (temp ^ (temp >>> 32));
    }
}
