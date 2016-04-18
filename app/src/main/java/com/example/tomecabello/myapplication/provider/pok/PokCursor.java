package com.example.tomecabello.myapplication.provider.pok;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.tomecabello.myapplication.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code pok} table.
 */
public class PokCursor extends AbstractCursor implements PokModel {
    public PokCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PokColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code pkdx_id} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getPkdxId() {
        Integer res = getIntegerOrNull(PokColumns.PKDX_ID);
        return res;
    }

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(PokColumns.NAME);
        return res;
    }

    /**
     * Get the {@code catch_rate} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getCatchRate() {
        Integer res = getIntegerOrNull(PokColumns.CATCH_RATE);
        return res;
    }

    /**
     * Get the {@code attack} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getAttack() {
        Integer res = getIntegerOrNull(PokColumns.ATTACK);
        return res;
    }

    /**
     * Get the {@code defense} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getDefense() {
        Integer res = getIntegerOrNull(PokColumns.DEFENSE);
        return res;
    }

    /**
     * Get the {@code spatk} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getSpatk() {
        Integer res = getIntegerOrNull(PokColumns.SPATK);
        return res;
    }

    /**
     * Get the {@code spdef} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getSpdef() {
        Integer res = getIntegerOrNull(PokColumns.SPDEF);
        return res;
    }

    /**
     * Get the {@code weight} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getWeight() {
        Integer res = getIntegerOrNull(PokColumns.WEIGHT);
        return res;
    }

    /**
     * Get the {@code speed} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getSpeed() {
        Integer res = getIntegerOrNull(PokColumns.SPEED);
        return res;
    }

    /**
     * Get the {@code hp} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getHp() {
        Integer res = getIntegerOrNull(PokColumns.HP);
        return res;
    }

    /**
     * Get the {@code synctime} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSynctime() {
        String res = getStringOrNull(PokColumns.SYNCTIME);
        return res;
    }

    /**
     * Get the {@code types} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTypes() {
        String res = getStringOrNull(PokColumns.TYPES);
        return res;
    }

    /**
     * Get the {@code image} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getImage() {
        String res = getStringOrNull(PokColumns.IMAGE);
        return res;
    }
}
