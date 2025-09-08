package com.example.blinkingtorch;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CameraManager cameraManager;
    private String cameraId;
    private Button btn;
    private Handler handler = new Handler();
    private TextView blinkCounter;
    private int blinkCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.torchButton);
        blinkCounter = findViewById(R.id.blinkCounter);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            if (cameraManager != null) {
                cameraId = cameraManager.getCameraIdList()[0];
            }
        } catch (Exception e) {
            Toast.makeText(this, "Camera access error", Toast.LENGTH_SHORT).show();
        }

        btn.setOnClickListener(v -> blinkTorch(10));

    }

    private void blinkTorch(int times) {
        final int delay = 100;
        for (int i = 0; i < times; i++) {
            int finalI = i;
            handler.postDelayed(() -> {
                try {
                    boolean state = (finalI % 2 == 0);
                    cameraManager.setTorchMode(cameraId, state);
                    blinkCount++;
                    blinkCounter.setText("Blink count: " + blinkCount);
                    if (state) {
                        blinkCount++;
                        blinkCounter.setText("Blink count: " + blinkCount);
                        Toast.makeText(this, "Flashlight ON (Blink " + blinkCount + ")", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Flashlight OFF", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(this, "Camera access error", Toast.LENGTH_SHORT).show();
                }

        },i * delay);


    }
}
}