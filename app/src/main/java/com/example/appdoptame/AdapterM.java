package com.example.appdoptame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import clases.Messages;

public class AdapterM extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context context;
    ArrayList<Messages> messages;

    public AdapterM(Context context, ArrayList<Messages> messages){
        this.context = context;
        this.messages = messages;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = inflater.inflate(R.layout.message, null);
        //recuperar views
        TextView descripcion =  (TextView) view.findViewById(R.id.user_name);
        ImageView image = (ImageView) view.findViewById(R.id.user);
        //recuperar el objeto
        Messages m = messages.get(position);
        //seteamos los valores
        descripcion.setText(m.getNombreUsuario());
        image.setImageResource(m.getId());
        return view;
    }
}
