package com.example.a305_41p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thirdPage extends AppCompatActivity {

    TextView restText;
    Button stopBtn, startBtn;

    Bundle extras = getIntent().getExtras();
    int durationInput = extras.getInt("durationUserInput");
    int restInput = extras.getInt("restUserInput");
    Handler h  = new Handler();

    public void count(){
        restInput--;
        restText.setText("Time remaining: " + restInput);
        h.postDelayed(r,1000);
    };


    private  Runnable r = new Runnable() {
        @Override
        public void run() {
            count();
        }
    };

    CountDownTimer myTimer = new CountDownTimer(restInput,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            count();
        }

        @Override
        public void onFinish() {
            restText.setText("Done!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);

        restText = findViewById(R.id.restText);
        stopBtn = findViewById(R.id.stopBtn);
        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTimer.start();
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTimer.cancel();
            }
        });

    }
}