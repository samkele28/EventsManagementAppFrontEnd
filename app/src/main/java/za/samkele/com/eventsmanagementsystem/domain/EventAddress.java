package za.samkele.com.eventsmanagementsystem.domain;

import java.io.Serializable;

/**
 * Created by Samkele on 4/21/2016.
 */
public class EventAddress implements Serializable{
    private Long eventAddrId;
    private String streetAddress;
    private String surburb;
    private String town;
    private String postalCode;
    private String province;

    private EventAddress(){

    }

    public Long getEventAddrId() {
        return eventAddrId;
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

    public EventAddress(Builder builder){
        this.eventAddrId = builder.eventAddrId;
        this.streetAddress = builder.streetAddress;
        this.surburb = builder.surburb;
        this.town = builder.town;
        this.postalCode = builder.postalCode;
        this.province = builder.province;
    }

    public static class Builder{
        private Long eventAddrId;
        private String streetAddress;
        private String surburb;
        private String town;
        private String postalCode;
        private String province;

        public Builder eventAddrId(Long value){
            this.eventAddrId = value;
            return this;
        }

        public Builder streetAddress(String value){
            this.streetAddress = value;
            return this;
        }

        public Builder surburb(String value){
            this.surburb = value;
            return this;
        }

        public Builder town(String value){
            this.town = value;
            return this;
        }

        public Builder postalCode(String value){
            this.postalCode = value;
            return this;
        }

        public Builder province(String value){
            this.province = value;
            return this;
        }

        public Builder copy(EventAddress value){
            this.eventAddrId = value.eventAddrId;
            this.streetAddress = value.streetAddress;
            this.surburb = value.surburb;
            this.town = value.surburb;
            this.postalCode = value.postalCode;
            this.province = value.province;
            return this;
        }

        public EventAddress build() {
            return new EventAddress (this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EventAddress address = (EventAddress) o;

        if (!eventAddrId.equals(address.eventAddrId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return eventAddrId.hashCode();
    }

}
