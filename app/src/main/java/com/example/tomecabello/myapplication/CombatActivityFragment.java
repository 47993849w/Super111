package com.example.tomecabello.myapplication;

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

import com.example.tomecabello.myapplication.provider.pok.PokColumns;
import com.example.tomecabello.myapplication.provider.pok.PokCursor;
import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class CombatActivityFragment extends Fragment {

    TextView pokemon1;
    TextView pokemon2;
    Long id;
    Long id1;
    int n;
    int a;
    int p;
    int D;
    int b;
    int e;
    int v;

    TextView turno1;
    TextView turno2;
    TextView PS2;
    TextView PS1;

    int ata1;
    int ata2;
    int def1;
    int def2;
    int atae;
    int atae2;
    int defe1;
    int defe2;
    int ps1;
    int ps2;
    MediaPlayer mp;

    ImageView imageView;
    ImageView imageView2;
    private Button ataque1;
    private Button ataque2;
    private Button ataque3;
    private Button ataque4;

    public CombatActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle("Combate Pokemon");

        View view = inflater.inflate(R.layout.fragment_combat, container, false);
        pokemon1 = (TextView) view.findViewById(R.id.Pokemon1);
        pokemon2 = (TextView) view.findViewById(R.id.Pokemon2);

        PS2 = (TextView) view.findViewById(R.id.PS2);
        turno2 = (TextView) view.findViewById(R.id.turno2);

        PS1 = (TextView) view.findViewById(R.id.PS1);
        turno1 = (TextView) view.findViewById(R.id.turno1);
        imageView = (ImageView) view.findViewById(R.id.imageView3);
        imageView2 = (ImageView) view.findViewById(R.id.imageView4);


        turno2.setText("ESPERA");
        mp = MediaPlayer.create(getContext(), R.raw.pokemona);
        mp.start();

        ataque1 = (Button) view.findViewById(R.id.Ataque1);

        ataque1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ataque1();
            }
        });


        ataque2 = (Button) view.findViewById(R.id.Ataque2);

        ataque2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ataque2();
            }
        });

        ataque3 = (Button) view.findViewById(R.id.Ataque3);

        ataque3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ataque3();
            }
        });

        ataque4 = (Button) view.findViewById(R.id.Ataque4);

        ataque4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ataque4();
            }
        });


        ataque2.setEnabled(false);
        ataque4.setEnabled(false);

        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        id = extras.getLong("pok2");
        id1 = extras.getLong("pok1");
        System.out.println(id);
        System.out.println(id1);
        if (id != -1) {
            details();
        }

        if (id1 != -1) {
            details1();
        }
        return view;
    }public void details()

    {


        System.out.println("y" + id);
        Cursor cursor = getContext().getContentResolver().query(
                PokColumns.CONTENT_URI,
                null,
                PokColumns.PKDX_ID + " = ?",
                new String[]{String.valueOf(id)},
                null);
        PokCursor pokCursor = new PokCursor(cursor);
        pokCursor.moveToNext();
        int h = 0;
        ata1=pokCursor.getAttack();
        def1= (pokCursor.getDefense());
        atae= (pokCursor.getSpatk());
        defe1=pokCursor.getSpdef();
        ps1= (pokCursor.getHp())+100;
        Picasso.with(getContext()).load("http://pokeapi.co/media/img/"+pokCursor.getPkdxId()+".png").resize(200,200).into(imageView2);

        if (pokCursor.getTypes().contains("dragon"))
            ataque1.setText("F. Dragon");
        if (pokCursor.getTypes().contains("water"))
            ataque1.setText("Cascada");
        if (pokCursor.getTypes().contains("ice"))
            ataque1.setText("Bola hielo");
        if (pokCursor.getTypes().contains("normal"))
            ataque1.setText("Placaje");
        if (pokCursor.getTypes().contains("fire"))
            ataque1.setText("Envite igneo");
        if (pokCursor.getTypes().contains("fight"))
            ataque1.setText("Doble patada");
        if (pokCursor.getTypes().contains("electric"))
            ataque1.setText("Chispa");
        if (pokCursor.getTypes().contains("dark"))
            ataque1.setText("Golpe oscuro");
        if (pokCursor.getTypes().contains("rock"))
            ataque1.setText("Pedrada");
        if (pokCursor.getTypes().contains("ground"))
            ataque1.setText("Terremoto");
        if (pokCursor.getTypes().contains("steel"))
            ataque1.setText("Ala de acero");
        if (pokCursor.getTypes().contains("flying"))
            ataque1.setText("Acrobata");
        if (pokCursor.getTypes().contains("grass"))
            ataque1.setText("Latigo cepa");
        if (pokCursor.getTypes().contains("poison"))
            ataque1.setText("Colmillo veneno");
        if (pokCursor.getTypes().contains("psychic"))
            ataque1.setText("Golpe psquico");
        if (pokCursor.getTypes().contains("ghost"))
            ataque1.setText("Golpe fantasma");
        if (pokCursor.getTypes().contains("bug"))
            ataque1.setText("Tijera");


        if (pokCursor.getTypes().contains("water"))
            ataque3.setText("Burbuja");
        if (pokCursor.getTypes().contains("dragon"))
            ataque3.setText("Dragoaliento");
        if (pokCursor.getTypes().contains("water"))
            ataque3.setText("Burbuja");
        if (pokCursor.getTypes().contains("ice"))
            ataque3.setText("Rayo hielo");
        if (pokCursor.getTypes().contains("normal"))
            ataque3.setText("Onda basica");
        if (pokCursor.getTypes().contains("fire"))
            ataque3.setText("Llamarada");
        if (pokCursor.getTypes().contains("fight"))
            ataque3.setText("Onda certera");
        if (pokCursor.getTypes().contains("electric"))
            ataque3.setText("Trueno");
        if (pokCursor.getTypes().contains("dark"))
            ataque3.setText("Bestia");
        if (pokCursor.getTypes().contains("rock"))
            ataque3.setText("Piedra levit");
        if (pokCursor.getTypes().contains("ground"))
            ataque3.setText("Tierra viva");
        if (pokCursor.getTypes().contains("steel"))
            ataque3.setText("Onda metal");
        if (pokCursor.getTypes().contains("flying"))
            ataque3.setText("Tornado");
        if (pokCursor.getTypes().contains("grass"))
            ataque3.setText("Hoja magica");
        if (pokCursor.getTypes().contains("poison"))
            ataque3.setText("Acido");
        if (pokCursor.getTypes().contains("psychic"))
            ataque3.setText("Psquico");
        if (pokCursor.getTypes().contains("ghost"))
            ataque3.setText("Maldicion");
        if (pokCursor.getTypes().contains("bug"))
            ataque3.setText("Polvo bicho");
        PS1.setText("PS: "+String.valueOf(ps1));
        pokemon1.setText((pokCursor.getName()));


    }public void details1()

    {



        Cursor cursor = getContext().getContentResolver().query(
                PokColumns.CONTENT_URI,
                null,
                PokColumns._ID + " = ?",
                new String[]{String.valueOf(id1)},
                null);
        PokCursor pokCursor = new PokCursor(cursor);
        pokCursor.moveToNext();
        pokemon2.setText(pokCursor.getName());
        int h = 0;
        ata2=pokCursor.getAttack();
        def2 = (pokCursor.getDefense());
        atae2= (pokCursor.getSpatk());
        defe2=pokCursor.getSpdef();
        ps2= (pokCursor.getHp())+100;
        Picasso.with(getContext()).load("http://pokeapi.co/media/img/"+pokCursor.getPkdxId()+".png").resize(200,200).into(imageView);
        if (pokCursor.getTypes().contains("water"))
            ataque2.setText("Cascada");
        if (pokCursor.getTypes().contains("dragon"))
            ataque2.setText("F. Dragon");
        if (pokCursor.getTypes().contains("water"))
            ataque2.setText("Cascada");
        if (pokCursor.getTypes().contains("ice"))
            ataque2.setText("Bola hielo");
        if (pokCursor.getTypes().contains("normal"))
            ataque2.setText("Placaje");
        if (pokCursor.getTypes().contains("fire"))
            ataque2.setText("Envite igneo");
        if (pokCursor.getTypes().contains("fight"))
            ataque2.setText("Doble patada");
        if (pokCursor.getTypes().contains("electric"))
            ataque2.setText("Chispa");
        if (pokCursor.getTypes().contains("dark"))
            ataque2.setText("Golpe oscuro");
        if (pokCursor.getTypes().contains("rock"))
            ataque2.setText("Pedrada");
        if (pokCursor.getTypes().contains("ground"))
            ataque2.setText("Terremoto");
        if (pokCursor.getTypes().contains("steel"))
            ataque2.setText("Ala de acero");
        if (pokCursor.getTypes().contains("flying"))
            ataque2.setText("Acrobata");
        if (pokCursor.getTypes().contains("grass"))
            ataque2.setText("Latigo cepa");
        if (pokCursor.getTypes().contains("poison"))
            ataque2.setText("Colmillo veneno");
        if (pokCursor.getTypes().contains("psychic"))
            ataque2.setText("Golpe psiquico");
        if (pokCursor.getTypes().contains("ghost"))
            ataque2.setText("Golpe fantasma");
        if (pokCursor.getTypes().contains("bug"))
            ataque2.setText("Tijera");


        if (pokCursor.getTypes().contains("water"))
            ataque4.setText("Burbuja");
        if (pokCursor.getTypes().contains("dragon"))
            ataque4.setText("Dragoaliento");
        if (pokCursor.getTypes().contains("water"))
            ataque4.setText("Burbuja");
        if (pokCursor.getTypes().contains("ice"))
            ataque4.setText("Rayo hielo");
        if (pokCursor.getTypes().contains("normal"))
            ataque4.setText("Onda basica");
        if (pokCursor.getTypes().contains("fire"))
            ataque4.setText("Llamarada");
        if (pokCursor.getTypes().contains("fight"))
            ataque4.setText("Onda certera");
        if (pokCursor.getTypes().contains("electric"))
            ataque4.setText("Trueno");
        if (pokCursor.getTypes().contains("dark"))
            ataque4.setText("Bestia");
        if (pokCursor.getTypes().contains("rock"))
            ataque4.setText("Piedra levit");
        if (pokCursor.getTypes().contains("ground"))
            ataque4.setText("Tierra viva");
        if (pokCursor.getTypes().contains("steel"))
            ataque4.setText("Onda metal");
        if (pokCursor.getTypes().contains("flying"))
            ataque4.setText("Tornado");
        if (pokCursor.getTypes().contains("grass"))
            ataque4.setText("Hoja magica");
        if (pokCursor.getTypes().contains("poison"))
            ataque4.setText("Acido");
        if (pokCursor.getTypes().contains("psychic"))
            ataque4.setText("Psquico");
        if (pokCursor.getTypes().contains("ghost"))
            ataque4.setText("Maldicion");
        if (pokCursor.getTypes().contains("bug"))
            ataque4.setText("Polvo bicho");

        PS2 .setText("PS: " + ps2);

    }


    public void ataque1(){

        b=1;
        e=1;
        v=85;
        n=50;
        a=ata1;
        p=50;
        D=def2;
        double d1 = (0.01*b*e*v);
        double d2 = 0.2*n+1;
        double d3 = a*p;
        double d4 = 25*D;

        double d5= d2*d3;

        double d6 = d5/d4;

        double d7 = d6+2;

        int d = (int) (d1*d7);


        System.out.println(ps1+100);
        System.out.println(d);
        ps2 = ps2-d;
        PS2.setText("PS: " + ps2);
        System.out.println(ps2);

        turno1.setText("ESPERA");
        turno2.setText("TU TURNO");

        ataque1.setEnabled(false);
        ataque2.setEnabled(true);
        ataque3.setEnabled(false);
        ataque4.setEnabled(true);
        turno();
    }


    public void ataque3(){

        b=1;
        e=1;
        v=85;
        n=50;
        a=atae;
        p=50;
        D=defe2;
        double d1 = (0.01*b*e*v);
        double d2 = 0.2*n+1;
        double d3 = a*p;
        double d4 = 25*D;

        double d5= d2*d3;

        double d6 = d5/d4;

        double d7 = d6+2;

        int d = (int) (d1*d7);


        System.out.println(ps1+100);
        System.out.println(d);
        ps2 = ps2-d;
        PS2.setText("PS: " + ps2);
        System.out.println(ps2);

        turno1.setText("ESPERA");
        turno2.setText("TU TURNO");

        ataque1.setEnabled(false);
        ataque2.setEnabled(true);
        ataque3.setEnabled(false);
        ataque4.setEnabled(true);
        turno();
    }

    public void ataque2(){

        b=1;
        e=1;
        v=85;
        n=50;
        a=ata2;
        p=50;
        D=def1;
        double d1 = (0.01*b*e*v);
        double d2 = 0.2*n+1;
        double d3 = a*p;
        double d4 = 25*D;

        double d5= d2*d3;

        double d6 = d5/d4;

        double d7 = d6+2;

        int d = (int) (d1*d7);


        System.out.println(ps1+100);
        System.out.println(d);
        ps1= ps1-d;
        PS1.setText("PS: " + ps1);
        System.out.println(ps2);

        turno1.setText("TU TURNO!");
        turno2.setText("ESPERA!");
        ataque2.setEnabled(false);
        ataque1.setEnabled(true);
        ataque3.setEnabled(true);
        ataque4.setEnabled(false);
        turno();

    }
    public void ataque4(){

        b=1;
        e=1;
        v=85;
        n=50;
        a=atae2;
        p=50;
        D=defe1;
        double d1 = (0.01*b*e*v);
        double d2 = 0.2*n+1;
        double d3 = a*p;
        double d4 = 25*D;

        double d5= d2*d3;

        double d6 = d5/d4;

        double d7 = d6+2;

        int d = (int) (d1*d7);


        System.out.println(ps1+100);
        System.out.println(d);
        ps1= ps1-d;
        PS1.setText("PS: " + ps1);
        System.out.println(ps2);

        turno1.setText("TU TURNO!");
        turno2.setText("ESPERA!");
        ataque2.setEnabled(false);
        ataque1.setEnabled(true);
        ataque3.setEnabled(true);
        ataque4.setEnabled(false);
        turno();

    }


    public void turno() {
        if (ps1 <= 0) {
            PS1.setText("Debilitado");
            turno1.setText("HAS PERDIDO");
            turno2.setText("HAS GANADO");

            ataque2.setEnabled(false);
            ataque1.setEnabled(false);
            ataque3.setEnabled(false);
            ataque4.setEnabled(false);
            ataque2.setEnabled(false);
            ataque1.setEnabled(false);
            ataque3.setEnabled(false);
            ataque4.setEnabled(false);
            Toast.makeText(getActivity(), "Has perdido!!",
                    Toast.LENGTH_LONG).show();

        }

        if (ps2 <= 0){
            PS2.setText("Debilitado");
            turno2.setText("HAS PERDIDO");
            turno1.setText("HAS GANADO");

            ataque2.setEnabled(false);
            ataque1.setEnabled(false);
            ataque3.setEnabled(false);
            ataque4.setEnabled(false);
            Toast.makeText(getActivity(), "Has ganado",
                    Toast.LENGTH_LONG).show();
            mp.stop();
            mp.reset();
            mp.release();
            mp = null;
            mp = MediaPlayer.create(getContext(), R.raw.pokemonb);
            mp.start();
        }

    }


    @Override
    public void onDestroy() {

        super.onDestroy();

        mp.stop();
        mp.reset();
        mp.release();
        mp = null;
    }

}

