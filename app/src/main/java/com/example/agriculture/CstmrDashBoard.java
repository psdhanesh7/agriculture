package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.HashMap;

public class CstmrDashBoard extends AppCompatActivity {

    ImageButton cabbagePurchaseButton,cartFinal;
    ImageButton cartButton;

    HashMap<String, String> cartItems = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cstmr_dash_board);

        cartButton = findViewById(R.id.cartButton);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String value = extras.getString("cabbage");
            cartItems.put("cabbage", value);
            //The key argument here must match that used in the other activity
        }

        for (String item : cartItems.keySet()){
            Log.e(item, cartItems.get(item));
        }


//        Log.e("cabbage", cartItems.get("cabbage"));


        cartFinal=findViewById(R.id.CartFinalise);

        cabbagePurchaseButton = findViewById(R.id.cabbagePurchaseButton);
        cabbagePurchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Cabbage ", "cabbage selected");
                startActivity(new Intent(getApplicationContext(),purchasePage.class));


            }
        });

        cartFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(CstmrDashBoard.this,CartActivity.class);
//                startActivity(intent);
                Log.e("sdfds", "Button Clicked");
            }
        });

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CstmrDashBoard.this,Cart.class);

                for (String item : cartItems.keySet()){
                    Log.e(item, cartItems.get(item));
                    intent.putExtra(item, cartItems.get(item));
                }


                startActivity(intent);
            }
        });
    }
}
