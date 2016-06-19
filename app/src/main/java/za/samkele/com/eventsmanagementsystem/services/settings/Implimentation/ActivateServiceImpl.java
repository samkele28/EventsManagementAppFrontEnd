package za.samkele.com.eventsmanagementsystem.services.settings.Implimentation;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import za.samkele.com.eventsmanagementsystem.config.util.App;
import za.samkele.com.eventsmanagementsystem.config.util.DomainState;
import za.samkele.com.eventsmanagementsystem.domain.settings.Settings;
import za.samkele.com.eventsmanagementsystem.factories.SettingsFactory;
import za.samkele.com.eventsmanagementsystem.repository.settings.Implimentation.SettingsRepositoryImpl;
import za.samkele.com.eventsmanagementsystem.repository.settings.SettingsRepository;
import za.samkele.com.eventsmanagementsystem.services.settings.ActivateService;

public class ActivateServiceImpl extends Service implements ActivateService{

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private SettingsRepository repo;

    public ActivateServiceImpl() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateServiceImpl getService() {
            return ActivateServiceImpl.this;
        }
    }


    @Override
    public String activateAccount(String username, String password) {
        if (true) {
            Settings settings = SettingsFactory.getSettings(username, password);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public boolean isAccountActivated() {
        return repo.findAll().size()>0;
    }

    @Override
    public boolean deactivateAccount() {
        int rows = repo.deleteAll();
        return rows > 0;

    }

    private Settings createSettings(Settings settings) {
        repo = new SettingsRepositoryImpl(App.getAppContext());
        return repo.save(settings);
    }
}
