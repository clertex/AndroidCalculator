package com.example.activity_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class AdvancedCalcuActivity extends AppCompatActivity implements View.OnClickListener{

    EditText advancedOutput;
    Button advanced1, advanced2, advanced3, advanced4, advanced5, advanced6, advanced7,
            advanced8, advanced9, advanced0;
    Button advancedDot, advancedComma;
    Button advancedMean, advancedMedian, advancedMode;
    Button advancedDelete, advancedEquals;

    Boolean dotToggled = false;
    Boolean meanToggled = false, medianToggled = false, modeToggled = false;

    String numbersArray[];
    float mean, median, mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calcu);
        initComponents();
    }

    public void initComponents(){
        advancedOutput = findViewById(R.id.advancedOutput);
        advanced1 = findViewById(R.id.advanced1);
        advanced2 = findViewById(R.id.advanced2);
        advanced3 = findViewById(R.id.advanced3);
        advanced4 = findViewById(R.id.advanced4);
        advanced5 = findViewById(R.id.advanced5);
        advanced6 = findViewById(R.id.advanced6);
        advanced7 = findViewById(R.id.advanced7);
        advanced8 = findViewById(R.id.advanced8);
        advanced9 = findViewById(R.id.advanced9);
        advanced0 = findViewById(R.id.advanced0);
        advancedDot = findViewById(R.id.advancedDot);
        advancedComma = findViewById(R.id.advancedComma);
        advancedMean = findViewById(R.id.advancedMean);
        advancedMedian = findViewById(R.id.advancedMedian);
        advancedMode = findViewById(R.id.advancedMode);
        advancedDelete = findViewById(R.id.advancedDelete);
        advancedEquals = findViewById(R.id.advancedEquals);

        advanced1.setOnClickListener(this);
        advanced2.setOnClickListener(this);
        advanced3.setOnClickListener(this);
        advanced4.setOnClickListener(this);
        advanced5.setOnClickListener(this);
        advanced6.setOnClickListener(this);
        advanced7.setOnClickListener(this);
        advanced8.setOnClickListener(this);
        advanced9.setOnClickListener(this);
        advanced0.setOnClickListener(this);
        advancedDot.setOnClickListener(this);
        advancedComma.setOnClickListener(this);
        advancedMean.setOnClickListener(this);
        advancedMedian.setOnClickListener(this);
        advancedMode.setOnClickListener(this);
        advancedDelete.setOnClickListener(this);
        advancedEquals.setOnClickListener(this);
    }

    public void outputHolder(String input){
        advancedOutput.setText(advancedOutput.getText() + input);
    }
    public void storeToArray(){
        String str1 = advancedOutput.getText() + "";
        numbersArray = str1.split(",");
    }
    public void mean(){
        float meanArray[] = new float[numbersArray.length];
        float sum = 0;

        for (int i = 0; i < numbersArray.length; i++){
            meanArray[i] = Float.parseFloat(numbersArray[i]);
        }
        for (int i = 0; i < meanArray.length; i++){
            sum += meanArray[i];
        }
        mean = sum;
        meanToggled = true;
    }

    public void median(){
        float medianArray[] = new float[numbersArray.length];
        int arrayLength = numbersArray.length;
        for (int i = 0; i < arrayLength; i++){
            medianArray[i] = Float.parseFloat(numbersArray[i]);
        }
        Arrays.sort(medianArray);
        boolean middleExists;
        if (arrayLength % 2 == 0){
            middleExists = false;
        }
        else{
            middleExists = true;
        }
        if (middleExists == false){
            int var1Pos = (arrayLength / 2) - 1;
            int var2Pos = (arrayLength / 2);
            float var1 = medianArray[var1Pos];
            float var2 = medianArray[var2Pos];
            median = (var1 + var2) / 2;
        }
        else if (middleExists == true){
            System.out.println("Straight Forward...");
            int varPos = (arrayLength / 2);
            median = medianArray[varPos];
        }
        median = medianArray[1];
        medianToggled = true;
    }

    public void mode(){
        float modeArray[] = new float[numbersArray.length];
        float maxRepeat = 0;
        int maxCount = 0;

        for (int i = 0; i < numbersArray.length; i++){
            modeArray[i] = Float.parseFloat(numbersArray[i]);
        }
        
        for (int i = 0; i < modeArray.length; i++){
            int count = 0;
            for (int j = 0; j < modeArray.length; j++){
                if (modeArray[j] == modeArray[i]){
                    count ++;
                }
            }
            if (count > maxCount){
                maxCount = count;
                maxRepeat = modeArray[i];
            }
        }
        mode = maxRepeat;
        modeToggled = true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.advanced1:
                outputHolder("1");
                break;
            case R.id.advanced2:
                outputHolder("2");
                break;
            case R.id.advanced3:
                outputHolder("3");
                break;
            case R.id.advanced4:
                outputHolder("4");
                break;
            case R.id.advanced5:
                outputHolder("5");
                break;
            case R.id.advanced6:
                outputHolder("6");
                break;
            case R.id.advanced7:
                outputHolder("7");
                break;
            case R.id.advanced8:
                outputHolder("8");
                break;
            case R.id.advanced9:
                outputHolder("9");
                break;
            case R.id.advanced0:
                outputHolder("0");
                break;
            case R.id.advancedDot:
                outputHolder(".");
                dotToggled = true;
                break;
            case R.id.advancedComma:
                outputHolder(",");
                break;
            case R.id.advancedMean:
                storeToArray();
                mean();
                break;
            case R.id.advancedMedian:
                storeToArray();
                median();
                break;
            case R.id.advancedMode:
                storeToArray();
                mode();
                break;
            case R.id.advancedEquals:
                if (meanToggled == true){
                    advancedOutput.setText(mean + "");
                    meanToggled = false;
                }
                if (medianToggled == true){
                    advancedOutput.setText(median + "");
                    medianToggled = false;
                }
                if (modeToggled == true){
                    advancedOutput.setText(mode + "");
                    modeToggled = false;
                }
                Arrays.fill(numbersArray, null);
                break;
            case R.id.advancedDelete:
                advancedOutput.setText("");
                Arrays.fill(numbersArray, null);
                break;
        }
    }
}
