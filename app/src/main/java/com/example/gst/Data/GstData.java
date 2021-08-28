package com.example.gst.Data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class GstData implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gstNumber")
    @Expose
    private String gstNumber;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("tax_type")
    @Expose
    private String taxType;
    @SerializedName("business_type")
    @Expose
    private String businessType;
    @SerializedName("registration_date")
    @Expose
    private String registrationDate;
    @SerializedName("state_jurisdiction")
    @Expose
    private String stateJurisdiction;
    @SerializedName("centre_jurisdiction")
    @Expose
    private String centreJurisdiction;



    /**
     * No args constructor for use in serialization
     *
     */
    public GstData() {
    }

    /**
     *
     * @param gstNumber
     * @param address
     * @param registrationDate
     * @param name
     * @param businessType
     * @param taxType
     * @param status
     */
    public GstData(String name, String gstNumber, String status, String address, String taxType, String businessType, String registrationDate) {
        super();
        this.name = name;
        this.gstNumber = gstNumber;
        this.status = status;
        this.address = address;
        this.taxType = taxType;
        this.businessType = businessType;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    public String getStateJurisdiction() {
        return stateJurisdiction;
    }

    public void setStateJurisdiction(String stateJurisdiction) {
        this.stateJurisdiction = stateJurisdiction;
    }

    public String getCentreJurisdiction() {
        return centreJurisdiction;
    }

    public void setCentreJurisdiction(String centreJurisdiction) {
        this.centreJurisdiction = centreJurisdiction;
    }
}
