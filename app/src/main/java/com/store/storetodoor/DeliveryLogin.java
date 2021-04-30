package com.store.storetodoor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DeliveryLogin extends AppCompatActivity {

    TextInputLayout email, pass;
    Button Signin, Signinphone;
    TextView Forgotpassword;
    TextView txt;
    FirebaseAuth FAuth;
    String em;
    String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_login);

        email = (TextInputLayout) findViewById(R.id.Lemail_dl);
        pass = (TextInputLayout) findViewById(R.id.Lpassword_dl);

        Signin = (Button) findViewById(R.id.Login_button_dl);
        txt = (TextView) findViewById(R.id.textView3_dl);
        Forgotpassword = (TextView) findViewById(R.id.forgotpass_dl);
        Signinphone = (Button) findViewById(R.id.lbtnphone_dl);

        FAuth = FirebaseAuth.getInstance();

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                em = email.getEditText().getText().toString().trim();
                pwd = pass.getEditText().getText().toString().trim();
                if (isValid()) {
                    final ProgressDialog mDialog = new ProgressDialog(DeliveryLogin.this);
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.setCancelable(false);
                    mDialog.setMessage("Logging in...");
                    mDialog.show();
                    FAuth.signInWithEmailAndPassword(em, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                mDialog.dismiss();
                                if (FAuth.getCurrentUser().isEmailVerified()) {
                                    mDialog.dismiss();
                                    Toast.makeText(DeliveryLogin.this, "You are logged in", Toast.LENGTH_SHORT).show();
                                    Intent z = new Intent(DeliveryLogin.this, Delivery_FoodPanelBottomNavigation.class);
                                    startActivity(z);
                                    finish();


                                } else {
                                    ReusableCodeForAll.ShowAlert(DeliveryLogin.this, "", "Please Verify your Email");
                                }

                            } else {

                                mDialog.dismiss();
                                ReusableCodeForAll.ShowAlert(DeliveryLogin.this, "Error", task.getException().getMessage());
                            }
                        }
                    });
                }

            }
        });

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Register = new Intent(DeliveryLogin.this, DeliveryRegister.class);
                startActivity(Register);
                finish();

            }
        });

        Forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DeliveryLogin.this, Delivery_ForgotPassword.class);
                startActivity(a);
                finish();

            }
        });

        Signinphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(DeliveryLogin.this, DeliveryLoginPhone.class);
                startActivity(q);
                finish();
            }
        });
    }

    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public boolean isValid() {
        email.setErrorEnabled(false);
        email.setError("");
        pass.setErrorEnabled(false);
        pass.setError("");

        boolean isvalidemail = false, isvalidpassword = false, isvalid = false;
        if (TextUtils.isEmpty(em)) {
            email.setErrorEnabled(true);
            email.setError("Email is required");
        } else {
            if (em.matches(emailpattern)) {
                isvalidemail = true;
            } else {
                email.setErrorEnabled(true);
                email.setError("Enter a valid Email Address");
            }

        }
        if (TextUtils.isEmpty(pwd)) {
            pass.setErrorEnabled(true);
            pass.setError("Password is required");
        } else {
            isvalidpassword = true;
        }
        isvalid = (isvalidemail && isvalidpassword) ? true : false;
        return isvalid;
    }
}
