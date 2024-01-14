package com.shutter.soulsync;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MeditationActivity extends AppCompatActivity {

    ImageView homeBtn,notesBtn,sleepBtn;

    CardView mindfullnessBtn,transcedentalBtn,chakraBtn,breathingBtn,zenBtn,productivityBtn;

    TextView medMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);

        homeBtn = findViewById(R.id.home_btn);
        notesBtn = findViewById(R.id.notes_btn);
        sleepBtn = findViewById(R.id.sleep_btn);

        homeBtn.setOnClickListener((v)->{
            startActivity(new Intent(MeditationActivity.this,MainActivity.class));
        });
        notesBtn.setOnClickListener((v)->{
            startActivity(new Intent(MeditationActivity.this,NotesActivity.class));
        });
        sleepBtn.setOnClickListener((v)->{
            startActivity(new Intent(MeditationActivity.this,SleepActivity.class));
        });

        //for meditation message
        medMsg = findViewById(R.id.med_msg);
        setMeditationMsg(medMsg);
    }

    private void setMeditationMsg(TextView greetingText) {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);


        // Set the greeting based on the current time
        if (hourOfDay >= 5 && hourOfDay < 12) {
            greetingText.setText("Start Your Day Mindfully: Embrace Serenity with Morning Meditation.");
        } else if (hourOfDay >= 12 && hourOfDay < 17) {
            greetingText.setText("Midday Recharge: Revitalize Your Mind with Afternoon Meditation");
        } else if (hourOfDay >= 17 && hourOfDay < 21) {
            greetingText.setText("Evening Tranquility: Unwind and Relax with Guided Meditation");
        } else {
            greetingText.setText("Nighttime Serenade: Drift into Peaceful Sleep with Night Meditation");
        }


//        starting the meditation
        mindfullnessBtn = findViewById(R.id.mindfullness_meditation_btn);
        transcedentalBtn = findViewById(R.id.transcedental_meditation_btn);
        chakraBtn = findViewById(R.id.chakra_meditation_btn);
        breathingBtn = findViewById(R.id.breathing_meditation_btn);
        zenBtn = findViewById(R.id.zen_meditation_btn);
        productivityBtn = findViewById(R.id.productivity_meditation_btn);

        mindfullnessBtn.setOnClickListener((v)->{
            startActivity(new Intent(MeditationActivity.this,MindfullnessMeditationActivity.class));
        });
        transcedentalBtn.setOnClickListener((v)->{
            startActivity(new Intent(MeditationActivity.this,TranscedentalMeditationActivity.class));
        });
        chakraBtn.setOnClickListener((v)->{
            startActivity(new Intent(MeditationActivity.this,ChakraMeditationActivity.class));
        });
        breathingBtn.setOnClickListener((v)->{

            startActivity(new Intent(MeditationActivity.this,BreathingMeditationActivity.class));
        });
        zenBtn.setOnClickListener((v)->{
            startActivity(new Intent(MeditationActivity.this,ZenMeditationActivity.class));
        });
        productivityBtn.setOnClickListener((v)->{
            startActivity(new Intent(MeditationActivity.this,ProductivityMeditationActivity.class));
        });


    }

    }


