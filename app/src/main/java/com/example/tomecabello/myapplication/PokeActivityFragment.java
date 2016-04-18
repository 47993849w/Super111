package com.example.tomecabello.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tomecabello.myapplication.JSON.Ability;
import com.example.tomecabello.myapplication.provider.pok.PokColumns;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PokeActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{

    private Long id1;
    private ArrayList<Ability> items;
    private PokCursorAd adapter;
    private PokCursorAd ad;
    private SwipeRefreshLayout srlRef;

    private ListView pk;

    Spinner spinner;
    private ListView mListView;
    SearchView searchView;

    EditText textView;


    public PokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_poke, container, false);
        pk = (ListView)rootView.findViewById(R.id.pk);

        Intent i = getActivity().getIntent();
        System.out.println(i + "juj");

        id1 = i.getLongExtra("example._id", -1);
        System.out.println(id1 + "juj");

        getActivity().setTitle("Elige Pokemon");

        // textView = (EditText) rootView.findViewById(R.id.searchView);


        onC1();


        /*
        pokemon1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                System.out.println("ñññññññ");
                return false;
            }
        });
*/


        pk.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(), CombatActivity.class);
                Bundle extras = new Bundle();

                extras.putLong("pok1", id);
                extras.putLong("pok2", id1);
                i.putExtras(extras);

                startActivity(i);

            }

        });





        return rootView;
    }
    public void onC1() {
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
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                PokColumns.CONTENT_URI, null, null, null, "NAME");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);

    }
}
