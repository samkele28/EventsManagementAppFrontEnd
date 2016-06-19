package za.samkele.com.eventsmanagementsystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import za.samkele.com.eventsmanagementsystem.factories.CustomerFactoryTest;
import za.samkele.com.eventsmanagementsystem.factories.EmployeeFactoryTest;
import za.samkele.com.eventsmanagementsystem.factories.EventFactoryTest;

/**
 * Created by Samkele on 5/14/2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CustomerFactoryTest.class,
        EmployeeFactoryTest.class,
        EventFactoryTest.class
})
public class AppUnitTestSuite {
}
