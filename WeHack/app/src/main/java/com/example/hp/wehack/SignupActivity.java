package com.example.hp.wehack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword, language2, name2;
    private String email, password, name, languauge;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    DatabaseReference mDatabaseReference;
    CardView cardView;
    private TextView LogIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        cardView = (CardView) findViewById(R.id.cardView2);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        language2 = (EditText) findViewById(R.id.lang);
        name2 = (EditText) findViewById(R.id.name);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        LogIn = (TextView) findViewById(R.id.textView2);


        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(SignupActivity.this, LoginPage.class);
                startActivity(i);
                finish();
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignupActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    String user_id = auth.getCurrentUser().getUid();
                                    //User user = new User(user_id,name2.getText().toString(), language2.getText().toString(), inputEmail.getText().toString(),inputPassword.getText().toString());
                                    //DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child(child(mDatabaseReference.child("uploads").push().getKey()).setValue(upload);
                                    //mDatabaseReference.child(mDatabaseReference.child(user_id).push().getKey()).setValue(user);
                                    //current_user_db.setValue(user);
                                    startActivity(new Intent(SignupActivity.this, Dashboard.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}

