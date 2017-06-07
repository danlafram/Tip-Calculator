package com.example.team404.seg3125_lab_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import java.text.DecimalFormat;

public class DataDisplay extends AppCompatActivity {

    private int pplValue;
    private double tipValuePercent;
    private double tipValueCash;
    private double billVal;
    private double totalVal;
    private double eachPerson;
    private double totalWithTip;

    TextView billAmount;
    TextView tipAmount;
    TextView totalAmount;
    TextView eachPersonAmount;

    DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        df = new DecimalFormat("#.##");

        billAmount = (TextView) findViewById(R.id.textView8); //Small bug where changing the ID of textView would re-arrange UI elements
        tipAmount = (TextView) findViewById(R.id.tipAmount);
        totalAmount = (TextView) findViewById(R.id.totalAmount);
        eachPersonAmount = (TextView) findViewById(R.id.eachPersonAmount);

        Intent i = getIntent();

        tipValuePercent = i.getDoubleExtra("tip", 15);
        pplValue = i.getIntExtra("people", 4);
        billVal = i.getDoubleExtra("bill", 20.00);
        totalVal = i.getDoubleExtra("total", 23.00);
        eachPerson = billVal*((1+(tipValuePercent/100))/pplValue);

        tipValueCash = billVal*((tipValuePercent/100));
        totalWithTip = billVal*((1+(tipValuePercent/100)));

        billAmount.setText("" + df.format(billVal));
        tipAmount.setText("" + df.format(tipValueCash));
        totalAmount.setText("" + df.format(totalWithTip));
        eachPersonAmount.setText("" + df.format(eachPerson));


    }

    public void settingsTouch(View target){
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }

    public void restart(View target){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
