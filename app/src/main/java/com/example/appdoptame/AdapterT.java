package com.example.appdoptame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import clases.Tip;

public class AdapterT extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context context;
    ArrayList<Tip> tips;

    public AdapterT(Context context, ArrayList<Tip> tips){
        this.context = context;
        this.tips = tips;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return tips.size();
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
        final View view = inflater.inflate(R.layout.tips, null);
        //recuperar views
        TextView titulo = (TextView) view.findViewById(R.id.title_tip);
        TextView contenido = (TextView) view.findViewById(R.id.content_tip);
        ImageView imagenTip = (ImageView) view.findViewById(R.id.img_tip);
        //recuperar el objeto
        Tip t = tips.get(position);
        //seteamos los valores
        titulo.setText(t.getTitulo());
        contenido.setText(t.getContenidoTip());
        imagenTip.setImageResource(t.getId());
        return view;
    }
}
