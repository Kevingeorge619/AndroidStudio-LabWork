package com.example.experiment16;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textResult = findViewById(R.id.textResult);

        int sum = getIntent().getIntExtra("SUM_RESULT", 0);
        textResult.setText("Sum = " + sum);
    }
}