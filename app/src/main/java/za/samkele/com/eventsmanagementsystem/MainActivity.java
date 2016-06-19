package za.samkele.com.eventsmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogout, bContinue;
    EditText etName, etAge, etEmailAddress, etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText)findViewById(R.id.etName);
        etAge = (EditText)findViewById(R.id.etAge);
        etEmailAddress = (EditText)findViewById(R.id.etEmailAddress);
        bLogout = (Button)findViewById(R.id.bLogout);
        bContinue = (Button)findViewById(R.id.bContinue);

        bLogout.setOnClickListener(this);
        bContinue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.bLogout:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.bContinue:
                startActivity(new Intent(this, CustomerDetailsActivity.class));
                break;
        }
    }
}
