package com.example.assignment1_calculator_cosc3596_isaiahdaiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Integer total = 0;
    Integer currentNumber = 0;
    char operator = '0';

    private TextView numericDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numericDisplay = findViewById(R.id.display);

        // Numeric Button Functionality
        int[] buttonIds = {R.id.button0, R.id.button1, R.id.button2,
                           R.id.button3, R.id.button4, R.id.button5,
                           R.id.button6, R.id.button7, R.id.button8,
                           R.id.button9
        };

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cast v to a button
                Button b = (Button) v;

                // Append numeric display with number clicked
                if (Integer.parseInt(String.valueOf(numericDisplay.getText())) == 0)
                    numericDisplay.setText(b.getText().toString());
                else {
                    numericDisplay.append(b.getText().toString());
                }
                currentNumber = Integer.parseInt(String.valueOf(numericDisplay.getText()));
                System.out.println("Current Number" + currentNumber);
            }
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(numberClickListener);
        }

        // Operation Button Functionality

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivision = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEquals);

        buttonAdd.setOnClickListener(view -> {
            total = currentNumber;
            currentNumber = 0;
            operator = '+';
            numericDisplay.setText("0");
            System.out.println("total: " + total + ", Operator: " + operator);
        });

        buttonSubtract.setOnClickListener(view -> {
            total = currentNumber;
            currentNumber = 0;
            operator = '-';
            numericDisplay.setText("0");
            System.out.println("total: " + total + ", Operator: " + operator);
        });

        buttonDivision.setOnClickListener(view -> {
            total = currentNumber;
            currentNumber = 0;
            operator = '/';
            numericDisplay.setText("0");
            System.out.println("total: " + total + ", Operator: " + operator);
        });

        buttonMultiply.setOnClickListener(view -> {
            total = currentNumber;
            currentNumber = 0;
            operator = '*';
            numericDisplay.setText("0");
            System.out.println("total: " + total + ", Operator: " + operator);
        });

        buttonEquals.setOnClickListener(view -> {
            calculateResult();
            currentNumber = total;
            numericDisplay.setText(String.valueOf(total));
            System.out.println("Total: " + total + ", Current Number: " + currentNumber);
        });

    }

    private void calculateResult() {
        switch (operator) {
            case '+': // addition
                total += currentNumber;
                break;
            case '-': // subtraction
                total -= currentNumber;
                break;
            case '/': // division
                total /= currentNumber;
                break;
            case '*': // multiplication
                total *= currentNumber;
                break;
            default:
                break;
        }
    }
    // Clear Button onClick Events
    public void buttonClearClicked(View v) {
        numericDisplay.setText("0");
        total = 0;
        currentNumber = 0;
        operator = ' ';
    }
}