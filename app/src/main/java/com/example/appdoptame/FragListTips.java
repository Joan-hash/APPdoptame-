package com.example.appdoptame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import clases.Tip;


public class FragListTips extends Fragment {
    ArrayList<Tip> tips;
    ListView list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        cargarDatos();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)  inflater.inflate(R.layout.fragment_frag_list_tips, null);
        list = (ListView) root.findViewById(R.id.tips_list);
        list.setAdapter(new AdapterT(root.getContext(), tips));
        // Inflate the layout for this fragment
        return root;
    }
    private void cargarDatos() {
        tips = new ArrayList<>();
        tips.add(new Tip(R.drawable.img_tip1, "Perros y cuarenta", "Tip de prueba. Tip de prueba. Tip de prueba. Tip de prueba. Tip de prueba.Tip de prueba."));
        tips.add(new Tip(R.drawable.img_tip2, "Rutinas", "Tip de prueba. Tip de prueba. Tip de prueba. Tip de prueba. Tip de prueba.Tip de prueba."));
        tips.add(new Tip(R.drawable.img_tip3, "La ansiedad", "Tip de prueba. Tip de prueba. Tip de prueba. Tip de prueba. Tip de prueba.Tip de prueba."));
    }
}