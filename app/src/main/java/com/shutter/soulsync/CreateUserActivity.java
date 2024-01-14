package com.shutter.soulsync;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateUserActivity extends AppCompatActivity {

    Button createAccountButton;

    FirebaseAuth auth;
    TextView loginBtn;

    ProgressBar progressBar;

    EditText emailText,passwordText,confirmPasswordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        createAccountButton = findViewById(R.id.create_account_btn);
        loginBtn = findViewById(R.id.login_btn);
        progressBar = findViewById(R.id.progress_bar);



        loginBtn.setOnClickListener((v)->{
            startActivity(new Intent(CreateUserActivity.this,LoginActivity.class));
        });

        //Authentication

        auth = FirebaseAuth.getInstance();


        createAccountButton.setOnClickListener((v)->{



        emailText = findViewById(R.id.email_edit_text);
        passwordText = findViewById(R.id.password_edit_text);
        confirmPasswordText = findViewById(R.id.confirm_password_edit_text);

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String confirmPassword = confirmPasswordText.getText().toString();

        if(!validateData(email,password,confirmPassword)){
            return;
        }

        createAccount(email,password);
        });




    }

    private void createAccount(String email, String password) {
        changeInProgress(true);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(CreateUserActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                changeInProgress(false);
                if (task.isSuccessful()){
                    Toast.makeText(CreateUserActivity.this, "Account created successfully , check email for verification", Toast.LENGTH_SHORT).show();
                    auth.getCurrentUser().sendEmailVerification();
                    auth.signOut();
                    finish();
                }
                else{
                    Toast.makeText(CreateUserActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public boolean validateData(String email,String password,String confirm_password){
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailText.setError("Email Invalid");
            return false;
        }

        if(password.length()<6){
            passwordText.setError("Password Length Is Invalid");
            return false;
        }

        if(!confirm_password.equals(password)){
            confirmPasswordText.setError("Password doesn't match");
            return false;
        }

        return true;


    }

    private void changeInProgress(boolean inProgress){
        if(inProgress){
            createAccountButton.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            createAccountButton.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }
}