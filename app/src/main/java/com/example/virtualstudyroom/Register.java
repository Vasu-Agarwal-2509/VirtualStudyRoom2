package com.example.virtualstudyroom;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    Button b1;
    EditText e1, e2;
    ProgressBar p1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1 = (Button) findViewById(R.id.button5);
        e1 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText4);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        p1 = (ProgressBar) findViewById(R.id.progressBar);
        p1.setVisibility(View.INVISIBLE);
        firebaseAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.equals("")){
                    e1.setError("Fill E-mail");
                    return;
                }
                else{
                    if(s2.equals("")){
                        e2.setError("Fill Password");
                        return;
                    }
                    p1.setVisibility(View.VISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Register.this, "Account created", Toast.LENGTH_SHORT).show();
                                p1.setVisibility(View.INVISIBLE);
                                Intent i = new Intent(Register.this, MainActivity.class);
                                startActivity(i);
                                finish();
                            }
                            else {
                                Toast.makeText(Register.this, "Account not created", Toast.LENGTH_SHORT).show();
                                p1.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            }
        });

    }
}