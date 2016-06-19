package za.samkele.com.eventsmanagementsystem.factories;

import za.samkele.com.eventsmanagementsystem.domain.settings.Settings;

/**
 * Created by Samkele on 5/14/2016.
 */
public class SettingsFactory {
    public static Settings getSettings(String username,String password){
        Settings settings = new Settings.Builder()
                .username(username)
                .password(password)
                .build();
        return settings;
    }
}
