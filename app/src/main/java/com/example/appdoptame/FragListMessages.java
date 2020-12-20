package com.example.appdoptame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import clases.Messages;


public class FragListMessages extends Fragment {
    ArrayList<Messages> messages;
    ListView list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        cargarDatos();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_frag_list_messages, null);
        list = (ListView) root.findViewById(R.id.messages_list);
        list.setAdapter(new AdapterM(root.getContext(), messages));
        // Inflate the layout for this fragment
        return root;
    }
    private void cargarDatos() {
        messages = new ArrayList<>();
        messages.add(new Messages(R.drawable.img_user1,"Pablo Marmol"));
        messages.add(new Messages(R.drawable.img_user2,"María Paz"));
        messages.add(new Messages(R.drawable.img_user3,"Chili willi"));
    }
}