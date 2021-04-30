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

public class DeliveryLoginPhone extends AppCompatActivity {

    EditText num;
    Button sendotp, signinemail;
    TextView txtsignup;
    CountryCodePicker cpp;
    FirebaseAuth FAuth;
    String numberr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_login_phone);

        num = (EditText) findViewById(R.id.delivery_login_number);
        sendotp = (Button) findViewById(R.id.delivery_login_phone_otp_button);
        cpp = (CountryCodePicker) findViewById(R.id.delivery_login_phone_CountryCode);

        signinemail = (Button) findViewById(R.id.delivery_phone_btnEmail);
        txtsignup = (TextView) findViewById(R.id.delivery_login_phone_signphone);

        FAuth = FirebaseAuth.getInstance();

        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberr = num.getText().toString().trim();
                String phonenumber = cpp.getSelectedCountryCodeWithPlus() + numberr;
                Intent b = new Intent(DeliveryLoginPhone.this, Delivery_SendOtp.class);
                b.putExtra("phonenumber", phonenumber);
                startActivity(b);
              //  finish();

            }
        });


        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DeliveryLoginPhone.this, DeliveryRegister.class);
                startActivity(a);
            //    finish();
            }
        });

        signinemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent em = new Intent(DeliveryLoginPhone.this, DeliveryLogin.class);
                startActivity(em);
             //   finish();
            }
        });

    }
}
