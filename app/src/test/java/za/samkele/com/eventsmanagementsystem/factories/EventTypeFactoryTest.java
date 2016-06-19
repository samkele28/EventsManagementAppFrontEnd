package za.samkele.com.eventsmanagementsystem.factories;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import za.samkele.com.eventsmanagementsystem.config.util.DomainState;
import za.samkele.com.eventsmanagementsystem.domain.EventType;
import za.samkele.com.eventsmanagementsystem.factories.implimentation.EventTypeFactoryImpl;

/**
 * Created by Samkele on 6/19/2016.
 */
public class EventTypeFactoryTest {

    private EventTypeFactoryImpl eventTypeFactory;

    @Before
    public void setup() throws Exception {
        eventTypeFactory = EventTypeFactoryImpl.getInstance();
    }

    @Test
    public void testEmployeeCreate() throws Exception {
        EventType eventType = eventTypeFactory.createEventType("Wedding");
        Assert.assertEquals(eventType.getEventTypeName(), "Wedding");
    }

    @Test
    public void testEmployeeUpdate() throws Exception {
        EventType eventType = eventTypeFactory.createEventType("Wedding");
        Assert.assertEquals(eventType.getEventTypeName(), "Wedding");

        //Update

        EventType updateEventType = new EventType.Builder()
                .copy(eventType)
                .eventTypeName("BirthDay Celebration")
                .build();

        Assert.assertEquals(updateEventType.getEventTypeName(), "BirthDay Celebration");
        Assert.assertEquals(DomainState.ACTIVE.name(),updateEventType.getStatus());

    }
}
