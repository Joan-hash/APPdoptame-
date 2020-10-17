package com.example.appdoptame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }
    public void crearCuenta(View v){
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }
}