package com.example.team404.seg3125_lab_01;

import android.graphics.Color;
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

    //All numeric variables

    private double tipValue = 15;
    private int pplValue = 4;


    //All widget variables

    EditText billAmount;

    RadioGroup serviceRate;

    TextView tipPercentage;
    TextView numberOfPeople;
    TextView badText;
    TextView goodText;
    TextView greatText;

    ImageButton badService;
    ImageButton goodService;
    ImageButton greatService;
    ImageButton tipIncrease;
    ImageButton tipDecrease;
    ImageButton pplInc;
    ImageButton pplDec;

    Button calculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipPercentage = (TextView) findViewById(R.id.tipPercentageTxt);
        numberOfPeople = (TextView) findViewById(R.id.numberPeopleTxt);
        badText = (TextView) findViewById(R.id.badText);
        goodText = (TextView) findViewById(R.id.goodText);
        greatText = (TextView) findViewById(R.id.greatText);

        billAmount = (EditText) findViewById(R.id.billAmount);

        serviceRate = (RadioGroup) findViewById(R.id.serviceRateGroup);

        tipIncrease = (ImageButton) findViewById(R.id.tipIncrease);
        tipDecrease = (ImageButton) findViewById(R.id.tipDecrease);
        pplInc = (ImageButton) findViewById(R.id.pplIncrease);
        pplDec = (ImageButton) findViewById(R.id.pplDecrease);
        badService = (ImageButton) findViewById(R.id.badService);
        goodService = (ImageButton) findViewById(R.id.goodService);
        greatService = (ImageButton) findViewById(R.id.greatService);

        calculateButton  = (Button) findViewById(R.id.calculateButton);
    }

    public void badServiceTouch(View target){
        badText.setTextColor(Color.parseColor("#FFFF4081"));
        goodText.setTextColor(Color.parseColor("#FFFFFFFF"));
        greatText.setTextColor(Color.parseColor("#FFFFFFFF"));
        tipValue = 10;
        tipPercentage.setText(String.valueOf(tipValue));
    }

    public void goodServiceTouch(View target){
        badText.setTextColor(Color.parseColor("#FFFFFFFF"));
        goodText.setTextColor(Color.parseColor("#FFFF4081"));
        greatText.setTextColor(Color.parseColor("#FFFFFFFF"));
        tipValue = 15;
        tipPercentage.setText(String.valueOf(tipValue));
    }

    public void greatServiceTouch(View target){
        badText.setTextColor(Color.parseColor("#FFFFFFFF"));
        goodText.setTextColor(Color.parseColor("#FFFFFFFF"));
        greatText.setTextColor(Color.parseColor("#FFFF4081"));
        tipValue = 20;
        tipPercentage.setText(String.valueOf(tipValue));
    }

    public void settingsTouch(View target){
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }



    /*
     * Increases value of tip by 5%
     */
    public void incTip(View target){
        tipValue += 5;
        tipPercentage.setText(String.valueOf(tipValue));
    }

    /*
     * Decreases value of tip by 5%
     */
    public void decTip(View target){
        if(tipValue == 5){
            //Do nothing, can't tip negative or 0%
        } else {
            tipValue -= 5;
            tipPercentage.setText(String.valueOf(tipValue));
        }
    }

    /*
     * Increases value of number of people by 1
     */
    public void incPpl(View target){
        pplValue++;
        numberOfPeople.setText(String.valueOf(pplValue));
    }


    /*
     * Decreases value of number of people by 1
     */
    public void decPpl(View target){
        if(pplValue == 1){
            //Do nothing, cannot have 0 or negative number of people
        } else {
            pplValue--;
            numberOfPeople.setText(String.valueOf(pplValue));
        }
    }

    /*
     * Calculates tip based on entered values and starts new activity
     */
    public void calculateTip(View target){
        double bill = Double.parseDouble( billAmount.getText().toString() );
        double total = (bill*(1+(tipValue/100)));

        Intent i = new Intent(this, DataDisplay.class);
        i.putExtra("bill", bill);
        i.putExtra("total", total);
        i.putExtra("tip", tipValue);
        i.putExtra("people", pplValue);
        startActivity(i);

    }


}
