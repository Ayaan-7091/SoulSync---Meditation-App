package com.shutter.soulsync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;

import java.util.ArrayList;

public class MindfullnessMeditationActivity extends AppCompatActivity {

    JcPlayerView jcPlayerView;

    ImageView backBtn;

    ImageView  mindfullnessBtn,transcedentalBtn,chakraBtn,breathingBtn,zenBtn,productivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfullness_meditation);




        //to play music
        String url1 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Mindfullness%2FMindfullnes_Recharge_Mind.mp3?alt=media&token=9cc33c37-c2c4-4441-a77e-f4266f3607a1";
        String url2 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Mindfullness%2FMindfullness_Reduce_Anxiety.mp3?alt=media&token=25c86889-a8b9-460c-9c2f-b759f0ac0e1c";
        String url3 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Mindfullness%2FMindfullness_Muscle_Relaxation.mp3?alt=media&token=fe4de0f1-d27c-47bd-810c-50b5d4a457d4";

        jcPlayerView = findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Mindfulness - Recharge Your Mind",url1));
        jcAudios.add(JcAudio.createFromURL("Mindfulness - Reduce Anxiety",url2));
        jcAudios.add(JcAudio.createFromURL("Mindfulness - Muscle Relaxation",url3));



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
        transcedentalBtn.setOnClickListener((v)->{
            startActivity(new Intent(this,TranscedentalMeditationActivity.class));
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