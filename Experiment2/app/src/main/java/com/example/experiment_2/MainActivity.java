package com.example.experiment_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText mark1;
    private EditText mark2;
    private  EditText mark3;
    private Button btn;
    private TextView sum;
    private TextView average;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mark1 = findViewById(R.id.mark1);
        mark2 = findViewById(R.id.mark2);
        mark3 = findViewById(R.id.mark3);
        btn = findViewById(R.id.button);
        sum = findViewById(R.id.sum);
        average = findViewById(R.id.average);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m1 = Integer.parseInt(mark1.getText().toString());
                int m2 = Integer.parseInt(mark2. getText().toString());
                int m3 = Integer.parseInt(mark3.getText().toString());

                int s = m1+m2+m3;
                sum.setText(Integer.toString(s));

                int avg = (m1+m2+m3)/3;
                average.setText(Integer.toString(avg));

            }
        });
    }
}