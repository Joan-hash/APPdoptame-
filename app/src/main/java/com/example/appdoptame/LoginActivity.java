package com.example.appdoptame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText usuarioL, claveL;
    Button btnIniciarSesion;
    TextView btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //recuperacion de los campos del inicio de sesion, excepto el de recuperacion de la clave
        usuarioL = (EditText) findViewById(R.id.input_usuarioL);
        claveL = (EditText) findViewById(R.id.input_contraseñaL);
        btnIniciarSesion = (Button) findViewById(R.id.button_iniciar);
        btnRegistrar = (TextView) findViewById(R.id.label_crear);
        //agregar el evento click para que no reenvie a otra activity
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CreateActivity.class);
                startActivity(i);
            }
        });
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //peticion a la base de datos
                validarUsuario("http://192.168.1.43/app/iniciarSesion.php");
            }
        });
    }
    private void validarUsuario (String URL){
        StringRequest peticion = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario", usuarioL.getText().toString());
                parametros.put("contraseña", claveL.getText().toString());
                return parametros;
            }
        };
        RequestQueue colaPeticion = Volley.newRequestQueue(getApplicationContext());
        colaPeticion.add(peticion);
    }
}