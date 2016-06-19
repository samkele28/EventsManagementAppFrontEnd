package za.samkele.com.eventsmanagementsystem.factories;

import java.io.Serializable;

import za.samkele.com.eventsmanagementsystem.domain.EventType;

/**
 * Created by Samkele on 5/14/2016.
 */
public interface EventTypeFactory {
    EventType createEventType(String name);
}
