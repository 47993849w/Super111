package com.example.tomecabello.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.tomecabello.myapplication.provider.pok.PokCursor;
import com.squareup.picasso.Picasso;

/**
 * Created by 47993849w on 18/12/15.
 */




public class PokCursorAd extends SimpleCursorAdapter implements Filterable{
    private final Context context;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public PokCursorAd(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }






    public View getView(int position, View convertView, ViewGroup parent){


        Cursor cursor = getCursor();
        PokCursor pc = new PokCursor(cursor);
        pc.moveToPosition(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.ly_pk, parent, false);
        }

        TextView titulo = (TextView ) convertView.findViewById(R.id.nombre);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        titulo.setText(pc.getName());


        Picasso.with(context).load("http://pokeapi.co/media/img/"+pc.getPkdxId()+".png").fit().into(imageView);

        return convertView;

    }
}