package com.shutter.soulsync;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText emailText,passwordText;

    Button loginBtn;

    TextView signupBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signupBtn = findViewById(R.id.signup_btn);
        loginBtn = findViewById(R.id.login_btn);



        signupBtn.setOnClickListener((v)->{
            startActivity(new Intent(LoginActivity.this,CreateUserActivity.class));
        });

        loginBtn.setOnClickListener((v)->{

            emailText = findViewById(R.id.email_edit_text);
            passwordText = findViewById(R.id.password_edit_text);

            String email = emailText.getText().toString();
            String password = passwordText.getText().toString();

            if(email.isEmpty()||password.isEmpty()){
                emailText.setError("Email can't be Empty");
                return;
            }
            loginUser(email,password);
        });
    }

    private void loginUser(String email,String password){
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this,task.getException().getLocalizedMessage() , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}