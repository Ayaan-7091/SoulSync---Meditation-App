package com.shutter.soulsync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;

import java.util.ArrayList;

public class BreathingMeditationActivity extends AppCompatActivity {

    JcPlayerView jcPlayerView;

    ImageView backBtn;

    ImageView  mindfullnessBtn,transcedentalBtn,chakraBtn,breathingBtn,zenBtn,productivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_meditation);

        String url1 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Breathing%2Fbreathing_motivation.mp3?alt=media&token=af61d344-6294-437d-a80e-207638a8bcd3";

       jcPlayerView = findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Breathing Meditation",url1));

        jcPlayerView.initPlaylist(jcAudios, null);

        //AudioPlayer ends here

        backBtn =findViewById(R.id.back_btn);


        backBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,MeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });



        //        starting the meditation
        mindfullnessBtn = findViewById(R.id.mindfullness_meditation_btn);
        transcedentalBtn = findViewById(R.id.transcedental_meditation_btn);
        chakraBtn = findViewById(R.id.chakra_meditation_btn);
        breathingBtn = findViewById(R.id.breathing_meditation_btn);
        zenBtn = findViewById(R.id.zen_meditation_btn);
        productivityBtn = findViewById(R.id.productivity_meditation_btn);

        mindfullnessBtn.setOnClickListener((v)->{
            startActivity(new Intent(BreathingMeditationActivity.this,MindfullnessMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });
        transcedentalBtn.setOnClickListener((v)->{
            startActivity(new Intent(BreathingMeditationActivity.this,TranscedentalMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });
        chakraBtn.setOnClickListener((v)->{
            startActivity(new Intent(BreathingMeditationActivity.this,ChakraMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });

        zenBtn.setOnClickListener((v)->{
            startActivity(new Intent(BreathingMeditationActivity.this,ZenMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });
        productivityBtn.setOnClickListener((v)->{
            startActivity(new Intent(BreathingMeditationActivity.this,ProductivityMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Stop the player when the back button is pressed
        jcPlayerView.kill();
        finish(); // Finish the current activity
    }
}