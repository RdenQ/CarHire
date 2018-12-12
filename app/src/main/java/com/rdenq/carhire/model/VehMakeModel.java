package com.rdenq.carhire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VehMakeModel implements Serializable {

    @SerializedName("@Name")
    @Expose
    private String name;

    /**
     * @param name
     */
    public VehMakeModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehMakeModel withName(String name) {
        this.name = name;
        return this;
    }

}
