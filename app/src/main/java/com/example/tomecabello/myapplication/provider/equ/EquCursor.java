package com.example.tomecabello.myapplication.provider.equ;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.tomecabello.myapplication.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code equ} table.
 */
public class EquCursor extends AbstractCursor implements EquModel {
    public EquCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(EquColumns._ID);
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
        Integer res = getIntegerOrNull(EquColumns.PKDX_ID);
        return res;
    }

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(EquColumns.NAME);
        return res;
    }

    /**
     * Get the {@code catch_rate} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getCatchRate() {
        Integer res = getIntegerOrNull(EquColumns.CATCH_RATE);
        return res;
    }

    /**
     * Get the {@code attack} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getAttack() {
        Integer res = getIntegerOrNull(EquColumns.ATTACK);
        return res;
    }

    /**
     * Get the {@code defense} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getDefense() {
        Integer res = getIntegerOrNull(EquColumns.DEFENSE);
        return res;
    }

    /**
     * Get the {@code spatk} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getSpatk() {
        Integer res = getIntegerOrNull(EquColumns.SPATK);
        return res;
    }

    /**
     * Get the {@code spdef} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getSpdef() {
        Integer res = getIntegerOrNull(EquColumns.SPDEF);
        return res;
    }

    /**
     * Get the {@code weight} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getWeight() {
        Integer res = getIntegerOrNull(EquColumns.WEIGHT);
        return res;
    }

    /**
     * Get the {@code speed} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getSpeed() {
        Integer res = getIntegerOrNull(EquColumns.SPEED);
        return res;
    }

    /**
     * Get the {@code hp} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getHp() {
        Integer res = getIntegerOrNull(EquColumns.HP);
        return res;
    }

    /**
     * Get the {@code synctime} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSynctime() {
        String res = getStringOrNull(EquColumns.SYNCTIME);
        return res;
    }

    /**
     * Get the {@code estado} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getEstado() {
        String res = getStringOrNull(EquColumns.ESTADO);
        return res;
    }

    /**
     * Get the {@code types} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTypes() {
        String res = getStringOrNull(EquColumns.TYPES);
        return res;
    }

    /**
     * Get the {@code image} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getImage() {
        String res = getStringOrNull(EquColumns.IMAGE);
        return res;
    }
}
