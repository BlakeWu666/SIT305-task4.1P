package com.example.a305_41p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    EditText duration, rest;
    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        welcome = findViewById(R.id.welcome);
        duration = findViewById(R.id.duration);
        rest = findViewById(R.id.rest);
        start = findViewById(R.id.startBtn);

        String durationInput = duration.getText().toString();
        String restInput = rest.getText().toString();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainToSecond = new Intent(MainActivity.this,secondPage.class);
                mainToSecond.putExtra("durationUserInput", durationInput);
                mainToSecond.putExtra("restUserInput", restInput);

                startActivity(mainToSecond);

            }
        });


    }
}