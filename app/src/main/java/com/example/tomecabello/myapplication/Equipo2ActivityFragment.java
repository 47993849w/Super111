package com.example.tomecabello.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tomecabello.myapplication.JSON.Ability;
import com.example.tomecabello.myapplication.provider.equ.EquColumns;
import com.example.tomecabello.myapplication.provider.equ.EquCursor;
import com.example.tomecabello.myapplication.provider.pok.PokColumns;
import com.example.tomecabello.myapplication.provider.pok.PokCursor;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class Equipo2ActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor> {
    private ArrayList<Ability> items;
    private EqCursorAd adapter;

    private ListView pk;

    public Equipo2ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_equipo2, container, false);


        pk = (ListView)rootView.findViewById(R.id.pk);
        pk.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                getContext().getContentResolver().delete(
                        EquColumns.CONTENT_URI,

                        EquColumns._ID + " = ?",
                        new String[]{String.valueOf(id)})
                ;

                return true;
            }

        });
        onC1();
        return rootView;
    }
    String sele;
    public void onC1(){
        items = new ArrayList<>();
        adapter = new EqCursorAd(
                getContext(),
                R.layout.ly_pk,
                null,
                new String[]{
                        EquColumns.NAME,
                        EquColumns.HP,
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
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                EquColumns.CONTENT_URI, null, null,null, null);    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);

    }
}
