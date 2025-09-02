package com.example.experiment4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private String operator = null;
    private Double firstNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.tvDisplay);

        // number buttons
        int[] numbers = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : numbers) {
            Button b = findViewById(id);
            b.setOnClickListener(v -> {
                String value = b.getText().toString();
                currentInput += value;
                display.setText(currentInput);
            });
        }

        // operator buttons
        findViewById(R.id.btnPlus).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.btnMinus).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> setOperator("*"));
        findViewById(R.id.btnDivide).setOnClickListener(v -> setOperator("/"));

        // equals button
        findViewById(R.id.btnEquals).setOnClickListener(v -> calculateResult());

        // clear button
        findViewById(R.id.btnClear).setOnClickListener(v -> {
            currentInput = "";
            operator = null;
            firstNumber = null;
            display.setText("0");
        });
    }

    private void setOperator(String op) {
        if (!currentInput.isEmpty()) {
            firstNumber = Double.parseDouble(currentInput);
            operator = op;
            currentInput = "";
        }
    }

    private void calculateResult() {
        if (firstNumber != null && operator != null && !currentInput.isEmpty()) {
            double secondNumber = Double.parseDouble(currentInput);
            double result = 0.0;

            switch (operator) {
                case "+": result = firstNumber + secondNumber; break;
                case "-": result = firstNumber - secondNumber; break;
                case "*": result = firstNumber * secondNumber; break;
                case "/": result = (secondNumber != 0) ? firstNumber / secondNumber : Double.NaN; break;
            }

            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            firstNumber = null;
            operator = null;
        }
    }
}
