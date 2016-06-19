package za.samkele.com.eventsmanagementsystem.factories;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import za.samkele.com.eventsmanagementsystem.domain.Event;
import za.samkele.com.eventsmanagementsystem.factories.implimentation.EventFactoryImpl;

/**
 * Created by Samkele on 4/29/2016.
 */
public class EventFactoryTest {
    private EventFactoryImpl eventFactory;

    @Before
    public void setup() throws Exception {
        eventFactory = EventFactoryImpl.getInstance();
    }

    /*@Test
    public void testEmployeeCreation() throws Exception {
        Event employee = eventFactory.createEvent("Lusindiso", "Besiti", "CPUT600216");
        Assert.assertEquals(employee.getEmployeeNumber(), "CPUT600216");
        Assert.assertEquals(employee.getLastName(), "Best");
        Assert.assertEquals(employee.getFirstName(), "Lusindiso");
        Assert.assertNotNull(employee.getEmpId());
    }

    @Test
    public void testEventUpdate() throws Exception {
        Event event = eventFactory.createEmployee("Lusindiso", "Besiti", "CPUT600216");
        Assert.assertEquals(employee.getEmployeeNumber(), "CPUT600216");
        Assert.assertEquals(employee.getLastName(), "Best");
        Assert.assertEquals(employee.getFirstName(), "Lusindiso");
        Assert.assertNotNull(employee.getEmpId());

        //Update LastName

        Event updateEvent = new Event.Builder()
                .copy(event)
                .lastName("Best")
                .build();

        Assert.assertEquals(updateEvent.getLastName(), "Best");
        Assert.assertEquals(event.getEmployeeNumber(), updateEvent.getEmployeeNumber());
        Assert.assertEquals(event.getFirstName(), updateEvent.getFirstName());
        Assert.assertEquals(event.getEmpId(), updateEvent.getEmpId());
    }*/
}
