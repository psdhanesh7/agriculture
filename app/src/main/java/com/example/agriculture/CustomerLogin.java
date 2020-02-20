package com.example.agriculture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CustomerLogin extends AppCompatActivity {

    EditText customerUserName, customerPassword;
    Button customerLoginButton;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        customerUserName = findViewById(R.id.customerUserName);
        customerPassword = findViewById(R.id.customerPassword);

        mAuth = FirebaseAuth.getInstance();



        customerLoginButton = findViewById(R.id.customerLoginButton);
        customerLoginButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String email = customerUserName.getText().toString().trim();
                    String password = customerPassword.getText().toString().trim();

                    if(TextUtils.isEmpty(email)){
                        customerUserName.setError("Email is Required");
                        return;
                    }
                    if (TextUtils.isEmpty(password)){
                        customerLoginButton.setError("Password is Required");
                        return;
                    }
                    if(password.length() < 6){
                        customerLoginButton.setError("Password must be greater than 6 characters");
                        return;
                    }



                    Log.e("Login", "Login Initiated");

                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(CustomerLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),CstmrDashBoard.class));

                            }else {
                                Toast.makeText(CustomerLogin.this, "Error Occured" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                            }
                        }
                    });

                    Log.e("Login", "Login Completed");
                }

//                Log.e("Customer Login", "Customer Login Successful");

        });
    }
}
