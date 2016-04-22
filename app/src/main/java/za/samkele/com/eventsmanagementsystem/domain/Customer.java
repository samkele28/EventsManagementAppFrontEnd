package za.samkele.com.eventsmanagementsystem.domain;

import java.io.Serializable;

/**
 * Created by Samkele on 4/20/2016.
 */
public class Customer implements Serializable{
    private Long custId;
    private String customerName;
    private String contactLastName;
    private String contactNumber;

    private Customer(){

    }

    public Long getCustId(){
        return custId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getContactLastName(){
        return contactLastName;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    private Customer(Builder builder){
        this.custId = builder.custId;
        this.customerName = builder.customerName;
        this.contactLastName = builder.contactLastName;
        this.contactNumber = builder.contactNumber;
    }

    public static class Builder {
        private Long custId;
        private String customerName;
        private String contactLastName;
        private String contactNumber;

        public Builder custId(Long value) {
            this.custId = value;
            return this;
        }

        public Builder customerName(String value) {
            this.customerName = value;
            return this;
        }

        public Builder contactLastName(String value) {
            this.contactLastName = value;
            return this;
        }

        public Builder contactNumber(String value) {
            this.contactNumber = value;
            return this;
        }

        public Builder copy(Customer value) {
            this.custId = value.custId;
            this.customerName = value.customerName;
            this.contactLastName = value.contactLastName;
            this.contactNumber = value.contactNumber;
            return this;
        }

        public Customer build() {
            return new Customer (this);
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

        Customer customer = (Customer) o;

        if (!custId.equals(customer.custId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return custId.hashCode();
    }

}
