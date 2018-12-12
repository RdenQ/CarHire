package com.rdenq.carhire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vendor implements Serializable {

    @SerializedName("@Code")
    @Expose
    private String code;
    @SerializedName("@Name")
    @Expose
    private String name;

    /**
     * @param name
     * @param code
     */
    public Vendor(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Vendor withCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vendor withName(String name) {
        this.name = name;
        return this;
    }

}