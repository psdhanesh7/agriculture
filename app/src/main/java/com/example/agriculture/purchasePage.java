package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class purchasePage extends AppCompatActivity {

    EditText quantity;
    ImageButton addToCart;

//    HashMap<String, String> cartItems = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_page);

        quantity = findViewById(R.id.editText);
        addToCart = findViewById(R.id.addToCart);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cartItems.put("cabbage", quantity.getText().toString());
//                startActivity(new Intent(getApplicationContext(),CstmrDashBoard.class));
                Intent myIntent = new Intent(purchasePage.this, CstmrDashBoard.class);
//                Log.e("sd", quantity.getText().toString());
                String s=quantity.getText().toString();
               myIntent.putExtra("cabbage",s);

                startActivity(myIntent);
            }
        });
    }
}
