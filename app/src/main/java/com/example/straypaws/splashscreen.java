package com.example.straypaws;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splashscreen.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finish the splash activity
        }, 3000);

    }
}