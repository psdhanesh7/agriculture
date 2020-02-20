package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



//    String email;
    Button customerLogin, farmerLogin;
//    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mAuth = FirebaseAuth.getInstance();
        farmerLogin = findViewById(R.id.farmerLogin);
        customerLogin = findViewById(R.id.customerLogin);

        farmerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fLogin = new Intent(MainActivity.this, FarmerLogin.class);
                startActivity(fLogin);

//                Log.e("Farmer Login", "Farmer Login successful");
//                Toast.makeText(getApplicationContext(), "Farmer Login succesful", Toast.LENGTH_SHORT).show();
            }
        });

        customerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Customer Login", "Customer Login Successful");
                Intent cLogin = new Intent(MainActivity.this, CustomerLogin.class);
                startActivity(cLogin);
                Log.e("sfds", "dfssffsf");
            }
        });

    }

}
