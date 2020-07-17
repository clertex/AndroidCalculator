package com.example.activity_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SimpleCalcuActivity extends AppCompatActivity implements View.OnClickListener{

    EditText simpleOutput;
    Button simple1, simple2, simple3, simple4, simple5, simple6, simple7, simple8, simple9, simple0;
    Button simplePlus, simpleMinus, simpleDivide, simpleTimes;
    Button simpleDot, simpleDelete, simpleEquals;

    Boolean add = false, minus = false, times = false, divide = false;
    Boolean dotToggled = false;
    float var1, var2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calcu);
        initComponents();

    }

    public void initComponents(){
        simpleOutput = findViewById(R.id.simpleOutput);
        simple1 = findViewById(R.id.simple1);
        simple2 = findViewById(R.id.simple2);
        simple3 = findViewById(R.id.simple3);
        simple4 = findViewById(R.id.simple4);
        simple5 = findViewById(R.id.simple5);
        simple6 = findViewById(R.id.simple6);
        simple7 = findViewById(R.id.simple7);
        simple8 = findViewById(R.id.simple8);
        simple9 = findViewById(R.id.simple9);
        simple0 = findViewById(R.id.simple0);
        simpleDot = findViewById(R.id.simpleDot);
        simplePlus = findViewById(R.id.simplePlus);
        simpleMinus = findViewById(R.id.simpleMinus);
        simpleDivide = findViewById(R.id.simpleDivide);
        simpleTimes = findViewById(R.id.simpleTimes);
        simpleDelete = findViewById(R.id.simpleDelete);
        simpleEquals = findViewById(R.id.simpleEquals);

        simple1.setOnClickListener(this);
        simple2.setOnClickListener(this);
        simple3.setOnClickListener(this);
        simple4.setOnClickListener(this);
        simple5.setOnClickListener(this);
        simple6.setOnClickListener(this);
        simple7.setOnClickListener(this);
        simple8.setOnClickListener(this);
        simple9.setOnClickListener(this);
        simple0.setOnClickListener(this);
        simpleDot.setOnClickListener(this);
        simplePlus.setOnClickListener(this);
        simpleMinus.setOnClickListener(this);
        simpleDivide.setOnClickListener(this);
        simpleTimes.setOnClickListener(this);
        simpleDelete.setOnClickListener(this);
        simpleEquals.setOnClickListener(this);
    }
    public void outputHolder(String input){
        simpleOutput.setText(simpleOutput.getText() + input);
    }
    public void calcA(float var1A, float var2A){
        if (add == true){
            simpleOutput.setText(var1A + var2A + "");
            add = false;
        }
        if (minus == true){
            simpleOutput.setText(var1A - var2A + "");
            minus = false;
        }
        if (times == true){
            simpleOutput.setText(var1A * var2A + "");
            times = false;
        }
        if (divide == true){
            simpleOutput.setText(var1A / var2A + "");
            divide = false;
        }
    }
    public void calcB(int var1B, int var2B){
        if (add == true){
            simpleOutput.setText(var1B + var2B + "");
            add = false;
        }
        if (minus == true){
            simpleOutput.setText(var1B - var2B + "");
            minus = false;
        }
        if (times == true){
            simpleOutput.setText(var1B * var2B + "");
            times = false;
        }
        if (divide == true){
            simpleOutput.setText(var1B / var2B + "");
            divide = false;
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.simple1:
                outputHolder("1");
                break;
            case R.id.simple2:
                outputHolder("2");
                break;
            case R.id.simple3:
                outputHolder("3");
                break;
            case R.id.simple4:
                outputHolder("4");
                break;
            case R.id.simple5:
                outputHolder("5");
                break;
            case R.id.simple6:
                outputHolder("6");
                break;
            case R.id.simple7:
                outputHolder("7");
                break;
            case R.id.simple8:
                outputHolder("8");
                break;
            case R.id.simple9:
                outputHolder("9");
                break;
            case R.id.simple0:
                outputHolder("0");
                break;
            case R.id.simpleDot:
                outputHolder(".");
                dotToggled = true;
                break;
            case R.id.simplePlus:
                add = true;
                var1 = Float.parseFloat(simpleOutput.getText() + "");
                simpleOutput.setText("");
                break;
            case R.id.simpleMinus:
                minus = true;
                var1 = Float.parseFloat(simpleOutput.getText() + "");
                simpleOutput.setText("");
                break;
            case R.id.simpleTimes:
                times = true;
                var1 = Float.parseFloat(simpleOutput.getText() + "");
                simpleOutput.setText("");
                break;
            case R.id.simpleDivide:
                divide = true;
                var1 = Float.parseFloat(simpleOutput.getText() + "");
                simpleOutput.setText("");
                break;
            case R.id.simpleEquals:
                var2 = Float.parseFloat(simpleOutput.getText() + "");

                int var1B;
                int var2B;

                if (dotToggled ==  true){
                    calcA(var1, var2);
                }
                else if (dotToggled ==  false){
                    var1B = Math.round(var1);
                    var2B = Math.round(var2);
                    calcB(var1B, var2B);
                }
                dotToggled = false;
                break;
            case R.id.simpleDelete:
                simpleOutput.setText("");
                dotToggled = false;
                break;
        }

    }
}
