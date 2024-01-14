package com.shutter.soulsync;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;

public class NotesActivity extends AppCompatActivity {

    ImageView homeBtn,meditationBtn,sleepBtn;

    FloatingActionButton add_note_btn;

    RecyclerView recyclerView;

    NoteAdapter noteAdapter;


    Utility utility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);


        utility = new Utility();
        homeBtn = findViewById(R.id.home_btn);
        meditationBtn = findViewById(R.id.meditation_btn);
        sleepBtn = findViewById(R.id.sleep_btn);


        add_note_btn = findViewById(R.id.add_note_btn);;
        recyclerView = findViewById(R.id.recyclerView);


        homeBtn.setOnClickListener((v)->{
            startActivity(new Intent(NotesActivity.this,MainActivity.class));
        });
        meditationBtn.setOnClickListener((v)->{
            startActivity(new Intent(NotesActivity.this,MeditationActivity.class));
        });
        sleepBtn.setOnClickListener((v)->{
            startActivity(new Intent(NotesActivity.this,SleepActivity.class));
        });

        //Notes Logic

        setUpRecyclerView();

        add_note_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(NotesActivity.this,NoteDetailsActivity.class));


            }
        });




    }

    private void setUpRecyclerView() {

        Query query = utility.getCollectionReferenceForNotes().orderBy("timestamp",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query,Note.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(options,this);
        recyclerView.setAdapter(noteAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        noteAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        noteAdapter.startListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }



}