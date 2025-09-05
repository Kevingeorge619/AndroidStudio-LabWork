package com.example.experiment16;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editNum1, editNum2;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> {
            int num1 = Integer.parseInt(editNum1.getText().toString());
            int num2 = Integer.parseInt(editNum2.getText().toString());
            int sum = num1 + num2;

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("SUM_RESULT", sum);
            startActivity(intent);
        });
    }
}
