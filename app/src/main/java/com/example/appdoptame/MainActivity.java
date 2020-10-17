package com.example.appdoptame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //resivir los datos que se mandaron desde el login
        Bundle datos = getIntent().getExtras();
        if (datos != null){
            String usuario = datos.getString("user");
            TextView mensaje = (TextView) findViewById(R.id.label_saludo);
            mensaje.setText(usuario + " ha conectado y pasado información de dos activitys");
        }
    }

}