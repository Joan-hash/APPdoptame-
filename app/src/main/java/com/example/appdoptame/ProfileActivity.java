package com.example.appdoptame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import clases.Post;

public class ProfileActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
    ArrayList<Post> posts;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cargarDatos();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        menuLateral();
        list = (ListView) findViewById(R.id.user_posts_list);
        list.setAdapter(new AdapterP(this, posts));
    }

    private void cargarDatos() {
        posts = new ArrayList<>();

        posts.add(new Post(R.drawable.img_pet1, "Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba."));
        posts.add(new Post(R.drawable.img_pet2, "Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba."));
    }

    public void menuLateral(){
        //agregar funcionalidades a los items del menu lateral
        NavigationView nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.op_principal:
                        //aqui va la intencion para cambiar de activity
                        Intent a = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(a);
                        break;
                    case R.id.op_mensajes:
                        //Intent b = new Intent(getApplicationContext(), MessagesActivity.class);
                        //startActivity(b);
                        break;
                    case R.id.op_consejos:
                        //Intent c = new Intent(getApplicationContext(), TipsActivity.class);
                        //startActivity(c);
                        break;
                    case R.id.op_agregar:
                        Intent d = new Intent(getApplicationContext(), AddActivity.class);
                        startActivity(d);
                        break;
                    case R.id.op_perfil:
                        Intent e = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(e);
                        break;
                    case R.id.op_configuracion:
                        Intent f = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(f);
                        break;
                    case R.id.op_terminos:
                        Intent g = new Intent(getApplicationContext(), TermsActivity.class);
                        startActivity(g);
                        break;
                    case R.id.op_localizacion:
                        Intent h = new Intent(getApplicationContext(), LocationActivity.class);
                        startActivity(h);
                        break;
                    case R.id.op_cerrar:
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                        break;
                    default:
                        Toast.makeText(ProfileActivity.this, "La opción ingresada es incorrecta", Toast.LENGTH_SHORT).show();
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