package za.samkele.com.eventsmanagementsystem.domain;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by Samkele on 4/20/2016.
 */
public class Event implements Serializable{
    private Long eventId;
    private String eventName;
    private String eventDescription;
    private Map<String, String> location;
    private Date startDate;
    private Timestamp startTime;
    private int availableSpace;
    private double costPerPerson;
    private String emailAddress;

    private Event(){

    }

    public Long getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
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

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    private Event(Builder builder){
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
        private Long eventId;
        private String eventName;
        private Map<String, String> location;
        private Date startDate;
        private Timestamp startTime;
        private int availableSpace;
        private double costPerPerson;
        private String eventDescription;
        private String emailAddress;

        public Builder eventId(Long value) {
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

        public Builder copy(Event value) {
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

        public Event build() {
            return new Event (this);
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

        Event event = (Event) o;

        if (!eventId.equals(event.eventId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return eventId.hashCode();
    }

}
