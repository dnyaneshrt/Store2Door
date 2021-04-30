package com.store.storetodoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;

public class ChefLoginPhone extends AppCompatActivity {

    EditText num;
    Button sendotp,signinemail;
    TextView txtsignup;
    CountryCodePicker cpp;
    FirebaseAuth FAuth;
    String numberr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_login_phone);
        init();
        FAuth=FirebaseAuth.getInstance();

        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberr=num.getText().toString().trim();
                String phonenumber= cpp.getSelectedCountryCodeWithPlus() + numberr;
                Intent b=new Intent(ChefLoginPhone.this,Chefsendotp.class);
                b.putExtra("phonenumber",phonenumber);
                startActivity(b);
         //       finish();

            }
        });

        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(ChefLoginPhone.this,ChefRegister.class);
                startActivity(a);
              //  finish();
            }
        });

        signinemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent em=new Intent(ChefLoginPhone.this, ChefLogin.class);
                startActivity(em);
              //  finish();
            }
        });

    }

    private void init() {

        num=(EditText)findViewById(R.id.chef_login_number);
        sendotp=(Button)findViewById(R.id.chef_login_phone_otp_button);
        cpp=(CountryCodePicker)findViewById(R.id.chef_login_phone_CountryCode);
        signinemail=(Button)findViewById(R.id.chef_login_phone_btnEmail);
        txtsignup=(TextView)findViewById(R.id.chef_login_phone_acsignup);

    }
}