package com.rdenq.carhire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleQueryResponse {

    @SerializedName("VehAvailRSCore")
    @Expose
    private VehAvailRSCore vehAvailRSCore;

    /**
     * @param vehAvailRSCore
     */
    public VehicleQueryResponse(VehAvailRSCore vehAvailRSCore) {
        this.vehAvailRSCore = vehAvailRSCore;
    }

    public VehAvailRSCore getVehAvailRSCore() {
        return vehAvailRSCore;
    }

    public void setVehAvailRSCore(VehAvailRSCore vehAvailRSCore) {
        this.vehAvailRSCore = vehAvailRSCore;
    }

    public VehicleQueryResponse withVehAvailRSCore(VehAvailRSCore vehAvailRSCore) {
        this.vehAvailRSCore = vehAvailRSCore;
        return this;
    }

}