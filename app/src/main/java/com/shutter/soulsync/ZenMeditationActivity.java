package com.shutter.soulsync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;

import java.util.ArrayList;

public class ZenMeditationActivity extends AppCompatActivity {

    JcPlayerView jcPlayerView;

    ImageView backBtn;

    ImageView  mindfullnessBtn,transcedentalBtn,chakraBtn,breathingBtn,zenBtn,productivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zen_meditation);


        String url1 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Zen%2Fzen_meditation.mp3?alt=media&token=ec9b2053-21fa-4d37-8e2d-dcd3cb454b79";

      jcPlayerView = findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Zen Meditation." + "",url1));
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

        productivityBtn = findViewById(R.id.productivity_meditation_btn);


        mindfullnessBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,MindfullnessMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });
        transcedentalBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,TranscedentalMeditationActivity.class));
            jcPlayerView.kill();
            finish();
        });
        chakraBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,ChakraMeditationActivity.class));
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