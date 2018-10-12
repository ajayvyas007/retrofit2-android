package com.example.ajay.crownstack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ajay.crownstack.model.Data;

public class ItemDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);


        if (getIntent()!=null){
            Data data = getIntent().getParcelableExtra("item");
            if(data!=null) {
                TextView dataview = findViewById(R.id.data);
                dataview.setText(String.valueOf(data.getArtistId()) + "\n" +
                        data.getArtistName() + "\n" +
                        data.getArtistViewUrl() + "\n" +
                        data.getReleaseDate()
                );
            }
            else {
                Log.e("dataDetails","Null");
            }
        }
    }
}
