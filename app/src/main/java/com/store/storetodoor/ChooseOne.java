package com.store.storetodoor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChooseOne extends AppCompatActivity {

    //  Button chef_btn, customer_btn, delivery_btn;
    String name;
    CardView chef_card, customer_card, delivery_boy_card;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_one);

        name = getIntent().getStringExtra("home").trim();

        init();

        chef_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChooseOne.this, "chef is clicked", Toast.LENGTH_SHORT).show();
                if (name.equals("email")) {
                    Intent intent = new Intent(ChooseOne.this, ChefLogin.class);
                    startActivity(intent);
                    finish();
                }
                if (name.equals("phone")) {
                    Intent intent = new Intent(ChooseOne.this, ChefLoginPhone.class);
                    startActivity(intent);
                    finish();
                }
                if (name.equals("signup")) {
                    Intent intent = new Intent(ChooseOne.this, ChefRegister.class);
                    startActivity(intent);

                }
            }
        });
//        chef_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(name.equals("email"))
//                {
//                    Intent intent=new Intent(ChooseOne.this,ChefLogin.class);
//                    startActivity(intent);
//                    finish();
//                }
//                if(name.equals("phone"))
//                {
//                    Intent intent=new Intent(ChooseOne.this,ChefLoginPhone.class);
//                    startActivity(intent);
//                    finish();
//                }
//                if(name.equals("signup"))
//                {
//                    Intent intent=new Intent(ChooseOne.this,ChefRegister.class);
//                    startActivity(intent);
//
//                }
//            }
//        });
//
        customer_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.equals("email"))
                {
                    Intent intent=new Intent(ChooseOne.this,Login.class);
                    startActivity(intent);
                    finish();
                }
                if(name.equals("phone"))
                {
                    Intent intent=new Intent(ChooseOne.this,LoginPhone.class);
                    startActivity(intent);
                    finish();
                }
                if(name.equals("signup"))
                {
                    Intent intent=new Intent(ChooseOne.this,Register.class);
                    startActivity(intent);

                }
            }
        });
//        customer_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(name.equals("email"))
//                {
//                    Intent intent=new Intent(ChooseOne.this,Login.class);
//                    startActivity(intent);
//                    finish();
//                }
//                if(name.equals("phone"))
//                {
//                    Intent intent=new Intent(ChooseOne.this,LoginPhone.class);
//                    startActivity(intent);
//                    finish();
//                }
//                if(name.equals("signup"))
//                {
//                    Intent intent=new Intent(ChooseOne.this,Register.class);
//                    startActivity(intent);
//
//                }
//            }
//        });
        delivery_boy_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.equals("email"))
                {
                    Intent intent=new Intent(ChooseOne.this,DeliveryLogin.class);
                    startActivity(intent);
                    finish();
                }
                if(name.equals("phone"))
                {
                    Intent intent=new Intent(ChooseOne.this,DeliveryLoginPhone.class);
                    startActivity(intent);
                    finish();
                }
                if(name.equals("signup"))
                {
                    Intent intent=new Intent(ChooseOne.this,DeliveryRegister.class);
                    startActivity(intent);

                }
            }
        });

//        delivery_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(name.equals("email"))
//                {
//                    Intent intent=new Intent(ChooseOne.this,DeliveryLogin.class);
//                    startActivity(intent);
//                    finish();
//                }
//                if(name.equals("phone"))
//                {
//                    Intent intent=new Intent(ChooseOne.this,DeliveryLoginPhone.class);
//                    startActivity(intent);
//                    finish();
//                }
//                if(name.equals("signup"))
//                {
//                    Intent intent=new Intent(ChooseOne.this,DeliveryRegister.class);
//                    startActivity(intent);
//
//                }
//            }
//        });

    }

    private void init() {

        //   chef_btn = findViewById(R.id.chef_button);
//        customer_btn = findViewById(R.id.customer_button);
//        delivery_btn = findViewById(R.id.delivery_button);
        chef_card = findViewById(R.id.chef_card);
        customer_card = findViewById(R.id.customer_card);
        delivery_boy_card = findViewById(R.id.delivery_boy_card);

    }
}