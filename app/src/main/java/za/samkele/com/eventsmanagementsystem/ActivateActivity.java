package za.samkele.com.eventsmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivateActivity extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etName, etAge, etEmailAddress, etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate);
        etName =(EditText)findViewById(R.id.etName);
        etAge =(EditText)findViewById(R.id.etAge);
        etEmailAddress=(EditText)findViewById(R.id.etEmailAddress);
        etUsername =(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);

        /*activateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Do something in response to button click
                Log.d("EMAIL",emailAddress.getText().toString());
                Log.d("PASS",password.getText().toString());
                Log.d("CODE",orgcode.getText().toString());


            }
        });

/*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate);
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);

        // Listening to Login Screen link
        assert loginScreen != null;
        loginScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Closing registration screen
                // Switching to Login Screen/closing register screen
                finish();
            }
        });*/
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.bRegister:
                // Do something in response to button click
                Log.d("USERNAME",etUsername.getText().toString());
                Log.d("PASSWORD",etPassword.getText().toString());
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this, ActivateActivity.class));
                break;
        }
    }
}
