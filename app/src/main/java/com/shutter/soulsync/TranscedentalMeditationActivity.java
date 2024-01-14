package com.shutter.soulsync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;

import java.util.ArrayList;

public class TranscedentalMeditationActivity extends AppCompatActivity {

    JcPlayerView jcPlayerView;

    ImageView backBtn;

    ImageView  mindfullnessBtn,transcedentalBtn,chakraBtn,breathingBtn,zenBtn,productivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcedental_mediatation);

        //to play music
        String url1 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Transcedental%2Ftranscending_motivation_2.mp3?alt=media&token=fcc2f79c-7d17-47c0-b28e-59ec1684ae88";
        String url2 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Transcedental%2Ftranscending_motivation_3.mp3?alt=media&token=3eb4b0f1-b9e6-45f0-8e66-f612aea21e8e";
       jcPlayerView = findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Transcendental Meditation - Session 1",url1));
        jcAudios.add(JcAudio.createFromURL("Transcendental Meditation - Session 2",url2));




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


        chakraBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,ChakraMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });
        mindfullnessBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,MindfullnessMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });
        zenBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,ZenMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });

        breathingBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,BreathingMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });
        productivityBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,ProductivityMeditationActivity.class));
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