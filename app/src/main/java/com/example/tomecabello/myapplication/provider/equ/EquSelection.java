package com.example.tomecabello.myapplication.provider.equ;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.tomecabello.myapplication.provider.base.AbstractSelection;

/**
 * Selection for the {@code equ} table.
 */
public class EquSelection extends AbstractSelection<EquSelection> {
    @Override
    protected Uri baseUri() {
        return EquColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code EquCursor} object, which is positioned before the first entry, or null.
     */
    public EquCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new EquCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public EquCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code EquCursor} object, which is positioned before the first entry, or null.
     */
    public EquCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new EquCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public EquCursor query(Context context) {
        return query(context, null);
    }


    public EquSelection id(long... value) {
        addEquals("equ." + EquColumns._ID, toObjectArray(value));
        return this;
    }

    public EquSelection idNot(long... value) {
        addNotEquals("equ." + EquColumns._ID, toObjectArray(value));
        return this;
    }

    public EquSelection orderById(boolean desc) {
        orderBy("equ." + EquColumns._ID, desc);
        return this;
    }

    public EquSelection orderById() {
        return orderById(false);
    }

    public EquSelection pkdxId(Integer... value) {
        addEquals(EquColumns.PKDX_ID, value);
        return this;
    }

    public EquSelection pkdxIdNot(Integer... value) {
        addNotEquals(EquColumns.PKDX_ID, value);
        return this;
    }

    public EquSelection pkdxIdGt(int value) {
        addGreaterThan(EquColumns.PKDX_ID, value);
        return this;
    }

    public EquSelection pkdxIdGtEq(int value) {
        addGreaterThanOrEquals(EquColumns.PKDX_ID, value);
        return this;
    }

    public EquSelection pkdxIdLt(int value) {
        addLessThan(EquColumns.PKDX_ID, value);
        return this;
    }

    public EquSelection pkdxIdLtEq(int value) {
        addLessThanOrEquals(EquColumns.PKDX_ID, value);
        return this;
    }

    public EquSelection orderByPkdxId(boolean desc) {
        orderBy(EquColumns.PKDX_ID, desc);
        return this;
    }

    public EquSelection orderByPkdxId() {
        orderBy(EquColumns.PKDX_ID, false);
        return this;
    }

    public EquSelection name(String... value) {
        addEquals(EquColumns.NAME, value);
        return this;
    }

    public EquSelection nameNot(String... value) {
        addNotEquals(EquColumns.NAME, value);
        return this;
    }

    public EquSelection nameLike(String... value) {
        addLike(EquColumns.NAME, value);
        return this;
    }

    public EquSelection nameContains(String... value) {
        addContains(EquColumns.NAME, value);
        return this;
    }

    public EquSelection nameStartsWith(String... value) {
        addStartsWith(EquColumns.NAME, value);
        return this;
    }

    public EquSelection nameEndsWith(String... value) {
        addEndsWith(EquColumns.NAME, value);
        return this;
    }

    public EquSelection orderByName(boolean desc) {
        orderBy(EquColumns.NAME, desc);
        return this;
    }

    public EquSelection orderByName() {
        orderBy(EquColumns.NAME, false);
        return this;
    }

    public EquSelection catchRate(Integer... value) {
        addEquals(EquColumns.CATCH_RATE, value);
        return this;
    }

    public EquSelection catchRateNot(Integer... value) {
        addNotEquals(EquColumns.CATCH_RATE, value);
        return this;
    }

    public EquSelection catchRateGt(int value) {
        addGreaterThan(EquColumns.CATCH_RATE, value);
        return this;
    }

    public EquSelection catchRateGtEq(int value) {
        addGreaterThanOrEquals(EquColumns.CATCH_RATE, value);
        return this;
    }

    public EquSelection catchRateLt(int value) {
        addLessThan(EquColumns.CATCH_RATE, value);
        return this;
    }

    public EquSelection catchRateLtEq(int value) {
        addLessThanOrEquals(EquColumns.CATCH_RATE, value);
        return this;
    }

    public EquSelection orderByCatchRate(boolean desc) {
        orderBy(EquColumns.CATCH_RATE, desc);
        return this;
    }

    public EquSelection orderByCatchRate() {
        orderBy(EquColumns.CATCH_RATE, false);
        return this;
    }

    public EquSelection attack(Integer... value) {
        addEquals(EquColumns.ATTACK, value);
        return this;
    }

    public EquSelection attackNot(Integer... value) {
        addNotEquals(EquColumns.ATTACK, value);
        return this;
    }

    public EquSelection attackGt(int value) {
        addGreaterThan(EquColumns.ATTACK, value);
        return this;
    }

    public EquSelection attackGtEq(int value) {
        addGreaterThanOrEquals(EquColumns.ATTACK, value);
        return this;
    }

    public EquSelection attackLt(int value) {
        addLessThan(EquColumns.ATTACK, value);
        return this;
    }

    public EquSelection attackLtEq(int value) {
        addLessThanOrEquals(EquColumns.ATTACK, value);
        return this;
    }

    public EquSelection orderByAttack(boolean desc) {
        orderBy(EquColumns.ATTACK, desc);
        return this;
    }

    public EquSelection orderByAttack() {
        orderBy(EquColumns.ATTACK, false);
        return this;
    }

    public EquSelection defense(Integer... value) {
        addEquals(EquColumns.DEFENSE, value);
        return this;
    }

    public EquSelection defenseNot(Integer... value) {
        addNotEquals(EquColumns.DEFENSE, value);
        return this;
    }

    public EquSelection defenseGt(int value) {
        addGreaterThan(EquColumns.DEFENSE, value);
        return this;
    }

    public EquSelection defenseGtEq(int value) {
        addGreaterThanOrEquals(EquColumns.DEFENSE, value);
        return this;
    }

    public EquSelection defenseLt(int value) {
        addLessThan(EquColumns.DEFENSE, value);
        return this;
    }

    public EquSelection defenseLtEq(int value) {
        addLessThanOrEquals(EquColumns.DEFENSE, value);
        return this;
    }

    public EquSelection orderByDefense(boolean desc) {
        orderBy(EquColumns.DEFENSE, desc);
        return this;
    }

    public EquSelection orderByDefense() {
        orderBy(EquColumns.DEFENSE, false);
        return this;
    }

    public EquSelection spatk(Integer... value) {
        addEquals(EquColumns.SPATK, value);
        return this;
    }

    public EquSelection spatkNot(Integer... value) {
        addNotEquals(EquColumns.SPATK, value);
        return this;
    }

    public EquSelection spatkGt(int value) {
        addGreaterThan(EquColumns.SPATK, value);
        return this;
    }

    public EquSelection spatkGtEq(int value) {
        addGreaterThanOrEquals(EquColumns.SPATK, value);
        return this;
    }

    public EquSelection spatkLt(int value) {
        addLessThan(EquColumns.SPATK, value);
        return this;
    }

    public EquSelection spatkLtEq(int value) {
        addLessThanOrEquals(EquColumns.SPATK, value);
        return this;
    }

    public EquSelection orderBySpatk(boolean desc) {
        orderBy(EquColumns.SPATK, desc);
        return this;
    }

    public EquSelection orderBySpatk() {
        orderBy(EquColumns.SPATK, false);
        return this;
    }

    public EquSelection spdef(Integer... value) {
        addEquals(EquColumns.SPDEF, value);
        return this;
    }

    public EquSelection spdefNot(Integer... value) {
        addNotEquals(EquColumns.SPDEF, value);
        return this;
    }

    public EquSelection spdefGt(int value) {
        addGreaterThan(EquColumns.SPDEF, value);
        return this;
    }

    public EquSelection spdefGtEq(int value) {
        addGreaterThanOrEquals(EquColumns.SPDEF, value);
        return this;
    }

    public EquSelection spdefLt(int value) {
        addLessThan(EquColumns.SPDEF, value);
        return this;
    }

    public EquSelection spdefLtEq(int value) {
        addLessThanOrEquals(EquColumns.SPDEF, value);
        return this;
    }

    public EquSelection orderBySpdef(boolean desc) {
        orderBy(EquColumns.SPDEF, desc);
        return this;
    }

    public EquSelection orderBySpdef() {
        orderBy(EquColumns.SPDEF, false);
        return this;
    }

    public EquSelection weight(Integer... value) {
        addEquals(EquColumns.WEIGHT, value);
        return this;
    }

    public EquSelection weightNot(Integer... value) {
        addNotEquals(EquColumns.WEIGHT, value);
        return this;
    }

    public EquSelection weightGt(int value) {
        addGreaterThan(EquColumns.WEIGHT, value);
        return this;
    }

    public EquSelection weightGtEq(int value) {
        addGreaterThanOrEquals(EquColumns.WEIGHT, value);
        return this;
    }

    public EquSelection weightLt(int value) {
        addLessThan(EquColumns.WEIGHT, value);
        return this;
    }

    public EquSelection weightLtEq(int value) {
        addLessThanOrEquals(EquColumns.WEIGHT, value);
        return this;
    }

    public EquSelection orderByWeight(boolean desc) {
        orderBy(EquColumns.WEIGHT, desc);
        return this;
    }

    public EquSelection orderByWeight() {
        orderBy(EquColumns.WEIGHT, false);
        return this;
    }

    public EquSelection speed(Integer... value) {
        addEquals(EquColumns.SPEED, value);
        return this;
    }

    public EquSelection speedNot(Integer... value) {
        addNotEquals(EquColumns.SPEED, value);
        return this;
    }

    public EquSelection speedGt(int value) {
        addGreaterThan(EquColumns.SPEED, value);
        return this;
    }

    public EquSelection speedGtEq(int value) {
        addGreaterThanOrEquals(EquColumns.SPEED, value);
        return this;
    }

    public EquSelection speedLt(int value) {
        addLessThan(EquColumns.SPEED, value);
        return this;
    }

    public EquSelection speedLtEq(int value) {
        addLessThanOrEquals(EquColumns.SPEED, value);
        return this;
    }

    public EquSelection orderBySpeed(boolean desc) {
        orderBy(EquColumns.SPEED, desc);
        return this;
    }

    public EquSelection orderBySpeed() {
        orderBy(EquColumns.SPEED, false);
        return this;
    }

    public EquSelection hp(Integer... value) {
        addEquals(EquColumns.HP, value);
        return this;
    }

    public EquSelection hpNot(Integer... value) {
        addNotEquals(EquColumns.HP, value);
        return this;
    }

    public EquSelection hpGt(int value) {
        addGreaterThan(EquColumns.HP, value);
        return this;
    }

    public EquSelection hpGtEq(int value) {
        addGreaterThanOrEquals(EquColumns.HP, value);
        return this;
    }

    public EquSelection hpLt(int value) {
        addLessThan(EquColumns.HP, value);
        return this;
    }

    public EquSelection hpLtEq(int value) {
        addLessThanOrEquals(EquColumns.HP, value);
        return this;
    }

    public EquSelection orderByHp(boolean desc) {
        orderBy(EquColumns.HP, desc);
        return this;
    }

    public EquSelection orderByHp() {
        orderBy(EquColumns.HP, false);
        return this;
    }

    public EquSelection synctime(String... value) {
        addEquals(EquColumns.SYNCTIME, value);
        return this;
    }

    public EquSelection synctimeNot(String... value) {
        addNotEquals(EquColumns.SYNCTIME, value);
        return this;
    }

    public EquSelection synctimeLike(String... value) {
        addLike(EquColumns.SYNCTIME, value);
        return this;
    }

    public EquSelection synctimeContains(String... value) {
        addContains(EquColumns.SYNCTIME, value);
        return this;
    }

    public EquSelection synctimeStartsWith(String... value) {
        addStartsWith(EquColumns.SYNCTIME, value);
        return this;
    }

    public EquSelection synctimeEndsWith(String... value) {
        addEndsWith(EquColumns.SYNCTIME, value);
        return this;
    }

    public EquSelection orderBySynctime(boolean desc) {
        orderBy(EquColumns.SYNCTIME, desc);
        return this;
    }

    public EquSelection orderBySynctime() {
        orderBy(EquColumns.SYNCTIME, false);
        return this;
    }

    public EquSelection estado(String... value) {
        addEquals(EquColumns.ESTADO, value);
        return this;
    }

    public EquSelection estadoNot(String... value) {
        addNotEquals(EquColumns.ESTADO, value);
        return this;
    }

    public EquSelection estadoLike(String... value) {
        addLike(EquColumns.ESTADO, value);
        return this;
    }

    public EquSelection estadoContains(String... value) {
        addContains(EquColumns.ESTADO, value);
        return this;
    }

    public EquSelection estadoStartsWith(String... value) {
        addStartsWith(EquColumns.ESTADO, value);
        return this;
    }

    public EquSelection estadoEndsWith(String... value) {
        addEndsWith(EquColumns.ESTADO, value);
        return this;
    }

    public EquSelection orderByEstado(boolean desc) {
        orderBy(EquColumns.ESTADO, desc);
        return this;
    }

    public EquSelection orderByEstado() {
        orderBy(EquColumns.ESTADO, false);
        return this;
    }

    public EquSelection types(String... value) {
        addEquals(EquColumns.TYPES, value);
        return this;
    }

    public EquSelection typesNot(String... value) {
        addNotEquals(EquColumns.TYPES, value);
        return this;
    }

    public EquSelection typesLike(String... value) {
        addLike(EquColumns.TYPES, value);
        return this;
    }

    public EquSelection typesContains(String... value) {
        addContains(EquColumns.TYPES, value);
        return this;
    }

    public EquSelection typesStartsWith(String... value) {
        addStartsWith(EquColumns.TYPES, value);
        return this;
    }

    public EquSelection typesEndsWith(String... value) {
        addEndsWith(EquColumns.TYPES, value);
        return this;
    }

    public EquSelection orderByTypes(boolean desc) {
        orderBy(EquColumns.TYPES, desc);
        return this;
    }

    public EquSelection orderByTypes() {
        orderBy(EquColumns.TYPES, false);
        return this;
    }

    public EquSelection image(String... value) {
        addEquals(EquColumns.IMAGE, value);
        return this;
    }

    public EquSelection imageNot(String... value) {
        addNotEquals(EquColumns.IMAGE, value);
        return this;
    }

    public EquSelection imageLike(String... value) {
        addLike(EquColumns.IMAGE, value);
        return this;
    }

    public EquSelection imageContains(String... value) {
        addContains(EquColumns.IMAGE, value);
        return this;
    }

    public EquSelection imageStartsWith(String... value) {
        addStartsWith(EquColumns.IMAGE, value);
        return this;
    }

    public EquSelection imageEndsWith(String... value) {
        addEndsWith(EquColumns.IMAGE, value);
        return this;
    }

    public EquSelection orderByImage(boolean desc) {
        orderBy(EquColumns.IMAGE, desc);
        return this;
    }

    public EquSelection orderByImage() {
        orderBy(EquColumns.IMAGE, false);
        return this;
    }
}
