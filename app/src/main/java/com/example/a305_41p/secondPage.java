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

    Bundle extras = getIntent().getExtras();
    int durationInput = extras.getInt("durationUserInput");
    int restInput = extras.getInt("restUserInput");
    Handler h  = new Handler();

    public void count(){
        durationInput--;
        workoutText.setText("Time remaining :" + durationInput);
        h.postDelayed(r, 1000);
    }

    private Runnable r = new Runnable() {
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
            workoutText.setText("Done!");
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        workoutText = findViewById(R.id.workOutText);
        startTimerBtn = findViewById(R.id.startTimerBtn);
        stopTimerBtn = findViewById(R.id.stopTimerBtn);
        restBtn = findViewById(R.id.restBtn);

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