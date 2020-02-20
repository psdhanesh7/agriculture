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
import com.google.firebase.auth.FirebaseUser;

public class FarmerSignUpActivity extends AppCompatActivity {

    Button registerButton;
    EditText userName, pass1, pass2;
    FirebaseAuth mAuth;

//    private static final String TAG = "FarmerSignUpActivity";
//    private static final String TAG = "FarmerSignUp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        final String TAG = FarmerSignUpActivity.class.getName();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_sign_up);

        userName = findViewById(R.id.signUpEmail);
        pass1 = findViewById(R.id.signUpPassword1);
        pass2 = findViewById(R.id.signUpPassword2);
        registerButton = findViewById(R.id.registerButton);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),FarmerLogin.class));
            finish();
        }

        registerButton.setOnClickListener(new View.OnClickListener() {
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


                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(FarmerSignUpActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),FarmerLogin.class));

                        }else {
                            Toast.makeText(FarmerSignUpActivity.this, "Error Occured" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                        }
                    }
                });

            }
        });


//        registerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                userName = findViewById(R.id.signUpEmail);
//                pass1 = findViewById(R.id.signUpPassword1);
//                pass2 = findViewById(R.id.signUpPassword2);
//
//                mAuth.createUserWithEmailAndPassword(userName.getText().toString(), pass1.getText().toString())
//                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "createUserWithEmail:success");
//                                    FirebaseUser user = m Auth.getCurrentUser();
////                                    updateUI(user);
//                               } else {
//
//                                    // If sign in fails, display a message to the user.
//                                    //Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                                    //Toast.makeText(FarmerSignUpActivity.this, "Authentication failed.",
////                                            Toast.LENGTH_SHORT).show();
////                                    updateUI(null);
//                                }
//
//                                // ...
//                            }
//                        });
//
//
//            }
//        });




    }


}
