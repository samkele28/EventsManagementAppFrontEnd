package za.samkele.com.eventsmanagementsystem.factories;

import org.junit.Before;
import org.junit.Test;
//import junit.framework.Assert;
import org.junit.Assert;

import za.samkele.com.eventsmanagementsystem.domain.Employee;
import za.samkele.com.eventsmanagementsystem.factories.implimentation.EmployeeFactoryImpl;

/**
 * Created by Samkele on 4/20/2016.
 */
public class EmployeeFactoryTest {

    private EmployeeFactoryImpl empFactory;

    @Before
    public void setup() throws Exception {
        empFactory = EmployeeFactoryImpl.getInstance();
    }

    @Test
    public void testEmployeeCreate() throws Exception {
        Employee employee = empFactory.createEmployee("Lusindiso", "Besiti", "CPUT600216");
        //Assert.assertEquals(employee.getEmployeeNumber(), "CPUT600216");
        Assert.assertEquals(employee.getLastName(), "Besiti");
        /*Assert.assertEquals(employee.getFirstName(), "Lusindiso");
        Assert.assertNotNull(employee.getEmpId());*/
    }

    @Test
    public void testEmployeeUpdate() throws Exception {
        Employee employee = empFactory.createEmployee("Lusindiso", "Besiti", "CPUT600216");
        //Assert.assertEquals(employee.getEmployeeNumber(), "CPUT600216");
        Assert.assertEquals(employee.getLastName(), "Besiti");
        /*Assert.assertEquals(employee.getFirstName(), "Lusindiso");
        Assert.assertNotNull(employee.getEmpId());*/

        //Update LastName

        Employee updateEmployee = new Employee.Builder()
                .copy(employee)
                .lastName("Best")
                .build();

        Assert.assertEquals(updateEmployee.getLastName(), "Best");
        /*Assert.assertEquals(employee.getEmployeeNumber(), updateEmployee.getEmployeeNumber());
        Assert.assertEquals(employee.getFirstName(), updateEmployee.getFirstName());
        Assert.assertEquals(employee.getEmpId(), updateEmployee.getEmpId());*/
    }

}
