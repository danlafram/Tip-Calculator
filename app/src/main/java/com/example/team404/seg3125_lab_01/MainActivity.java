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

    //All numeric variables

    private int tipValue = 15;
    private int pplValue = 4;


    //All widget variables

    EditText billAmount;

    RadioGroup serviceRate;

    TextView tipPercentage;
    TextView numberOfPeople;

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

        billAmount = (EditText) findViewById(R.id.billAmount);

        serviceRate = (RadioGroup) findViewById(R.id.serviceRateGroup);

        tipIncrease = (ImageButton) findViewById(R.id.tipIncrease);
        tipDecrease = (ImageButton) findViewById(R.id.tipDecrease);
        pplInc = (ImageButton) findViewById(R.id.pplIncrease);
        pplDec = (ImageButton) findViewById(R.id.pplDecrease);
        calculateButton  = (Button) findViewById(R.id.calculateButton);
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
        int bill = Integer.parseInt(billAmount.getText().toString());
        int total = (bill*(tipValue/100)/pplValue);

        Intent i = new Intent(this, DataDisplay.class);
        i.putExtra("bill", bill);
        i.putExtra("total", total);
        i.putExtra("tip", tipValue);
        i.putExtra("people", pplValue);

    }


}
