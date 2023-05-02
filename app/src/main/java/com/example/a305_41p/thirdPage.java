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

    int durationInput;

    int restInput;


    Handler h;
    Runnable r;

    CountDownTimer myTimer;

    public void count(){
        restInput--;
        restText.setText("Time remaining: " + restInput);
        h.postDelayed(r,1000);
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);

        restText = findViewById(R.id.restText);
        stopBtn = findViewById(R.id.stopBtn);
        startBtn = findViewById(R.id.startBtn);

        Bundle extras = getIntent().getExtras();
        durationInput = extras.getInt("durationUserInput");
        restInput = extras.getInt("restUserInput");

        h  = new Handler();

        myTimer = new CountDownTimer(restInput * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //count();
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        count();
                    }
                });
            }

            @Override
            public void onFinish() {
                //restText.setText("Done!");
            }
        };

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