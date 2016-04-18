package com.example.tomecabello.myapplication.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.example.tomecabello.myapplication.BuildConfig;
import com.example.tomecabello.myapplication.provider.equ.EquColumns;
import com.example.tomecabello.myapplication.provider.pok.PokColumns;

public class PokemSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = PokemSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "example.db";
    private static final int DATABASE_VERSION = 1;
    private static PokemSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final PokemonSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_EQU = "CREATE TABLE IF NOT EXISTS "
            + EquColumns.TABLE_NAME + " ( "
            + EquColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + EquColumns.PKDX_ID + " INTEGER, "
            + EquColumns.NAME + " TEXT, "
            + EquColumns.CATCH_RATE + " INTEGER, "
            + EquColumns.ATTACK + " INTEGER, "
            + EquColumns.DEFENSE + " INTEGER, "
            + EquColumns.SPATK + " INTEGER, "
            + EquColumns.SPDEF + " INTEGER, "
            + EquColumns.WEIGHT + " INTEGER, "
            + EquColumns.SPEED + " INTEGER, "
            + EquColumns.HP + " INTEGER, "
            + EquColumns.SYNCTIME + " TEXT, "
            + EquColumns.ESTADO + " TEXT, "
            + EquColumns.TYPES + " TEXT, "
            + EquColumns.IMAGE + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_POK = "CREATE TABLE IF NOT EXISTS "
            + PokColumns.TABLE_NAME + " ( "
            + PokColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PokColumns.PKDX_ID + " INTEGER, "
            + PokColumns.NAME + " TEXT, "
            + PokColumns.CATCH_RATE + " INTEGER, "
            + PokColumns.ATTACK + " INTEGER, "
            + PokColumns.DEFENSE + " INTEGER, "
            + PokColumns.SPATK + " INTEGER, "
            + PokColumns.SPDEF + " INTEGER, "
            + PokColumns.WEIGHT + " INTEGER, "
            + PokColumns.SPEED + " INTEGER, "
            + PokColumns.HP + " INTEGER, "
            + PokColumns.SYNCTIME + " TEXT, "
            + PokColumns.TYPES + " TEXT, "
            + PokColumns.IMAGE + " TEXT "
            + " );";

    // @formatter:on

    public static PokemSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static PokemSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static PokemSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new PokemSQLiteOpenHelper(context);
    }

    private PokemSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new PokemonSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static PokemSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new PokemSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private PokemSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new PokemonSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_EQU);
        db.execSQL(SQL_CREATE_TABLE_POK);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
