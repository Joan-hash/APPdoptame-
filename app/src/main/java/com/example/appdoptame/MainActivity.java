package com.example.appdoptame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
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

        //agregar funcionalidades a los items del menu lateral
        NavigationView nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.op_principal:
                        //aqui va la intencion para cambiar de activity
                        Toast.makeText(MainActivity.this, "Principal", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.op_mensajes:
                        Toast.makeText(MainActivity.this, "Mis mensajes", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.op_consejos:
                        Toast.makeText(MainActivity.this, "Consejos", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.op_agregar:
                        Toast.makeText(MainActivity.this, "Agregar publicación", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.op_perfil:
                        Toast.makeText(MainActivity.this, "Mi perfil", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.op_configuracion:
                        Toast.makeText(MainActivity.this, "Configuración", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.op_terminos:
                        Toast.makeText(MainActivity.this, "Términos y condiciones de uso", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.op_localizacion:
                        Toast.makeText(MainActivity.this, "Localización", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.op_cerrar:
                        Toast.makeText(MainActivity.this, "Cerrar sesión", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "La opción ingresada es incorrecta", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        //recuperar el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //asignar el toolbar a esta activity
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main);
        //mostrar el actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //habilitar toggle
        getSupportActionBar().setHomeButtonEnabled(true);
        toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return false;
    }
}