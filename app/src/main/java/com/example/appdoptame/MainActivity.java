package com.example.appdoptame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import clases.Post;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuLateral();
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
                        FragmentManager fa = getSupportFragmentManager();
                        fa.beginTransaction().replace(R.id.posts_list_frag, new FragListPosts()).commit();
                        break;
                    case R.id.op_mensajes:
                        FragmentManager fb = getSupportFragmentManager();
                        fb.beginTransaction().replace(R.id.posts_list_frag, new FragListMessages()).commit();
                        break;
                    case R.id.op_consejos:
                        FragmentManager fc = getSupportFragmentManager();
                        fc.beginTransaction().replace(R.id.posts_list_frag, new FragListTips()).commit();
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