package com.example.activity_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button simpleCalc;
    Button advancedCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

    }

    public void initComponents(){
        simpleCalc = findViewById(R.id.simpleCalc);
        advancedCalc = findViewById(R.id.advancedCalc);

        simpleCalc.setOnClickListener(this);
        advancedCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.simpleCalc:
                Intent openSimpleCalculator = new Intent(this, SimpleCalcuActivity.class);
                startActivity(openSimpleCalculator);
                break;
            case R.id.advancedCalc:
                Intent openAdvancedCalculator = new Intent(this, AdvancedCalcuActivity.class);
                startActivity(openAdvancedCalculator);
                break;
        }
    }
}
