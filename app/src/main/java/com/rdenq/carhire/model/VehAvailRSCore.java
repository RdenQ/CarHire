package com.rdenq.carhire.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VehAvailRSCore {

    @SerializedName("VehRentalCore")
    @Expose
    private VehRentalCore vehRentalCore;
    @SerializedName("VehVendorAvails")
    @Expose
    private List<VehVendorAvail> vehVendorAvails;

    /**
     * @param vehVendorAvails
     * @param vehRentalCore
     */
    public VehAvailRSCore(VehRentalCore vehRentalCore, List<VehVendorAvail> vehVendorAvails) {
        this.vehRentalCore = vehRentalCore;
        this.vehVendorAvails = vehVendorAvails;
    }

    public VehRentalCore getVehRentalCore() {
        return vehRentalCore;
    }

    public void setVehRentalCore(VehRentalCore vehRentalCore) {
        this.vehRentalCore = vehRentalCore;
    }

    public VehAvailRSCore withVehRentalCore(VehRentalCore vehRentalCore) {
        this.vehRentalCore = vehRentalCore;
        return this;
    }

    public List<VehVendorAvail> getVehVendorAvails() {
        return vehVendorAvails;
    }

    public void setVehVendorAvails(List<VehVendorAvail> vehVendorAvails) {
        this.vehVendorAvails = vehVendorAvails;
    }

    public VehAvailRSCore withVehVendorAvails(List<VehVendorAvail> vehVendorAvails) {
        this.vehVendorAvails = vehVendorAvails;
        return this;
    }

}