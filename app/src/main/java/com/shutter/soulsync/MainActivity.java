package com.shutter.soulsync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView notesBtn,meditationBtn,greetImg,sleepBtn,userProfile,aiBtn;
    TextView quote1,quote2,quote3,quote4,quote5,greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesBtn = findViewById(R.id.notes_btn);
        meditationBtn = findViewById(R.id.meditation_btn);
        sleepBtn = findViewById(R.id.sleep_btn);

        greetingText = findViewById(R.id.greeting_text);
        greetImg = findViewById(R.id.greet_img);

        aiBtn = findViewById(R.id.ai_btn);



        notesBtn.setOnClickListener((v)->{
            startActivity(new Intent(MainActivity.this,NotesActivity.class));
        });

        meditationBtn.setOnClickListener((v)->{
            startActivity(new Intent(MainActivity.this,MeditationActivity.class));
        });
        sleepBtn.setOnClickListener((v)->{
            startActivity(new Intent(MainActivity.this,SleepActivity.class));
        });

        //Quotes setting method :

        quote1 = findViewById(R.id.quote_1);
        setRandomQuote(quote1);
        quote2 = findViewById(R.id.quote_2);
        setRandomQuote(quote2);
        quote3 = findViewById(R.id.quote_3);
        setRandomQuote(quote3);
        quote4 = findViewById(R.id.quote_4);
        setRandomQuote(quote4);
        quote5 = findViewById(R.id.quote_5);
        setRandomQuote(quote5);

        //set greeting text
        setGreetText(greetingText,greetImg);

        //log out user

        userProfile = findViewById(R.id.user_profile);
        userProfile.setOnClickListener((v)->{
            PopupMenu popupMenu = new PopupMenu(MainActivity.this,userProfile);
            popupMenu.getMenu().add("Logout");
            popupMenu.show();

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    if(item.getTitle()=="Logout"){
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
                        finish();
                        return true;
                    }
                    return false;
                }
            });
        });


        aiBtn.setOnClickListener((v)->{


            // to launch a website
            String url = "https://chat.openai.com/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);

            } else {
                Toast.makeText(this, "No app can handle this action", Toast.LENGTH_SHORT).show();
            }

        });



    }

    private void setGreetText(TextView greetingText,ImageView greetImg) {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);


        // Set the greeting based on the current time
        if (hourOfDay >= 5 && hourOfDay < 12) {
            greetingText.setText("Goodmorning User");
            greetImg.setImageResource(R.drawable.morning);
        } else if (hourOfDay >= 12 && hourOfDay < 17) {
            greetingText.setText("GoodAfternoon User");
            greetImg.setImageResource(R.drawable.afternoon);

        } else if (hourOfDay >= 17 && hourOfDay < 21) {
            greetingText.setText("Goodevening,");
            greetImg.setImageResource(R.drawable.evening);

        } else {
            greetingText.setText("Goodnight User");
            greetImg.setImageResource(R.drawable.night);

        }
    }

    private void setRandomQuote(TextView quote) {

        Quotes quotes = new Quotes();
        // Generate a random index to get a quote from the list
        int randomIndex = new Random().nextInt(quotes.quotes.size());

        // Get the quote at the random index
        String randomQuote = quotes.quotes.get(randomIndex);
        quote.setText(randomQuote);
    }
}