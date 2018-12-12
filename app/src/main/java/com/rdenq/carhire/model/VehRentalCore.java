package com.rdenq.carhire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VehRentalCore {

    @SerializedName("@PickUpDateTime")
    @Expose
    private String pickUpDateTime;
    @SerializedName("@ReturnDateTime")
    @Expose
    private String returnDateTime;
    @SerializedName("PickUpLocation")
    @Expose
    private PickUpLocation pickUpLocation;
    @SerializedName("ReturnLocation")
    @Expose
    private ReturnLocation returnLocation;

    /**
     * @param pickUpLocation
     * @param returnDateTime
     * @param pickUpDateTime
     * @param returnLocation
     */
    public VehRentalCore(String pickUpDateTime, String returnDateTime, PickUpLocation pickUpLocation, ReturnLocation returnLocation) {
        this.pickUpDateTime = pickUpDateTime;
        this.returnDateTime = returnDateTime;
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
    }

    public String getPickUpDateTime() {
        String friendlyDateTime = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = formatter.parse(pickUpDateTime);
            friendlyDateTime = date.toString().substring(0, date.toString().indexOf("GMT") - 4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return friendlyDateTime;
    }

    public void setPickUpDateTime(String pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    public VehRentalCore withPickUpDateTime(String pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
        return this;
    }

    public String getReturnDateTime() {
        String friendlyDateTime = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = formatter.parse(returnDateTime);
            friendlyDateTime = date.toString().substring(0, date.toString().indexOf("GMT") - 4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return friendlyDateTime;
    }

    public void setReturnDateTime(String returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public VehRentalCore withReturnDateTime(String returnDateTime) {
        this.returnDateTime = returnDateTime;
        return this;
    }

    public PickUpLocation getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(PickUpLocation pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public VehRentalCore withPickUpLocation(PickUpLocation pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
        return this;
    }

    public ReturnLocation getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(ReturnLocation returnLocation) {
        this.returnLocation = returnLocation;
    }

    public VehRentalCore withReturnLocation(ReturnLocation returnLocation) {
        this.returnLocation = returnLocation;
        return this;
    }

}