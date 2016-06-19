package za.samkele.com.eventsmanagementsystem.domain;

/**
 * Created by Samkele on 4/21/2016.
 */
public class CustomerAddress {
    private Long custAddrId;
    private String streetAddress;
    private String surburb;
    private String town;
    private String postalCode;
    private String province;

    private CustomerAddress(){

    }

    public Long getCustAddrId() {
        return custAddrId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getSurburb() {
        return surburb;
    }

    public String getTown() {
        return town;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }
}
