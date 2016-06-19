package za.samkele.com.eventsmanagementsystem.services.settings;

/**
 * Created by Samkele on 5/14/2016.
 */
public interface ActivateService {
    String activateAccount(String email, String password);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
