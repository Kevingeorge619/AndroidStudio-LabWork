package com.example.experiment6;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = findViewById(R.id.tvFormat1);
        TextView tv2 = findViewById(R.id.tvFormat2);
        TextView tv3 = findViewById(R.id.tvFormat3);
        TextView tv4 = findViewById(R.id.tvFormat4);

        Date now = new Date();

        // define formats
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, MMM d, yyyy h:mm a", Locale.getDefault());
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm", Locale.getDefault());
        SimpleDateFormat sdf4 = new SimpleDateFormat("hh:mm:ss a z", Locale.getDefault());

        // set text
        tv1.setText("Format 1: " + sdf1.format(now));
        tv2.setText("Format 2: " + sdf2.format(now));
        tv3.setText("Format 3: " + sdf3.format(now));
        tv4.setText("Format 4: " + sdf4.format(now));
    }
}
