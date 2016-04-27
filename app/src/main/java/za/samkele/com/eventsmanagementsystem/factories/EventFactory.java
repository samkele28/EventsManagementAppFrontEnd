package za.samkele.com.eventsmanagementsystem.factories;

import java.util.Date;

import za.samkele.com.eventsmanagementsystem.domain.Event;

/**
 * Created by Samkele on 4/27/2016.
 */
public interface EventFactory {
    Event createEvent(String name, String description, Date date);
}
