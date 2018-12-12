package com.rdenq.carhire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PickUpLocation {

    @SerializedName("@Name")
    @Expose
    private String name;

    /**
     * @param name
     */
    public PickUpLocation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PickUpLocation withName(String name) {
        this.name = name;
        return this;
    }

}