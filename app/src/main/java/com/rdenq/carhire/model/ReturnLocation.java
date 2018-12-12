package com.rdenq.carhire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReturnLocation {

    @SerializedName("@Name")
    @Expose
    private String name;

    /**
     * @param name
     */
    public ReturnLocation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReturnLocation withName(String name) {
        this.name = name;
        return this;
    }

}