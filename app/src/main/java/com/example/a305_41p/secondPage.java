package com.example.a305_41p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class secondPage extends AppCompatActivity {

    TextView workoutText;
    Button startTimerBtn, stopTimerBtn, restBtn;

    int durationInput;
    int restInput;

    Handler h;

    Runnable r;

    CountDownTimer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        workoutText = findViewById(R.id.workOutText);
        startTimerBtn = findViewById(R.id.startTimerBtn);
        stopTimerBtn = findViewById(R.id.stopTimerBtn);
        restBtn = findViewById(R.id.restBtn);

        Bundle extras = getIntent().getExtras();
        long durationInput = extras.getLong("durationUserInput");
        long restInput = extras.getLong("restUserInput");

        h  = new Handler();

        myTimer = new CountDownTimer(durationInput * 1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                workoutText.setText("Time remaining: " +  millisUntilFinished/ 1000);
            }
            @Override
            public void onFinish() {
                workoutText.setText("Done!");
            }
        };

        restBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondToThird = new Intent(secondPage.this,thirdPage.class);
                secondToThird.putExtra("durationUserInput", durationInput);
                secondToThird.putExtra("restUserInput", restInput);
                startActivity(secondToThird);
            }
        });
        startTimerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTimer.start();
            }
        });
        stopTimerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTimer.cancel();
            }
        });


    }
}