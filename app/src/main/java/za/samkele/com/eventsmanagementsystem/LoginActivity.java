package za.samkele.com.eventsmanagementsystem;

import android.content.Intent;
//import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);

        /*TextView registerScreen = (TextView) findViewById(R.id.activateButton);

        // Listening to register new account link
        assert registerScreen != null;
        registerScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), ActivateActivity.class);
                startActivity(i);
            }
        });*/
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.bLogin:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this, ActivateActivity.class));
                break;
        }
    }
}
