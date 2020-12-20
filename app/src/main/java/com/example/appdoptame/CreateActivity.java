package com.example.appdoptame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class CreateActivity extends AppCompatActivity {
    EditText usuarioC, correoC, telefonoC, contraseñaC, confContraseñaC;
    Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        //recuperacion de los campos del formulario
        usuarioC = (EditText) findViewById(R.id.input_usuarioC);
        correoC = (EditText) findViewById(R.id.input_correo);
        telefonoC = (EditText) findViewById(R.id.input_telefono);
        contraseñaC = (EditText) findViewById(R.id.input_contraseñaC);
        confContraseñaC = (EditText) findViewById(R.id.input_conf_contarseñaC);
        btnRegistrar = (Button) findViewById(R.id.button_crear);
        //evento para el boton
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //comparacion de la contraseñas, primera validación
                String pass1 = contraseñaC.getText().toString();
                String pass2 = confContraseñaC.getText().toString();
                if (pass1.equals(pass2)){
                    //relizamos la insercion en la base de datos
                    registrarUsuario("http://192.168.1.43/app/registrarUsuario.php");
                }else{
                    Toast.makeText(CreateActivity.this, "Las contraeñas no son iguales", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void registrarUsuario(String URL){
        StringRequest peticion = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1")){
                    finish();
                }else{
                    Toast.makeText(CreateActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
                Toast.makeText(CreateActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("usuario", usuarioC.getText().toString());
                parametros.put("correo", correoC.getText().toString());
                parametros.put("telefono", telefonoC.getText().toString());
                parametros.put("contraseña", contraseñaC.getText().toString());
                return parametros;
            }
        };
        RequestQueue colaPeticiones = Volley.newRequestQueue(getApplicationContext());
        colaPeticiones.add(peticion);
    }
}