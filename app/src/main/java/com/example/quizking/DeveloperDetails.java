package com.example.quizking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DeveloperDetails extends AppCompatActivity {
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developer_details);
        btnRestart = (Button) findViewById(R.id.button4);
        btnRestart.setOnClickListener(v -> {
            Intent in2 = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(in2);
        });
   }
}