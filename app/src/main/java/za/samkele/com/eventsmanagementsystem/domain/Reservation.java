package za.samkele.com.eventsmanagementsystem.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Samkele on 4/20/2016.
 */
public class Reservation implements Serializable{
    private Long reserveId;
    private Long custId;
    private Long eventId ;
    private Date reserveDate;
    private double depositDue;
    private double amountPaid;
    private boolean confirmed;

    private Reservation(){

    }

    public Long getReserveId() {
        return reserveId;
    }

    public Long getCustId() {
        return custId;
    }

    public Long getEventId() {
        return eventId;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public double getDepositDue() {
        return depositDue;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public boolean getConfirmed() {
        return confirmed;
    }

    private Reservation(Builder builder){
        this.reserveId = builder.reserveId;
        this.custId = builder.custId;
        this.eventId = builder.eventId;
        this.reserveDate = builder.reserveDate;
        this.depositDue = builder.depositDue;
        this.amountPaid = builder.amountPaid;
        this.confirmed = builder.confirmed;
    }

    public static class Builder {
        private Long reserveId;
        private Long custId;
        private Long eventId ;
        private Date reserveDate;
        private double depositDue;
        private double amountPaid;
        private boolean confirmed;

        public Builder reserveId(Long value) {
            this.reserveId = value;
            return this;
        }

        public Builder custId(Long value) {
            this.custId = value;
            return this;
        }

        public Builder eventId(Long value) {
            this.eventId = value;
            return this;
        }

        public Builder reserveDate(Date value) {
            this.reserveDate = value;
            return this;
        }

        public Builder depositDue(double value) {
            this.depositDue = value;
            return this;
        }

        public Builder amountPaid(double value) {
            this.amountPaid = value;
            return this;
        }

        public Builder confirmed(boolean value) {
            this.confirmed = value;
            return this;
        }

        public Builder copy(Reservation value) {
            this.reserveId = value.reserveId;
            this.custId = value.custId;
            this.eventId = value.eventId;
            this.reserveDate = value.reserveDate;
            this.depositDue = value.depositDue;
            this.amountPaid = value.amountPaid;
            this.confirmed = value.confirmed;
            return this;
        }

        public Reservation build() {
            return new Reservation (this);
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

        Reservation reserve = (Reservation) o;

        if (!reserveId.equals(reserve.reserveId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return reserveId.hashCode();
    }


}
