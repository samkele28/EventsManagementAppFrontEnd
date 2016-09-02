package za.samkele.com.eventsmanagementsystem.restAPI.event.api;

import java.io.IOException;
import java.util.Set;

import za.samkele.com.eventsmanagementsystem.restAPI.event.resources.EventResource;

/**
 * Created by Samkele on 9/1/2016.
 */
public interface EventAPI {
    Set<EventResource> getEvents(String name) throws IOException;
}
