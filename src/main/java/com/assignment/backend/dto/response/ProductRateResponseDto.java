package com.assignment.backend.dto.response;

public class ProductRateResponseDto {
    private int id;
    private double rate;

    /**
     * 
     */
    public ProductRateResponseDto() {
    }

    /**
     * @param id
     * @param rate
     */
    public ProductRateResponseDto(int id, double rate) {
        this.id = id;
        this.rate = rate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

}
