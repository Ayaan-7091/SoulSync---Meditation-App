package com.shutter.soulsync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;

import java.util.ArrayList;

public class SleepActivity extends AppCompatActivity {

    ImageView homeBtn,meditationBtn,notesBtn;

    JcPlayerView jcPlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        homeBtn = findViewById(R.id.home_btn);
        meditationBtn = findViewById(R.id.meditation_btn);
        notesBtn = findViewById(R.id.notes_btn);

        homeBtn.setOnClickListener((v)->{
            jcPlayerView.kill();
            finish();
            startActivity(new Intent(SleepActivity.this,MainActivity.class));
        });
        meditationBtn.setOnClickListener((v)->{
            jcPlayerView.kill();
            finish();
            startActivity(new Intent(SleepActivity.this,MeditationActivity.class));
        });
        notesBtn.setOnClickListener((v)->{
            jcPlayerView.kill();
            finish();
            startActivity(new Intent(SleepActivity.this,NotesActivity.class));
        });

        //to play music
        String url1 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Deep%20Sleep%20Ambience%20-%201.mp3?alt=media&token=d75b4a17-e982-4e99-9d9c-3e958b425955";
        String url2 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Deep%20Sleep%20Ambience%20-%202.mp3?alt=media&token=8b0cbe0d-af7a-4830-8c17-29ae5913efb1";
        String url3 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Forest%20Sounds.mp3?alt=media&token=be8307f0-0c5b-4d04-aaf2-0f6e45677024";
        String url4 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Insomnia.mp3?alt=media&token=14a6d1f1-e822-4a35-ad5e-371e19404b6a";
        String url5 = "https://firebasestorage.googleapis.com/v0/b/soul-sync-meditation.appspot.com/o/Power%20Nap%20Relaxation.mp3?alt=media&token=d5286728-035c-44dd-a837-34a31d3916d0";

        jcPlayerView = findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Deep Sleep Ambience - 1",url2));
        jcAudios.add(JcAudio.createFromURL("Deep Sleep Ambience - 2",url1));
        jcAudios.add(JcAudio.createFromURL("Forest Ambience",url3));
        jcAudios.add(JcAudio.createFromURL("Insomnia",url4));
        jcAudios.add(JcAudio.createFromURL("Powernap Ambience",url5));


        jcPlayerView.initPlaylist(jcAudios, null);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Stop the player when the back button is pressed
        jcPlayerView.kill();
        finish(); // Finish the current activity
    }
}