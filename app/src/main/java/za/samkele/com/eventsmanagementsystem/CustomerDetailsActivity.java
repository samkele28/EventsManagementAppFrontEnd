package za.samkele.com.eventsmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import za.samkele.com.eventsmanagementsystem.domain.Customer;
import za.samkele.com.eventsmanagementsystem.repository.domain.Implimentation.CustomerRepositoryImpl;

public class CustomerDetailsActivity extends AppCompatActivity {

    Button bSave, bUpdate, bDelete, bView, bPreviousActivity, bNextActivity, bHomeScreen;
    EditText etCustNumber, etCustName, etCustLastName, etStreetAddress, etSurburb, etTown, etPostalCode, etContactNo;
    TextView tvHeading;
    CustomerRepositoryImpl customerRepo;
    Customer customer;

    String customerNumber;
    String customerName;
    String contactLastName;
    String contactNumber;
    String streetAddress;
    String surburb;
    String town;
    String postalCode;
    //String province;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        bPreviousActivity = (Button)findViewById(R.id.bPreviousActivity);
        bNextActivity = (Button)findViewById(R.id.bNextActivity);
        bHomeScreen = (Button)findViewById(R.id.bHomeScreen);
        bSave = (Button)findViewById(R.id.bSave);
        bUpdate = (Button)findViewById(R.id.bUpdate);
        bDelete = (Button)findViewById(R.id.bDelete);
        bView = (Button)findViewById(R.id.bView);
        etCustNumber = (EditText) findViewById(R.id.etCustNumber);
        etCustName = (EditText) findViewById(R.id.etCustName);
        etCustLastName = (EditText) findViewById(R.id.etCustLastName);
        etStreetAddress = (EditText) findViewById(R.id.etStreetAddress);
        etSurburb = (EditText) findViewById(R.id.etSurburb);
        etTown = (EditText) findViewById(R.id.etTown);
        etPostalCode = (EditText) findViewById(R.id.etPostalCode);
        etContactNo = (EditText) findViewById(R.id.etContactNo);
        tvHeading = (TextView) findViewById(R.id.tvHeading);

        customerRepo = new CustomerRepositoryImpl(this);

        Intent intent = getIntent();

        /*customerName = intent.getStringExtra("customerName");
        contactLastName = intent.getStringExtra("contactLastName");
        contactNumber = intent.getStringExtra("contactNumber");*/

        etCustName.setText(getIntent().getExtras().getString("customerName"));
        etCustLastName.setText(getIntent().getExtras().getString("contactLastName"));
        etCustNumber.setText(getIntent().getExtras().getString("contactNumber"));

        addCustomer();
    }

    public void addCustomer(){
        customerNumber = etCustNumber.getText().toString();
        customerName = etCustNumber.getText().toString();
        contactLastName = etCustLastName.getText().toString();
        contactNumber = etCustLastName.getText().toString();
        streetAddress = etCustLastName.getText().toString();
        surburb = etCustLastName.getText().toString();
        town = etCustLastName.getText().toString();
        postalCode = etCustLastName.getText().toString();
        //province = etCustLastName.getText().toString();

        //etCustNumber, etCustName, etCustLastName, etStreetAddress, etSurburb, etTown, etPostalCode, etContactNo;

        //customer = new Customer();

        assert bSave != null;
        bSave.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(customerNumber.matches("") || customerName.matches("") || contactLastName.matches("")){
                            Toast.makeText(getApplicationContext(), "Please enter the required fields", Toast.LENGTH_LONG).show();
                        }
                        else{
                            //customerRepo.save()
                            //.etCustNumber.getText().toString(), etCustNumber.getText().toString(), etCustLastName.getText().toString();
                        }
                    }
                }
        );

    }
}
