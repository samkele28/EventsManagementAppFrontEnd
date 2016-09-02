package za.samkele.com.eventsmanagementsystem.factories;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import junit.framework.Assert;
import static org.junit.Assert.*;

import za.samkele.com.eventsmanagementsystem.domain.Customer;
import za.samkele.com.eventsmanagementsystem.factories.implimentation.CustomerFactoryImpl;

/**
 * Created by Samkele on 4/21/2016.
 */
public class CustomerFactoryTest {
    private CustomerFactoryImpl custFactory;

    @Before
    public void setup() throws Exception {
        custFactory = CustomerFactoryImpl.getInstance();
    }

    @Test
    public void testCustomerCreate() throws Exception {
        Customer customer = custFactory.createCustomer("Woolworths Pty Ltd", "Best", "0832784460");
        Assert.assertEquals(customer.getCustomerName(), "Woolworths Pty Ltd");
        Assert.assertEquals(customer.getContactLastName(), "Best");
        Assert.assertEquals(customer.getContactNumber(), "0832784460");
        Assert.assertNotNull(customer.getCustId());
    }

    @Test
    public void testCustomerUpdate() throws Exception {
        Customer customer = custFactory.createCustomer("Woolworths Pty Ltd", "Best", "0832784460");
        Assert.assertEquals(customer.getCustomerName(), "Woolworths Pty Ltd");
        Assert.assertEquals(customer.getContactLastName(), "Best");
        Assert.assertEquals(customer.getContactNumber(), "0832784460");
        Assert.assertNotNull(customer.getCustId());

        //Update

        Customer updateCustomer = new Customer.Builder()
                .copy(customer)
                .customerName("Woolworths (Pty) Ltd")
                .build();

        Assert.assertEquals(updateCustomer.getCustomerName(), "Woolworths (Pty) Ltd");
        Assert.assertEquals(customer.getContactLastName(), updateCustomer.getContactLastName());
        Assert.assertEquals(customer.getContactNumber(), updateCustomer.getContactNumber());
        Assert.assertEquals(customer.getCustId(), updateCustomer.getCustId());
    }
}
