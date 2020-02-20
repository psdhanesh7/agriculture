package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FarmerPage extends AppCompatActivity {

    ImageButton sellProduct, connectAgriDept;
    Button dropDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CardView cardView1,cardView2;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_page);

        dropDown = findViewById(R.id.dropDownButton);
        sellProduct = findViewById(R.id.sellProductButton);
        connectAgriDept = findViewById(R.id.connectWithAgriDept);

        cardView1 = findViewById(R.id.AddcorpsCard);
        cardView2 = findViewById(R.id.SoldDetailsCard);

        sellProduct.setVisibility(View.INVISIBLE);
        connectAgriDept.setVisibility(View.INVISIBLE);



        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(FarmerPage.this,AddCorpsActivity.class);
                startActivity(in);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(FarmerPage.this,SoldDetailsActivity.class);
                startActivity(in);
            }
        });


    }

    public void onDropDownClick(View view){

        dropDown.setVisibility(View.INVISIBLE);

        sellProduct.setVisibility(View.VISIBLE);
        connectAgriDept.setVisibility(View.VISIBLE);

        sellProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Sell Product", "Sell product button pressed");
            }
        });

        connectAgriDept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Agriculture Dept", "Connect with agricultural dept");
            }
        });


    }
}
