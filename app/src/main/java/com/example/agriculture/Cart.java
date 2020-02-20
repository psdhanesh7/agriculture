package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Cart extends AppCompatActivity {


    TextView itemAndPrice, totalCost;
    private DatabaseReference mDatabase;

//    @IgnoreExtraProperties
//    public class Crops {
//        private String cropsId;
//        private String cropsName;
//        private String cropsQty;
//        private String cropsCost;
//
//
//        public Crops(){
//
//        }
//
//        public Crops(String cropsName, String cropsQty, String cropsCost) {
//            this.cropsId = cropsId;
//            this.cropsName = cropsName;
//            this.cropsQty = cropsQty;
//            this.cropsCost= cropsCost;
//        }
//
//        public String getCropsId() {
//            return cropsId;
//        }
//
//        public String getCropsName() {
//            return cropsName;
//        }
//
//        public String getCropsQty() {
//            return cropsQty;
//        }
//
//        public String getCropsCost() {
//            return cropsCost;
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mDatabase = FirebaseDatabase.getInstance().getReference("path");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                Log.e("Count " ,""+snapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Log.e("Data", postSnapshot.toString());
//                    Crops post = postSnapshot.getValue(Crops.class);
//                    Log.e("Get Data", post.toString());

//                    Crops crop = snapshot.child("cabbage").getValue(Crops.class);
//                    //                      ^^^^^^^^^^^^^^^^
//                    String cost = crop.getCropsCost();
////                    String title = bullet.getTitle();
//                    Log.e("COst", cost);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("The read failed: " ,databaseError.getMessage());
            }
        });


        itemAndPrice = findViewById(R.id.itemAndPrice);
        totalCost = findViewById(R.id.totalCost);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            Set<String> keys = extras.keySet();
            for (String key : keys) {
                Object o = extras.get(key);

                itemAndPrice.setText(key + "\t :  \t" + extras.get(key) );
                Log.e(key, o.toString());

                totalCost.setText(("Total Cost \t : \t" + (Integer.parseInt((extras.get(key).toString()))*40)));

            }
            String value = extras.getString("cabbage");
            //The key argument here must match that used in the other activity
        }

    }




}
