package za.samkele.com.eventsmanagementsystem.services.settings.Implimentation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ActivateStubService extends Service {
    public ActivateStubService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
