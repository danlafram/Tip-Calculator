package com.example.team404.seg3125_lab_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;

public class DataDisplay extends AppCompatActivity {

    private int tipValue;
    private int pplValue;
    private double billVal;
    private double totalVal;

    TextView billAmount;
    TextView tipAmount;
    TextView totalAmount;
    TextView eachPersonAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        billAmount = (TextView) findViewById(R.id.textView8); //Small bug where changing the ID of textView would re-arrange UI elements
        tipAmount = (TextView) findViewById(R.id.tipAmount);
        totalAmount = (TextView) findViewById(R.id.totalAmount);
        eachPersonAmount = (TextView) findViewById(R.id.eachPersonAmount);

        Intent i = getIntent();

        tipValue = i.getIntExtra("tip", 15);
        pplValue = i.getIntExtra("people", 4);
        billVal = i.getDoubleExtra("bill", 20.00);
        totalVal = i.getDoubleExtra("total", 23.00);

        billAmount.setText("" + billVal);
        tipAmount.setText("" + billVal*((tipValue/100)));
        totalAmount.setText("" + billVal*((1+(tipValue/100))));
        eachPersonAmount.setText("" + (billVal*((1+(tipValue/100)))/pplValue));


    }

    public void restart(View target){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
