package com.example.tomecabello.myapplication.provider.pok;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.tomecabello.myapplication.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code pok} table.
 */
public class PokContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PokColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PokSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PokSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PokContentValues putPkdxId(@Nullable Integer value) {
        mContentValues.put(PokColumns.PKDX_ID, value);
        return this;
    }

    public PokContentValues putPkdxIdNull() {
        mContentValues.putNull(PokColumns.PKDX_ID);
        return this;
    }

    public PokContentValues putName(@Nullable String value) {
        mContentValues.put(PokColumns.NAME, value);
        return this;
    }

    public PokContentValues putNameNull() {
        mContentValues.putNull(PokColumns.NAME);
        return this;
    }

    public PokContentValues putCatchRate(@Nullable Integer value) {
        mContentValues.put(PokColumns.CATCH_RATE, value);
        return this;
    }

    public PokContentValues putCatchRateNull() {
        mContentValues.putNull(PokColumns.CATCH_RATE);
        return this;
    }

    public PokContentValues putAttack(@Nullable Integer value) {
        mContentValues.put(PokColumns.ATTACK, value);
        return this;
    }

    public PokContentValues putAttackNull() {
        mContentValues.putNull(PokColumns.ATTACK);
        return this;
    }

    public PokContentValues putDefense(@Nullable Integer value) {
        mContentValues.put(PokColumns.DEFENSE, value);
        return this;
    }

    public PokContentValues putDefenseNull() {
        mContentValues.putNull(PokColumns.DEFENSE);
        return this;
    }

    public PokContentValues putSpatk(@Nullable Integer value) {
        mContentValues.put(PokColumns.SPATK, value);
        return this;
    }

    public PokContentValues putSpatkNull() {
        mContentValues.putNull(PokColumns.SPATK);
        return this;
    }

    public PokContentValues putSpdef(@Nullable Integer value) {
        mContentValues.put(PokColumns.SPDEF, value);
        return this;
    }

    public PokContentValues putSpdefNull() {
        mContentValues.putNull(PokColumns.SPDEF);
        return this;
    }

    public PokContentValues putWeight(@Nullable Integer value) {
        mContentValues.put(PokColumns.WEIGHT, value);
        return this;
    }

    public PokContentValues putWeightNull() {
        mContentValues.putNull(PokColumns.WEIGHT);
        return this;
    }

    public PokContentValues putSpeed(@Nullable Integer value) {
        mContentValues.put(PokColumns.SPEED, value);
        return this;
    }

    public PokContentValues putSpeedNull() {
        mContentValues.putNull(PokColumns.SPEED);
        return this;
    }

    public PokContentValues putHp(@Nullable Integer value) {
        mContentValues.put(PokColumns.HP, value);
        return this;
    }

    public PokContentValues putHpNull() {
        mContentValues.putNull(PokColumns.HP);
        return this;
    }

    public PokContentValues putSynctime(@Nullable String value) {
        mContentValues.put(PokColumns.SYNCTIME, value);
        return this;
    }

    public PokContentValues putSynctimeNull() {
        mContentValues.putNull(PokColumns.SYNCTIME);
        return this;
    }

    public PokContentValues putTypes(@Nullable String value) {
        mContentValues.put(PokColumns.TYPES, value);
        return this;
    }

    public PokContentValues putTypesNull() {
        mContentValues.putNull(PokColumns.TYPES);
        return this;
    }

    public PokContentValues putImage(@Nullable String value) {
        mContentValues.put(PokColumns.IMAGE, value);
        return this;
    }

    public PokContentValues putImageNull() {
        mContentValues.putNull(PokColumns.IMAGE);
        return this;
    }
}
