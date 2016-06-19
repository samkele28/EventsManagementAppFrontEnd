package za.samkele.com.eventsmanagementsystem.factories.implimentation;

import za.samkele.com.eventsmanagementsystem.config.util.DomainState;
import za.samkele.com.eventsmanagementsystem.domain.EventType;
import za.samkele.com.eventsmanagementsystem.factories.EventTypeFactory;

/**
 * Created by Samkele on 5/14/2016.
 */
public class EventTypeFactoryImpl implements EventTypeFactory {
    private static EventTypeFactoryImpl evTypeFactory = null;

    private EventTypeFactoryImpl(){

    }

    public static EventTypeFactoryImpl getInstance(){
        if(evTypeFactory == null)
            evTypeFactory = new EventTypeFactoryImpl();
        return evTypeFactory;
    }

    public EventType createEventType(String name){
        EventType eventType = new EventType
                .Builder()
                .eventTypeName(name)
                .status(DomainState.ACTIVE.name())
                .build();
        return eventType;
    }

}
