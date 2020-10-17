package com.example.appdoptame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RecoveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);
    }
    public void recuperacion(View v){
        Intent i = new Intent(getApplicationContext(), CodeActivity.class);
        startActivity(i);
    }
}