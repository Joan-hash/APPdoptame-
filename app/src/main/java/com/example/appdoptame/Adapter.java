package com.example.appdoptame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import clases.Post;

public class Adapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context context;
    ArrayList<Post> posts;

    public Adapter (Context context, ArrayList<Post> posts){
        this.context = context;
        this.posts = posts;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return posts.size();
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
        final View view = inflater.inflate(R.layout.post,null);
        //recuperar views
        TextView descripcion =  (TextView) view.findViewById(R.id.description);
        ImageView image = (ImageView) view.findViewById(R.id.pet);
        //recuperar el objeto
        Post p = posts.get(position);
        //seteamos los valores
        descripcion.setText(p.getDescripcion());
        image.setImageResource(p.getId());
        return view;
    }
}
