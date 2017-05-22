package com.example.team404.seg3125_lab_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText billAmount = (EditText) findViewById(R.id.billAmount);

        RadioGroup serviceRate = (RadioGroup) findViewById(R.id.serviceRateGroup);

        TextView numberOfPeople = (TextView) findViewById(R.id.numberPeopleTxt);
        TextView tipPercentage = (TextView) findViewById(R.id.tipPercentageTxt);

        ImageButton tipIncrease = (ImageButton) findViewById(R.id.tipIncrease);
        ImageButton tipDecrease = (ImageButton) findViewById(R.id.tipDecrease);
        ImageButton pplInc = (ImageButton) findViewById(R.id.pplIncrease);
        ImageButton pplDec= (ImageButton) findViewById(R.id.pplDecrease);

        Button calculateButton = (Button) findViewById(R.id.calculateButton);


    }

    public static void incTip(){

    }

    public static void decTip(){

    }

    public static void incPpl(){

    }

    public static void decPpl(){
        
    }


}
