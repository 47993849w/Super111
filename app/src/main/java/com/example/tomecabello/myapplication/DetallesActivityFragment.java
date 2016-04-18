package com.example.tomecabello.myapplication;



import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tomecabello.myapplication.JSON.Pok;
import com.example.tomecabello.myapplication.provider.equ.EquColumns;
import com.example.tomecabello.myapplication.provider.equ.EquContentValues;
import com.example.tomecabello.myapplication.provider.equ.EquCursor;
import com.example.tomecabello.myapplication.provider.pok.PokColumns;
import com.example.tomecabello.myapplication.provider.pok.PokCursor;
import com.squareup.picasso.Picasso;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetallesActivityFragment extends Fragment {
    private long id;
    private TextView numer;
    ImageView image3;
    TextView defensa;
    TextView ataque;
    TextView ataquee;
    TextView nombre;
    TextView defensae;
    TextView velo;
    TextView ps;
    ImageView imageView;
    ImageView tipo;
    public DetallesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles, container, false);

        getActivity().setTitle("Detalles");

        //super.onCreate(savedInstanceState);
        // Intent i = getActivity().getIntent();
        //Result item = (Result) i.getSerializableExtra("item");
        // getActivity().setTitle(item.getTitle());
        // Toast.makeText(getContext(),item.getTitle() , Toast.LENGTH_LONG).show();

        imageView = (ImageView) view.findViewById(R.id.imagen);
        nombre = (TextView) view.findViewById(R.id.nombre);
        //SpannableString content = new SpannableString(item.getTitle());
        // content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        //title.setText(content);
        defensa = (TextView) view.findViewById(R.id.defensa);
        ataque = (TextView) view.findViewById(R.id.ataqu);
        ataquee = (TextView) view.findViewById(R.id.ataquee);

        defensae = (TextView) view.findViewById(R.id.defensae);
        tipo = (ImageView) view.findViewById(R.id.iTip);
        velo = (TextView) view.findViewById(R.id.velocidad);



        Button button2 = (Button) view.findViewById(R.id.capturar);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor1 = getContext().getContentResolver().query(
                        EquColumns.CONTENT_URI,
                        null,
                        null,
                        null,
                        null);
                EquCursor eqCur1 = new EquCursor(cursor1);
                eqCur1.moveToNext();
                System.out.println(eqCur1.getCount());




                if (eqCur1.getCount()>=6){
                    Toast.makeText(getActivity(), "Equipo lleno",
                            Toast.LENGTH_LONG).show();

                }

                else {
                    Cursor cursor = getContext().getContentResolver().query(
                            PokColumns.CONTENT_URI,
                            null,
                            PokColumns._ID + " = ?",
                            new String[]{String.valueOf(id)},
                            null);
                    PokCursor pokCursor = new PokCursor(cursor);
                    pokCursor.moveToNext();
                    ContentValues[] bulkToInsert;
                    List<ContentValues> mValueList = new ArrayList<>();
                    Long syncTime = System.currentTimeMillis();

                    ArrayList<ContentValues> valuesList = new ArrayList<>();
                    ////int i=1;
                    Pok pk = new Pok();

                    EquContentValues values = new EquContentValues();
                    System.out.println(pokCursor.getCount());


                    values.putPkdxId((pokCursor.getPkdxId()));
                    values.putName(pokCursor.getName());
                    values.putAttack(pokCursor.getAttack());
                    values.putDefense((pokCursor.getDefense()));
                    values.putHp((pokCursor.getHp()));
                    values.putSpatk((pokCursor.getSpatk()));
                    values.putSpdef(pokCursor.getSpdef());
                    values.putSpeed(pokCursor.getSpeed());


                    mValueList.add(values.values());


                    bulkToInsert = new ContentValues[mValueList.size()];
                    mValueList.toArray(bulkToInsert);
                    getContext().getContentResolver().bulkInsert(EquColumns.CONTENT_URI, bulkToInsert);
                    Toast.makeText(getActivity(), "Pokemon atrapado!!",
                            Toast.LENGTH_LONG).show();

                }

            }
        });



        ps = (TextView) view.findViewById(R.id.salud);
        numer = (TextView) view.findViewById(R.id.numero);


        // System.out.println(HH///////////&787878787878787878787878787878787878323333333333333333333");
        Intent i = getActivity().getIntent();
        System.out.println(i+"OOOPPPPPPPUEEEEEEEEEEEEEHHHHHHHHHHHHHGGGGGGGGG");
        id = i.getLongExtra("example._id", -1);
        System.out.println(id + "HHHHHHHHHHHHHHH///////////&787878787878787878787878787878787878323333333333333333333");

        if (id != -1) {
            details();
        }
        return view;
    }

    public void details()

    {


        Cursor cursor = getContext().getContentResolver().query(
                PokColumns.CONTENT_URI,
                null,
                PokColumns._ID + " = ?",
                new String[]{String.valueOf(id)},
                null);
        PokCursor pokCursor = new PokCursor(cursor);
        pokCursor.moveToNext();
        int h = 0;
        MediaPlayer mp;
        String variablename = "a"+pokCursor.getPkdxId();
        mp = MediaPlayer.create(getContext(), getResId(variablename, R.raw.class));
        mp.start();
        nombre.setText(pokCursor.getName());
        numer.setText("#"+pokCursor.getPkdxId());
        ataque.setText(ataque.getText() + pokCursor.getAttack().toString() + "   ");
        defensae.setText(defensae.getText()+pokCursor.getSpdef().toString());
        velo.setText(velo.getText()+pokCursor.getSpeed().toString()+"   ");
        ataquee.setText(ataquee.getText() + pokCursor.getAttack().toString() + "   ");
        ps.setText(ps.getText() + pokCursor.getHp().toString());
        Picasso.with(getContext()).load("http://pokeapi.co/media/img/"+pokCursor.getPkdxId()+".png").resize(200, 200).into(imageView);




        if (pokCursor.getTypes().contains("water"))
            Picasso.with(getContext()).load(R.drawable.tipo_agua).resize(50,18).into(tipo);
        if (pokCursor.getTypes().contains("poison"))
            Picasso.with(getContext()).load(R.drawable.tipo_veneno).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("flying"))
            Picasso.with(getContext()).load(R.drawable.tipo_volador).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("ice"))
            Picasso.with(getContext()).load(R.drawable.tipo_hielo).resize(50, 18).into(tipo);

        if (pokCursor.getTypes().contains("electric"))
            Picasso.with(getContext()).load(R.drawable.tipo_electrico).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("figth"))
            Picasso.with(getContext()).load(R.drawable.tipo_lucha).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("fire"))
            Picasso.with(getContext()).load(R.drawable.tipo_fuego).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("ghost"))
            Picasso.with(getContext()).load(R.drawable.tipo_fantasma).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("dark"))
            Picasso.with(getContext()).load(R.drawable.tipo_siniestro).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("dragon"))
            Picasso.with(getContext()).load(R.drawable.tipo_dragon).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("fairy"))
            Picasso.with(getContext()).load(R.drawable.tipo_hada).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("ground"))
            Picasso.with(getContext()).load(R.drawable.tipo_tierra).resize(50, 18).into(tipo);

        if (pokCursor.getTypes().contains("rock"))
            Picasso.with(getContext()).load(R.drawable.tipo_roca).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("bug"))
            Picasso.with(getContext()).load(R.drawable.tipo_bicho).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("steel"))
            Picasso.with(getContext()).load(R.drawable.tipo_acero).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("psychic"))
            Picasso.with(getContext()).load(R.drawable.tipo_psquico).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("grass"))
            Picasso.with(getContext()).load(R.drawable.tipo_planta).resize(50, 18).into(tipo);
        if (pokCursor.getTypes().contains("normal"))
            Picasso.with(getContext()).load(R.drawable.tipo_normal).resize(50, 18).into(tipo);





        defensa.setText(defensa.getText()+pokCursor.getDefense().toString());



















    }
    public static int getResId(String variableName, Class<?> c) {
        Field field = null;
        int resId = 0;
        try {
            field = c.getField(variableName);
            try {
                resId = field.getInt(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resId;
    }
}

