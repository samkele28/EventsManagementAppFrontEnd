package za.samkele.com.eventsmanagementsystem.factories;

import junit.framework.Assert;

import org.junit.Test;

import za.samkele.com.eventsmanagementsystem.domain.settings.Settings;
import za.samkele.com.eventsmanagementsystem.factories.SettingsFactory;

/**
 * Created by Samkele on 5/14/2016.
 */
public class SettingsFactoryTest {
    @Test
    public void testCreate() throws Exception{
        Settings settings = SettingsFactory.getSettings("w7063843", "console");
        Assert.assertEquals(settings.getUsername(), "w7063843");
    }

    @Test
    public void testUpdate() throws Exception {
        Settings settings = SettingsFactory.getSettings("w7063843", "console");
        Settings newSettings = new Settings
                .Builder()
                .copy(settings)
                .username("w7063844")
                .build();
        Assert.assertEquals("w7063844",newSettings.getUsername());
    }

}
