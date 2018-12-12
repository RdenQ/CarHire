package com.rdenq.carhire.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehVendorAvail {

    @SerializedName("Vendor")
    @Expose
    private Vendor vendor;
    @SerializedName("VehAvails")
    @Expose
    private List<VehAvail> vehAvails = new ArrayList<VehAvail>();

    /**
     * @param vehAvails
     * @param vendor
     */
    public VehVendorAvail(Vendor vendor, List<VehAvail> vehAvails) {
        this.vendor = vendor;
        this.vehAvails = vehAvails;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public VehVendorAvail withVendor(Vendor vendor) {
        this.vendor = vendor;
        return this;
    }

    public List<VehAvail> getVehAvails() {
        return vehAvails;
    }

    public void setVehAvails(List<VehAvail> vehAvails) {
        this.vehAvails = vehAvails;
    }

    public VehVendorAvail withVehAvails(List<VehAvail> vehAvails) {
        this.vehAvails = vehAvails;
        return this;
    }

}