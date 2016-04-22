package za.samkele.com.eventsmanagementsystem.factories;

import za.samkele.com.eventsmanagementsystem.domain.Customer;
/**
 * Created by Samkele on 4/20/2016.
 */
public interface CustomerFactory {
    Customer createCustomer(String companyName, String contactLastName, String contactNumber);
}
