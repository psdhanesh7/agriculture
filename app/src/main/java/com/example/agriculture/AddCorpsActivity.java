package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Random;

public class AddCorpsActivity extends AppCompatActivity {

    Button saveCrop ;
    EditText cropName, cost, quantity;

    private DatabaseReference mDatabase;

    @IgnoreExtraProperties
    public class Crops {
        private String cropsId;
        private String cropsName;
        private String cropsQty;
        private String cropsCost;


        public Crops(){

        }

        public Crops(String cropsName, String cropsQty, String cropsCost) {
            this.cropsId = cropsId;
            this.cropsName = cropsName;
            this.cropsQty = cropsQty;
            this.cropsCost= cropsCost;
        }

        public String getCropsId() {
            return cropsId;
        }

        public String getCropsName() {
            return cropsName;
        }

        public String getCropsQty() {
            return cropsQty;
        }

        public String getCropsCost() {
            return cropsCost;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_corps);

        saveCrop = findViewById(R.id.saveCrop);
        cropName = findViewById(R.id.cropName);
        cost = findViewById(R.id.cost);
        quantity = findViewById(R.id.quantity);

        mDatabase = FirebaseDatabase.getInstance().getReference("path");

        saveCrop.setOnClickListener(new View.OnClickListener() {

            Random rand = new Random();
            int rand1 = rand.nextInt(1000);

            @Override
            public void onClick(View v) {

                Crops crop = new Crops(cropName.getText().toString(), quantity.getText().toString(), cost.getText().toString());
                mDatabase.child(Integer.toString(rand1)).setValue(crop);
            }
        });

    }
}
