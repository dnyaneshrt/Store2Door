package com.store.storetodoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {


    Button btn_sign_email, btn_sign_phone, btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        init();
        btn_sign_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ChooseOne.class);
                intent.putExtra("home", "email");
                startActivity(intent);
            //    finish();
            }
        });
        btn_sign_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ChooseOne.class);
                intent.putExtra("home", "phone");
                startActivity(intent);
                //finish();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ChooseOne.class);
                intent.putExtra("home", "signup");
                startActivity(intent);
               // finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    private void init() {

        btn_sign_email = findViewById(R.id.btn_siginin_email);
        btn_sign_phone = findViewById(R.id.btn_siginin_phone);
        btn_signup = findViewById(R.id.btn_sign_up);

    }
}