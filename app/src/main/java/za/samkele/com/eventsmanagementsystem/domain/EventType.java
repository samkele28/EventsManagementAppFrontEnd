package za.samkele.com.eventsmanagementsystem.domain;

import java.io.Serializable;

/**
 * Created by Samkele on 4/21/2016.
 */
public class EventType implements Serializable{
    private Long eventTypeId;
    private String eventTypeName;
    private String status;

    private EventType(){

    }

    public Long getEventTypeId() {
        return eventTypeId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public String getStatus() {
        return status;
    }

    public EventType(Builder builder){
        this.eventTypeId = builder.eventTypeId;
        this.eventTypeName = builder.eventTypeName;
        this.status = builder.status;
    }

    public static class Builder{
        private Long eventTypeId;
        private String eventTypeName;
        private String status;

        public Builder eventTypeId(Long eventTypeId){
            this.eventTypeId = eventTypeId;
            return this;
        }

        public Builder eventTypeName(String eventTypeName){
            this.eventTypeName = eventTypeName;
            return this;
        }

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Builder copy(EventType value){
            this.eventTypeId = value.eventTypeId;
            this.eventTypeName = value.eventTypeName;
            this.status = value.status;
            return this;
        }

        public EventType build() {
            return new EventType (this);
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

        EventType type = (EventType) o;

        if (!eventTypeId.equals(type.eventTypeId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return eventTypeId.hashCode();
    }


}
