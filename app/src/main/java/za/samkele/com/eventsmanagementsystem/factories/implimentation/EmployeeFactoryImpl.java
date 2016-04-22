package za.samkele.com.eventsmanagementsystem.factories.implimentation;

import za.samkele.com.eventsmanagementsystem.domain.Employee;
import za.samkele.com.eventsmanagementsystem.factories.EmployeeFactory;
//import java.util.UUID;
/**
 * Created by Samkele on 4/20/2016.
 */
public class EmployeeFactoryImpl implements EmployeeFactory{
    private static EmployeeFactoryImpl empFactory = null;

    private EmployeeFactoryImpl(){

    }

    public static EmployeeFactoryImpl getInstance(){
        if(empFactory == null)
            empFactory = new EmployeeFactoryImpl();
        return empFactory;
    }

    public Employee createEmployee(String firstName, String lastName, String employeeNumber){
        Employee employee = new Employee
                .Builder()
                .firstName(firstName)
                .lastName(lastName)
                .employeeNumber(employeeNumber)
                .build();
        return employee;
    }

}
