/*package za.samkele.com.eventsmanagementsystem.factories;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import za.samkele.com.eventsmanagementsystem.config.util.DomainState;
import za.samkele.com.eventsmanagementsystem.domain.EventAddress;
import za.samkele.com.eventsmanagementsystem.factories.implimentation.EventAddressFactoryImpl;

/**
 * Created by Samkele on 6/19/2016.
 */
/*public class EventAddressFactoryTest {
    private EventAddressFactoryImpl eventAddressFactory;

    @Before
    public void setup() throws Exception {
        eventAddressFactory = EventAddressFactoryImpl.getInstance();
    }

    @Test
    public void testEmployeeCreate() throws Exception {
        EventAddress eventAddress = eventAddressFactory.getAddress("11202 Colosa Crescent", "Phillipi", "7750");
        Assert.assertEquals(eventAddress.getStreetAddress(), "11202 Colosa Crescent");
    }

    @Test
    public void testEmployeeUpdate() throws Exception {
        EventAddress eventAddress = eventAddressFactory.getAddress("11202 Colosa Crescent", "Phillipi", "7750");
        Assert.assertEquals(eventAddress.getStreetAddress(), "11202 Colosa Crescent");

        //Update

        EventAddress updateEventAddress = new EventAddress.Builder()
                .copy(eventAddress)
                .streetAddress("334 Acacia Street")
                .build();

        Assert.assertEquals(updateEventAddress.getStreetAddress(), "334 Acacia Street");
        //Assert.assertEquals(DomainState.ACTIVE.name(),updateEventAddress.getStatus);
    }
}*/
