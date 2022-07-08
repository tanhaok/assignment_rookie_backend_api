package com.assignment.backend.dto.response;

import com.assignment.backend.data.entities.Product;
import com.assignment.backend.data.entities.ProductImage;
import com.assignment.backend.utils.Utils;

public class ProductSimpleResponseDto {
    private int proId;
    private String name;
    private double price;
    private int amount;
    private double rate;
    private String thumbnail;

    /**
     * 
     */
    public ProductSimpleResponseDto() {
    }

    /**
     * @param proId
     * @param name
     * @param price
     * @param amount
     * @param rate
     * @param thumbnail
     */
    public ProductSimpleResponseDto(int proId, String name, double price, int amount, double rate, String thumbnail) {
        this.proId = proId;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.rate = rate;
        this.thumbnail = thumbnail;
    }

    public ProductSimpleResponseDto build(Product pro) {
        String thumb = "";
        if (!pro.getProductImages().isEmpty())
            for (ProductImage img : pro.getProductImages()) {
                thumb = img.getImgUrl();
                break;
            }

        return new ProductSimpleResponseDto(pro.getProId(), pro.getName(), pro.getPrice(), pro.getAmount(),
                Utils.rate(pro.getProductRates()), thumb);
    }

    /**
     * @return the proId
     */
    public int getProId() {
        return proId;
    }

    /**
     * @param proId the proId to set
     */
    public void setProId(int proId) {
        this.proId = proId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
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

    /**
     * @return the thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail the thumbnail to set
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
