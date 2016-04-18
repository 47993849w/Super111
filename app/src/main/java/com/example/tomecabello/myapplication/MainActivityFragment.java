package com.example.tomecabello.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tomecabello.myapplication.JSON.Ability;
import com.example.tomecabello.myapplication.provider.pok.PokColumns;
import com.example.tomecabello.myapplication.provider.pok.PokCursor;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemSelectedListener {




    //declaramos nuestro adaptador personal
    private ArrayList<Ability> items;
    private PokCursorAd adapter;
    private PokCursorAd ad;

    private ListView pk;

    Spinner spinner;


    EditText textView;
    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        if (!preferences.contains("first_sync")) {
            Api api = new Api(getContext());
            api.mv();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("first_sync", true);
            editor.apply();
        }
    }


    public void onStart() {
        super.onStart();

        getLoaderManager().restartLoader(0, null, this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        pk = (ListView)rootView.findViewById(R.id.pk);



        textView = (EditText) rootView.findViewById(R.id.searchView);
        spinner = (Spinner) rootView.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter1);
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                System.out.println("ññññññ");
                pk.setAdapter(ad);

                onStart();
                onC1();
            }


        });


        onC1();





        pk.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(), DetallesActivity.class);
                i.putExtra("example._id", id);

                startActivity(i);

            }

        });
        return rootView;
    }


    String sele;
    public void onC1(){
        items = new ArrayList<>();
        adapter = new PokCursorAd(
                getContext(),
                R.layout.ly_pk,
                null,
                new String[]{
                        PokColumns.NAME,
                        PokColumns.HP,
                        //PokColumns.AUDIENCESCORE
                },
                new int[]{
                        R.id.imageView,
                        R.id.pk,
                        R.id.defensa
                },
                0


        );
        getLoaderManager().initLoader(0, null, this);
        pk.setAdapter(adapter);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }



    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] g = {"%"+textView.getText().toString()+"%"};
        return new CursorLoader(getContext(),
                PokColumns.CONTENT_URI, null, "NAME LIKE ?", g, sele);    }



    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(spinner.getSelectedItem().toString()+"GF");
        if (spinner.getSelectedItem().toString().equals("PS"))
            sele="hp";
        if (spinner.getSelectedItem().toString().equals("Ataque"))
            sele="attack";
        if (spinner.getSelectedItem().toString().equals("Defensa"))
            sele="defense";
        if (spinner.getSelectedItem().toString().equals("Defensa esp"))
            sele="spdef";
        if (spinner.getSelectedItem().toString().equals("Velocidad"))
            sele="speed";
        if (spinner.getSelectedItem().toString().equals("Nombre"))
            sele="name";
        if (spinner.getSelectedItem().toString().equals("Numero Pokedex"))
            sele="pkdx_id";
        if (spinner.getSelectedItem().toString().equals("Ataque esp"))
            sele="spatk";
        pk.setAdapter(ad);

        onStart();
        onC1();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
