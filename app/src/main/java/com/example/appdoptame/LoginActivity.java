package com.example.appdoptame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    //metodo para iniciar sesion
    public void iniciarSesion(View v){
        //recuperar el nombre de usuario
        EditText vUsuario = (EditText) findViewById(R.id.input_usuario);
        String usuario = vUsuario.getText().toString();
        //recuperar la contraseña
        EditText vClave = (EditText) findViewById(R.id.input_contraseña);
        String contraseña = vClave.getText().toString();
        //validar datos
        if (usuario.equals("joan")) {
            if (contraseña.equals("1234")) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("user", usuario);
                startActivity(i);
            }
            else{
                //contraseña incorrecta
                Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            //usuario incorrecto
            Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
        }
    }
    //metodo para recuperar la contraseña
    public void recuperarClave(View v){
        Intent i = new Intent(getApplicationContext(), RecoveryActivity.class);
        startActivity(i);
    }
    public void crearCuenta(View v){
        Intent i = new Intent(getApplicationContext(), CreateActivity.class);
        startActivity(i);
    }
}