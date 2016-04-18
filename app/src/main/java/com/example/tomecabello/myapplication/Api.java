package com.example.tomecabello.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.tomecabello.myapplication.JSON.PKd;
import com.example.tomecabello.myapplication.JSON.Ability;
import com.example.tomecabello.myapplication.JSON.Pok;
import com.example.tomecabello.myapplication.JSON.Pokemon;
import com.example.tomecabello.myapplication.provider.pok.PokColumns;
import com.example.tomecabello.myapplication.provider.pok.PokContentValues;
import com.squareup.picasso.Picasso;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by tomeCabello on 08/11/2015.
 */

//Creamos el cliente donde usaremos retrofit.
public class Api {
    final String BASE_URL = "http://pokeapi.co/api/v1/";//Parte "basica" de la url
    private final Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Interface servei = retrofit.create(Interface.class);

    public Api(Context context){
        super();
        this.context=context;
    }


    public void mv(){
        UpdatePK1 updatePK1 = new UpdatePK1();
        updatePK1.execute();
    }


    String url[] = new String[779];

    //



    //  static final String de= "";
    public void getPk(){
        for (int i= 0; i<150;i++) {
            Call<Pok> call = servei.getPk(i);


            call.enqueue(new Callback<Pok>()


            { //Encolamos

                @Override
                public void onResponse(Response<Pok> response, Retrofit retrofit) { //Si responde, podemos usar el json y añadir a nuestro adapte
                    if (response.isSuccess()) {
                        Log.d(null, "OK");
                        Pok p = response.body();
                        ContentValues[] bulkToInsert;
                        List<ContentValues> mValueList = new ArrayList<>();


                        PokContentValues values = new PokContentValues();
                        System.out.println(p.getCreated());
                        System.out.println(p.getPkdx_id());

                        values.putPkdxId((p.getPkdx_id()));
                        values.putName(p.getName());
                        values.putAttack(p.getAttack());
                        values.putDefense((p.getDefense()));
                        values.putHp((p.getHp()));
                        values.putSpatk((p.getsp_atk()));
                        values.putSpdef(p.getsp_def());
                        values.putSpeed(p.getSpeed());
                        if (p.getTypes().size()==2)
                            values.putTypes(p.getTypes().get(0).getName()+","+p.getTypes().get(1).getName());
                        else{
                            values.putTypes(p.getTypes().get(0).getName());
                        }
                        System.out.println(p.getTypes().get(0).getName());

                        mValueList.add(values.values());


                        bulkToInsert = new ContentValues[mValueList.size()];
                        mValueList.toArray(bulkToInsert);
                        context.getContentResolver().bulkInsert(PokColumns.CONTENT_URI, bulkToInsert);


                    }

                }

                @Override
                public void onFailure(Throwable t) {


                }
            });}

    }




    public void borrar(long sync){

    }


    class UpdatePK1 extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] params) {
            getPk();
            Long syncTime = System.currentTimeMillis();
            borrar(syncTime);

            return null;
        }
    }





    //creamos la interfaz que llamara a la url del json.
    public interface Interface {


        @GET("pokemon/{id}")
        Call<Pok>getPk(
                @Path("id") Integer id);


    }


}
