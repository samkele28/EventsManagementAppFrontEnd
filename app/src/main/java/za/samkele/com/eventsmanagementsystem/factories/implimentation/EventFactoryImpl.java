package za.samkele.com.eventsmanagementsystem.factories.implimentation;

import java.util.Date;

import za.samkele.com.eventsmanagementsystem.domain.Event;
import za.samkele.com.eventsmanagementsystem.factories.EventFactory;

/**
 * Created by Samkele on 4/26/2016.
 */
public class EventFactoryImpl implements EventFactory{
    private static EventFactoryImpl evFactory = null;

    private EventFactoryImpl(){

    }

    public static EventFactoryImpl getInstance(){
        if(evFactory == null)
            evFactory = new EventFactoryImpl();
        return evFactory;
    }

    public Event createEvent(String name, String description, Date date){
        Event event = new Event
                .Builder()
                .eventName(name)
                .eventDescription(description)
                .startDate(date)
                .build();
        return event;
    }
}
