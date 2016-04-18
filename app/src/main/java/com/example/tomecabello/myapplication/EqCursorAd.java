package com.example.tomecabello.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.tomecabello.myapplication.provider.equ.EquColumns;
import com.example.tomecabello.myapplication.provider.equ.EquCursor;
import com.squareup.picasso.Picasso;

/**
 * Created by tomeCabello on 17/04/2016.
 */
public class EqCursorAd extends SimpleCursorAdapter implements Filterable{
    private final Context context;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public EqCursorAd(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }






    public View getView(final int position, View convertView, ViewGroup parent){



        Cursor cursor = getCursor();
        EquCursor pc = new EquCursor(cursor);
        pc.moveToPosition(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.ly_pk1, parent, false);
        }



        final TextView titulo = (TextView ) convertView.findViewById(R.id.nombre);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        Button button = (Button) convertView.findViewById(R.id.combate);

        Button button1 = (Button) convertView.findViewById(R.id.Soltar);
        int n = pc.getPkdxId();
        final Long id1 = pc.getId();
        final Long id = Long.valueOf(n);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.getContentResolver().delete(
                        EquColumns.CONTENT_URI,

                        EquColumns._ID + " = ?",
                        new String[]{String.valueOf(id1)})
                ;
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PokeActivity.class);
                i.putExtra("example._id", id);

                context.startActivity(i);


            }
        });
        titulo.setText(pc.getName());


        Picasso.with(context).load("http://pokeapi.co/media/img/"+pc.getPkdxId()+".png").fit().into(imageView);

        return convertView;

    }
}