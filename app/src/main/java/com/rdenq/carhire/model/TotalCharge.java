package com.rdenq.carhire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TotalCharge implements Serializable {

    @SerializedName("@RateTotalAmount")
    @Expose
    private String rateTotalAmount;
    @SerializedName("@EstimatedTotalAmount")
    @Expose
    private String estimatedTotalAmount;
    @SerializedName("@CurrencyCode")
    @Expose
    private String currencyCode;

    /**
     * @param rateTotalAmount
     * @param currencyCode
     * @param estimatedTotalAmount
     */
    public TotalCharge(String rateTotalAmount, String estimatedTotalAmount, String currencyCode) {
        this.rateTotalAmount = rateTotalAmount;
        this.estimatedTotalAmount = estimatedTotalAmount;
        this.currencyCode = currencyCode;
    }

    public String getRateTotalAmount() {
        return rateTotalAmount;
    }

    public void setRateTotalAmount(String rateTotalAmount) {
        this.rateTotalAmount = rateTotalAmount;
    }

    public TotalCharge withRateTotalAmount(String rateTotalAmount) {
        this.rateTotalAmount = rateTotalAmount;
        return this;
    }

    public String getEstimatedTotalAmount() {
        return estimatedTotalAmount;
    }

    public void setEstimatedTotalAmount(String estimatedTotalAmount) {
        this.estimatedTotalAmount = estimatedTotalAmount;
    }

    public TotalCharge withEstimatedTotalAmount(String estimatedTotalAmount) {
        this.estimatedTotalAmount = estimatedTotalAmount;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public TotalCharge withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

}