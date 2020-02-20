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

public class FarmerLogin extends AppCompatActivity {
//    Button FarmerLoginButton;
    EditText userName, pass1;
    FirebaseAuth mAuth;

    Button farmerLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_login);

        mAuth = FirebaseAuth.getInstance();

        farmerLoginButton = findViewById(R.id.farmerLoginButton);
        userName = findViewById(R.id.farmerUserName);
        pass1 = findViewById(R.id.farmerPassword);

        farmerLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userName.getText().toString().trim();
                String password = pass1.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    userName.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    pass1.setError("Password is Required");
                    return;
                }
                if(password.length() < 6){
                    pass1.setError("Password must be greater than 6 characters");
                    return;
                }



                Log.e("Login", "Login Initiated");

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(FarmerLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),FarmerPage.class));

                        }else {
                            Toast.makeText(FarmerLogin.this, "Error Occured" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                        }
                    }
                });

                Log.e("Login", "Login Completed");
            }
        });





//        farmerLoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("Farmer Login", "farmer Login Succesful");
//
//                Intent farmerPage = new Intent(FarmerLogin.this, FarmerPage.class);
//                startActivity(farmerPage);
//            }
//        });
    }
}
