package com.rdenq.carhire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VehAvail implements Serializable {

    @SerializedName("@Status")
    @Expose
    private String status;
    @SerializedName("Vehicle")
    @Expose
    private Vehicle vehicle;
    @SerializedName("TotalCharge")
    @Expose
    private TotalCharge totalCharge;

    private Vendor vendor;

    /**
     * @param totalCharge
     * @param status
     * @param vehicle
     */
    public VehAvail(String status, Vehicle vehicle, TotalCharge totalCharge) {
        this.status = status;
        this.vehicle = vehicle;
        this.totalCharge = totalCharge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public VehAvail withStatus(String status) {
        this.status = status;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehAvail withVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public TotalCharge getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(TotalCharge totalCharge) {
        this.totalCharge = totalCharge;
    }

    public VehAvail withTotalCharge(TotalCharge totalCharge) {
        this.totalCharge = totalCharge;
        return this;
    }

}