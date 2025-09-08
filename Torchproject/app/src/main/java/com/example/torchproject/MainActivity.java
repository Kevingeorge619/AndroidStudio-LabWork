package com.example.torchproject;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.hardware.camera2.CameraManager;
//import android.hardware.camera2.CameraManager.CameraAccessException;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Boolean isTorchOn = false;
    private CameraManager cameraManager;
    private String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.torchButton);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            if (cameraManager != null) {
                cameraId = cameraManager.getCameraIdList()[0];
            }
        }catch (Exception e) {
            Toast.makeText(this, "Camera access error", Toast.LENGTH_SHORT).show();
        }
    }
}