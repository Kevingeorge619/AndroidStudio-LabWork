package com.example.experiment14;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private CheckBox checkReading, checkCoding, checkGaming;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        checkReading = findViewById(R.id.checkReading);
        checkCoding = findViewById(R.id.checkCoding);
        checkGaming = findViewById(R.id.checkGaming);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadio = findViewById(selectedId);
                String gender = (selectedRadio != null) ? selectedRadio.getText().toString() : "None";

                StringBuilder hobbies = new StringBuilder();
                if (checkReading.isChecked()) hobbies.append("Reading ");
                if (checkCoding.isChecked()) hobbies.append("Coding ");
                if (checkGaming.isChecked()) hobbies.append("Gaming ");

                if (hobbies.length() == 0) hobbies.append("None");

                String result = "Gender: " + gender + "\nHobbies: " + hobbies;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}
