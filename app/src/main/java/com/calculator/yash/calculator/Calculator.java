/*
Assignment #1
File Name - Calculator.java
Name : Yash Ghia (800976079)
 */

package com.calculator.yash.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity  implements View.OnClickListener{

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button dot;
    TextView tv;
    String operator;
    double firstNumber;
    double secondNumber;
    double result;
    boolean isOperatorSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        zero = (Button) findViewById(R.id.button0);
        zero.setOnClickListener(this);
        one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(this);
        two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);
        three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);
        four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this);
        five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(this);
        six = (Button) findViewById(R.id.button6);
        six.setOnClickListener(this);
        seven = (Button) findViewById(R.id.button7);
        seven.setOnClickListener(this);
        eight = (Button) findViewById(R.id.button8);
        eight.setOnClickListener(this);
        nine = (Button) findViewById(R.id.button9);
        nine.setOnClickListener(this);
        dot = (Button) findViewById(R.id.buttonDot);
        dot.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.textViewResult);
    }

    public void operation(View view) {
        tv = (TextView) findViewById(R.id.textViewResult);
        isOperatorSet = true;
        switch (view.getId()){
            case R.id.buttonAdd:
                operator = "+";
                firstNumber =Double.parseDouble(tv.getText().toString());
                break;
            case R.id.buttonSub:
                operator = "-";
                firstNumber =Double.parseDouble(tv.getText().toString());
                break;
            case R.id.buttonMul:
                operator = "*";
                firstNumber =Double.parseDouble(tv.getText().toString());
                break;
            case R.id.buttonDiv:
                operator = "/";
                firstNumber =Double.parseDouble(tv.getText().toString());
                break;
        }
    }

    public void calculation(View view){
        tv = (TextView) findViewById(R.id.textViewResult);
        secondNumber =Double.parseDouble(tv.getText().toString());
        switch (operator){
            case "+":
                result = firstNumber+secondNumber;
                break;
            case "-":
                result = firstNumber-secondNumber;
                break;
            case "*":
                result = firstNumber*secondNumber;
                break;
            case "/":
                result = firstNumber/secondNumber;
                break;
        }
        if(Double.toString(result).length()>=14)
        {
            DecimalFormat decimalFormat = new DecimalFormat("0.0000000000E00");
            tv.setText( decimalFormat.format(result));
        }
        else {
            tv.setText(Double.toString(result));
        }
        firstNumber=result;
        secondNumber=0;
        operator="";
    }

    public void clear(View view){
        tv = (TextView) findViewById(R.id.textViewResult);
        tv.setText("");
    }

    @Override
    public void onClick(View view) {
        tv = (TextView) findViewById(R.id.textViewResult);
        if(isOperatorSet)
        {
            tv.setText("");
            isOperatorSet = false;
        }
        switch (view.getId()){
            case R.id.button0:
                tv.append("0");
                break;
            case R.id.button1:
                tv.append("1");
                break;
            case R.id.button2:
                tv.append("2");
                break;
            case R.id.button3:
                tv.append("3");
                break;
            case R.id.button4:
                tv.append("4");
                break;
            case R.id.button5:
                tv.append("5");
                break;
            case R.id.button6:
                tv.append("6");
                break;
            case R.id.button7:
                tv.append("7");
                break;
            case R.id.button8:
                tv.append("8");
                break;
            case R.id.button9:
                tv.append("9");
                break;
            case R.id.buttonDot:
                tv.append(".");
                break;
        }
    }
}