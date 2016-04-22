package za.samkele.com.eventsmanagementsystem.factories.implimentation;

//import java.util.UUID;

import za.samkele.com.eventsmanagementsystem.domain.Customer;
import za.samkele.com.eventsmanagementsystem.factories.CustomerFactory;

/**
 * Created by Samkele on 4/20/2016.
 */
public class CustomerFactoryImpl implements CustomerFactory{
    private static CustomerFactoryImpl custFactory = null;

    private CustomerFactoryImpl(){

    }

    public static CustomerFactoryImpl getInstance(){
        if(custFactory == null)
            custFactory = new CustomerFactoryImpl();
        return custFactory;
    }

    public Customer createCustomer(String customerName, String contactLastName, String contactNumber){
        Customer customer = new Customer
                .Builder()
                .customerName(customerName)
                .contactLastName(contactLastName)
                .contactNumber(contactNumber)
                .build();
        return customer;
    }
}
