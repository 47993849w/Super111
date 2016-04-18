package com.example.tomecabello.myapplication.provider.equ;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.tomecabello.myapplication.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code equ} table.
 */
public class EquContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return EquColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable EquSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable EquSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public EquContentValues putPkdxId(@Nullable Integer value) {
        mContentValues.put(EquColumns.PKDX_ID, value);
        return this;
    }

    public EquContentValues putPkdxIdNull() {
        mContentValues.putNull(EquColumns.PKDX_ID);
        return this;
    }

    public EquContentValues putName(@Nullable String value) {
        mContentValues.put(EquColumns.NAME, value);
        return this;
    }

    public EquContentValues putNameNull() {
        mContentValues.putNull(EquColumns.NAME);
        return this;
    }

    public EquContentValues putCatchRate(@Nullable Integer value) {
        mContentValues.put(EquColumns.CATCH_RATE, value);
        return this;
    }

    public EquContentValues putCatchRateNull() {
        mContentValues.putNull(EquColumns.CATCH_RATE);
        return this;
    }

    public EquContentValues putAttack(@Nullable Integer value) {
        mContentValues.put(EquColumns.ATTACK, value);
        return this;
    }

    public EquContentValues putAttackNull() {
        mContentValues.putNull(EquColumns.ATTACK);
        return this;
    }

    public EquContentValues putDefense(@Nullable Integer value) {
        mContentValues.put(EquColumns.DEFENSE, value);
        return this;
    }

    public EquContentValues putDefenseNull() {
        mContentValues.putNull(EquColumns.DEFENSE);
        return this;
    }

    public EquContentValues putSpatk(@Nullable Integer value) {
        mContentValues.put(EquColumns.SPATK, value);
        return this;
    }

    public EquContentValues putSpatkNull() {
        mContentValues.putNull(EquColumns.SPATK);
        return this;
    }

    public EquContentValues putSpdef(@Nullable Integer value) {
        mContentValues.put(EquColumns.SPDEF, value);
        return this;
    }

    public EquContentValues putSpdefNull() {
        mContentValues.putNull(EquColumns.SPDEF);
        return this;
    }

    public EquContentValues putWeight(@Nullable Integer value) {
        mContentValues.put(EquColumns.WEIGHT, value);
        return this;
    }

    public EquContentValues putWeightNull() {
        mContentValues.putNull(EquColumns.WEIGHT);
        return this;
    }

    public EquContentValues putSpeed(@Nullable Integer value) {
        mContentValues.put(EquColumns.SPEED, value);
        return this;
    }

    public EquContentValues putSpeedNull() {
        mContentValues.putNull(EquColumns.SPEED);
        return this;
    }

    public EquContentValues putHp(@Nullable Integer value) {
        mContentValues.put(EquColumns.HP, value);
        return this;
    }

    public EquContentValues putHpNull() {
        mContentValues.putNull(EquColumns.HP);
        return this;
    }

    public EquContentValues putSynctime(@Nullable String value) {
        mContentValues.put(EquColumns.SYNCTIME, value);
        return this;
    }

    public EquContentValues putSynctimeNull() {
        mContentValues.putNull(EquColumns.SYNCTIME);
        return this;
    }

    public EquContentValues putEstado(@Nullable String value) {
        mContentValues.put(EquColumns.ESTADO, value);
        return this;
    }

    public EquContentValues putEstadoNull() {
        mContentValues.putNull(EquColumns.ESTADO);
        return this;
    }

    public EquContentValues putTypes(@Nullable String value) {
        mContentValues.put(EquColumns.TYPES, value);
        return this;
    }

    public EquContentValues putTypesNull() {
        mContentValues.putNull(EquColumns.TYPES);
        return this;
    }

    public EquContentValues putImage(@Nullable String value) {
        mContentValues.put(EquColumns.IMAGE, value);
        return this;
    }

    public EquContentValues putImageNull() {
        mContentValues.putNull(EquColumns.IMAGE);
        return this;
    }
}
