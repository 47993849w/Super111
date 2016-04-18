package com.example.tomecabello.myapplication.provider.pok;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.tomecabello.myapplication.provider.PokemProvider;
import com.example.tomecabello.myapplication.provider.equ.EquColumns;
import com.example.tomecabello.myapplication.provider.pok.PokColumns;

/**
 * Columns for the {@code pok} table.
 */
public class PokColumns implements BaseColumns {
    public static final String TABLE_NAME = "pok";
    public static final Uri CONTENT_URI = Uri.parse(PokemProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String PKDX_ID = "pkdx_id";

    public static final String NAME = "name";

    public static final String CATCH_RATE = "catch_rate";

    public static final String ATTACK = "attack";

    public static final String DEFENSE = "defense";

    public static final String SPATK = "spatk";

    public static final String SPDEF = "spdef";

    public static final String WEIGHT = "weight";

    public static final String SPEED = "speed";

    public static final String HP = "hp";

    public static final String SYNCTIME = "SYNCTIME";

    public static final String TYPES = "types";

    public static final String IMAGE = "image";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            PKDX_ID,
            NAME,
            CATCH_RATE,
            ATTACK,
            DEFENSE,
            SPATK,
            SPDEF,
            WEIGHT,
            SPEED,
            HP,
            SYNCTIME,
            TYPES,
            IMAGE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(PKDX_ID) || c.contains("." + PKDX_ID)) return true;
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(CATCH_RATE) || c.contains("." + CATCH_RATE)) return true;
            if (c.equals(ATTACK) || c.contains("." + ATTACK)) return true;
            if (c.equals(DEFENSE) || c.contains("." + DEFENSE)) return true;
            if (c.equals(SPATK) || c.contains("." + SPATK)) return true;
            if (c.equals(SPDEF) || c.contains("." + SPDEF)) return true;
            if (c.equals(WEIGHT) || c.contains("." + WEIGHT)) return true;
            if (c.equals(SPEED) || c.contains("." + SPEED)) return true;
            if (c.equals(HP) || c.contains("." + HP)) return true;
            if (c.equals(SYNCTIME) || c.contains("." + SYNCTIME)) return true;
            if (c.equals(TYPES) || c.contains("." + TYPES)) return true;
            if (c.equals(IMAGE) || c.contains("." + IMAGE)) return true;
        }
        return false;
    }

}
