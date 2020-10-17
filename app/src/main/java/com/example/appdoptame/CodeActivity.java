package com.example.appdoptame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
    }
    public void codigo(View v){
        Intent i = new Intent(getApplicationContext(), PasswordActivity.class );
        startActivity(i);
    }
}