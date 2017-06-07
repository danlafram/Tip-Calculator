package com.example.team404.seg3125_lab_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void returnHome(View target){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}
