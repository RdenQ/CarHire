package com.rdenq.carhire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vehicle implements Serializable {

    @SerializedName("@AirConditionInd")
    @Expose
    private String airConditionInd;
    @SerializedName("@TransmissionType")
    @Expose
    private String transmissionType;
    @SerializedName("@FuelType")
    @Expose
    private String fuelType;
    @SerializedName("@DriveType")
    @Expose
    private String driveType;
    @SerializedName("@PassengerQuantity")
    @Expose
    private String passengerQuantity;
    @SerializedName("@BaggageQuantity")
    @Expose
    private String baggageQuantity;
    @SerializedName("@Code")
    @Expose
    private String code;
    @SerializedName("@CodeContext")
    @Expose
    private String codeContext;
    @SerializedName("@DoorCount")
    @Expose
    private String doorCount;
    @SerializedName("VehMakeModel")
    @Expose
    private VehMakeModel vehMakeModel;
    @SerializedName("PictureURL")
    @Expose
    private String pictureURL;
    @SerializedName("@Size")
    @Expose
    private String size;

    /**
     * *
     * * @param airConditionInd
     *
     * @param baggageQuantity
     * @param fuelType
     * @param vehMakeModel
     * @param transmissionType
     * @param codeContext
     * @param driveType
     * @param doorCount
     * @param code
     * @param pictureURL
     * @param passengerQuantity
     * @param size
     */
    public Vehicle(String airConditionInd, String transmissionType, String fuelType, String driveType, String passengerQuantity, String baggageQuantity, String code, String codeContext, String doorCount, VehMakeModel vehMakeModel, String pictureURL, String size) {
        this.airConditionInd = airConditionInd;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
        this.driveType = driveType;
        this.passengerQuantity = passengerQuantity;
        this.baggageQuantity = baggageQuantity;
        this.code = code;
        this.codeContext = codeContext;
        this.doorCount = doorCount;
        this.vehMakeModel = vehMakeModel;
        this.pictureURL = pictureURL;
        this.size = size;
    }

    public String getAirConditionInd() {
        return airConditionInd.equals("true") ? "Yes" : "No";
    }

    public void setAirConditionInd(String airConditionInd) {
        this.airConditionInd = airConditionInd;
    }

    public Vehicle withAirConditionInd(String airConditionInd) {
        this.airConditionInd = airConditionInd;
        return this;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public Vehicle withTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
        return this;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Vehicle withFuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public Vehicle withDriveType(String driveType) {
        this.driveType = driveType;
        return this;
    }

    public String getPassengerQuantity() {
        return passengerQuantity;
    }

    public void setPassengerQuantity(String passengerQuantity) {
        this.passengerQuantity = passengerQuantity;
    }

    public Vehicle withPassengerQuantity(String passengerQuantity) {
        this.passengerQuantity = passengerQuantity;
        return this;
    }

    public String getBaggageQuantity() {
        return baggageQuantity;
    }

    public void setBaggageQuantity(String baggageQuantity) {
        this.baggageQuantity = baggageQuantity;
    }

    public Vehicle withBaggageQuantity(String baggageQuantity) {
        this.baggageQuantity = baggageQuantity;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Vehicle withCode(String code) {
        this.code = code;
        return this;
    }

    public String getCodeContext() {
        return codeContext;
    }

    public void setCodeContext(String codeContext) {
        this.codeContext = codeContext;
    }

    public Vehicle withCodeContext(String codeContext) {
        this.codeContext = codeContext;
        return this;
    }

    public String getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(String doorCount) {
        this.doorCount = doorCount;
    }

    public Vehicle withDoorCount(String doorCount) {
        this.doorCount = doorCount;
        return this;
    }

    public VehMakeModel getVehMakeModel() {
        return vehMakeModel;
    }

    public void setVehMakeModel(VehMakeModel vehMakeModel) {
        this.vehMakeModel = vehMakeModel;
    }

    public Vehicle withVehMakeModel(VehMakeModel vehMakeModel) {
        this.vehMakeModel = vehMakeModel;
        return this;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Vehicle withPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
        return this;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Vehicle withSize(String size) {
        this.size = size;
        return this;
    }

}