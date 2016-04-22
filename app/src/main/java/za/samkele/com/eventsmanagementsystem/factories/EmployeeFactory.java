package za.samkele.com.eventsmanagementsystem.factories;

import za.samkele.com.eventsmanagementsystem.domain.Employee;
/**
 * Created by Samkele on 4/20/2016.
 */
public interface EmployeeFactory {
    Employee createEmployee(String firstName, String lastName, String employeeNumber);
}
