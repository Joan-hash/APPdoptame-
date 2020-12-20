package com.example.appdoptame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import clases.Post;


public class FragListPosts extends Fragment {
    ArrayList<Post> posts;
    ListView list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        cargarDatos();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_frag_list_posts, null);
        list = (ListView) root.findViewById(R.id.posts_list);
        list.setAdapter(new AdapterP(root.getContext(), posts));
        // Inflate the layout for this fragment
        return root;
    }
    private void cargarDatos() {
        posts = new ArrayList<>();
        posts.add(new Post(R.drawable.img_pet1,"Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba."));
        posts.add(new Post(R.drawable.img_publicidad,"Publicidad. Publicidad Publicidad Publicidad Publicidad Publicidad Publicidad Publicidad Publicidad Publicidad Publicidad Publicidad PublicidadPublicidad Publicidad Publicidad Publicidad "));
        posts.add(new Post(R.drawable.img_pet2,"Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba. Descripcion de prueba."));
    }
}