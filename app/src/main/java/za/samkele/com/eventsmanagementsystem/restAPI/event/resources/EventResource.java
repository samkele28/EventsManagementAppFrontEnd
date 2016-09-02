package za.samkele.com.eventsmanagementsystem.restAPI.event.resources;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by Samkele on 9/1/2016.
 */
public class EventResource implements Serializable {
    //private Long id;
    private String eventId;
    private String eventName;
    private String eventDescription;
    private Map<String, String> location;
    private Date startDate;
    private Timestamp startTime;
    private int availableSpace;
    private double costPerPerson;
    private String emailAddress;

    private EventResource(){

    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public Map<String, String> getLocation() {
        return location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public double getCostPerPerson() {
        return costPerPerson;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private EventResource(Builder builder){
        this.eventId = builder.eventId;
        this.eventName = builder.eventName;
        this.location = builder.location;
        this.startDate = builder.startDate;
        this.startTime = builder.startTime;
        this.availableSpace = builder.availableSpace;
        this.costPerPerson = builder.costPerPerson;
        this.eventDescription = builder.eventDescription;
        this.emailAddress = builder.emailAddress;
    }

    public static class Builder {
        private String eventId;
        private String eventName;
        private Map<String, String> location;
        private Date startDate;
        private Timestamp startTime;
        private int availableSpace;
        private double costPerPerson;
        private String eventDescription;
        private String emailAddress;

        public Builder eventId(String value) {
            this.eventId = value;
            return this;
        }

        public Builder eventName(String value) {
            this.eventName = value;
            return this;
        }

        public Builder location(Map<String, String> value) {
            this.location = value;
            return this;
        }

        public Builder startDate(Date value) {
            this.startDate = value;
            return this;
        }

        public Builder startTime(Timestamp value) {
            this.startDate = value;
            return this;
        }

        public Builder availableSpace(int value) {
            this.availableSpace = value;
            return this;
        }

        public Builder costPerPerson(double value) {
            this.costPerPerson = value;
            return this;
        }

        public Builder eventDescription(String value) {
            this.eventDescription = value;
            return this;
        }

        public Builder emailAddress(String value){
            this.emailAddress = value;
            return this;
        }

        public Builder copy(EventResource value) {
            this.eventId = value.eventId;
            this.eventName = value.eventName;
            this.location = value.location;
            this.startDate = value.startDate;
            this.startTime = value.startTime;
            this.availableSpace = value.availableSpace;
            this.costPerPerson = value.costPerPerson;
            this.eventDescription = value.eventDescription;
            this.emailAddress = value.emailAddress;
            return this;
        }

        public EventResource build() {
            return new EventResource (this);
        }
    }

}
