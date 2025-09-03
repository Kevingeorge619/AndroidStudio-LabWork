package com.example.experiment8;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert");
                builder.setMessage("Do you want to continue?");
                builder.setCancelable(false);

                builder.setPositiveButton("OK", (dialog, which) ->
                        Toast.makeText(MainActivity.this, "You clicked OK", Toast.LENGTH_SHORT).show()
                );

                builder.setNegativeButton("Cancel", (dialog, which) ->
                        Toast.makeText(MainActivity.this, "You clicked Cancel", Toast.LENGTH_SHORT).show()
                );

                // show the dialog
                builder.show();
            }
        });
    }
}