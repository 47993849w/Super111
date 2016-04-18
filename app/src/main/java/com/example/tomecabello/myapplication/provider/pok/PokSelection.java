package com.example.tomecabello.myapplication.provider.pok;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.tomecabello.myapplication.provider.base.AbstractSelection;

/**
 * Selection for the {@code pok} table.
 */
public class PokSelection extends AbstractSelection<PokSelection> {
    @Override
    protected Uri baseUri() {
        return PokColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PokCursor} object, which is positioned before the first entry, or null.
     */
    public PokCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PokCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PokCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PokCursor} object, which is positioned before the first entry, or null.
     */
    public PokCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PokCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PokCursor query(Context context) {
        return query(context, null);
    }


    public PokSelection id(long... value) {
        addEquals("pok." + PokColumns._ID, toObjectArray(value));
        return this;
    }

    public PokSelection idNot(long... value) {
        addNotEquals("pok." + PokColumns._ID, toObjectArray(value));
        return this;
    }

    public PokSelection orderById(boolean desc) {
        orderBy("pok." + PokColumns._ID, desc);
        return this;
    }

    public PokSelection orderById() {
        return orderById(false);
    }

    public PokSelection pkdxId(Integer... value) {
        addEquals(PokColumns.PKDX_ID, value);
        return this;
    }

    public PokSelection pkdxIdNot(Integer... value) {
        addNotEquals(PokColumns.PKDX_ID, value);
        return this;
    }

    public PokSelection pkdxIdGt(int value) {
        addGreaterThan(PokColumns.PKDX_ID, value);
        return this;
    }

    public PokSelection pkdxIdGtEq(int value) {
        addGreaterThanOrEquals(PokColumns.PKDX_ID, value);
        return this;
    }

    public PokSelection pkdxIdLt(int value) {
        addLessThan(PokColumns.PKDX_ID, value);
        return this;
    }

    public PokSelection pkdxIdLtEq(int value) {
        addLessThanOrEquals(PokColumns.PKDX_ID, value);
        return this;
    }

    public PokSelection orderByPkdxId(boolean desc) {
        orderBy(PokColumns.PKDX_ID, desc);
        return this;
    }

    public PokSelection orderByPkdxId() {
        orderBy(PokColumns.PKDX_ID, false);
        return this;
    }

    public PokSelection name(String... value) {
        addEquals(PokColumns.NAME, value);
        return this;
    }

    public PokSelection nameNot(String... value) {
        addNotEquals(PokColumns.NAME, value);
        return this;
    }

    public PokSelection nameLike(String... value) {
        addLike(PokColumns.NAME, value);
        return this;
    }

    public PokSelection nameContains(String... value) {
        addContains(PokColumns.NAME, value);
        return this;
    }

    public PokSelection nameStartsWith(String... value) {
        addStartsWith(PokColumns.NAME, value);
        return this;
    }

    public PokSelection nameEndsWith(String... value) {
        addEndsWith(PokColumns.NAME, value);
        return this;
    }

    public PokSelection orderByName(boolean desc) {
        orderBy(PokColumns.NAME, desc);
        return this;
    }

    public PokSelection orderByName() {
        orderBy(PokColumns.NAME, false);
        return this;
    }

    public PokSelection catchRate(Integer... value) {
        addEquals(PokColumns.CATCH_RATE, value);
        return this;
    }

    public PokSelection catchRateNot(Integer... value) {
        addNotEquals(PokColumns.CATCH_RATE, value);
        return this;
    }

    public PokSelection catchRateGt(int value) {
        addGreaterThan(PokColumns.CATCH_RATE, value);
        return this;
    }

    public PokSelection catchRateGtEq(int value) {
        addGreaterThanOrEquals(PokColumns.CATCH_RATE, value);
        return this;
    }

    public PokSelection catchRateLt(int value) {
        addLessThan(PokColumns.CATCH_RATE, value);
        return this;
    }

    public PokSelection catchRateLtEq(int value) {
        addLessThanOrEquals(PokColumns.CATCH_RATE, value);
        return this;
    }

    public PokSelection orderByCatchRate(boolean desc) {
        orderBy(PokColumns.CATCH_RATE, desc);
        return this;
    }

    public PokSelection orderByCatchRate() {
        orderBy(PokColumns.CATCH_RATE, false);
        return this;
    }

    public PokSelection attack(Integer... value) {
        addEquals(PokColumns.ATTACK, value);
        return this;
    }

    public PokSelection attackNot(Integer... value) {
        addNotEquals(PokColumns.ATTACK, value);
        return this;
    }

    public PokSelection attackGt(int value) {
        addGreaterThan(PokColumns.ATTACK, value);
        return this;
    }

    public PokSelection attackGtEq(int value) {
        addGreaterThanOrEquals(PokColumns.ATTACK, value);
        return this;
    }

    public PokSelection attackLt(int value) {
        addLessThan(PokColumns.ATTACK, value);
        return this;
    }

    public PokSelection attackLtEq(int value) {
        addLessThanOrEquals(PokColumns.ATTACK, value);
        return this;
    }

    public PokSelection orderByAttack(boolean desc) {
        orderBy(PokColumns.ATTACK, desc);
        return this;
    }

    public PokSelection orderByAttack() {
        orderBy(PokColumns.ATTACK, false);
        return this;
    }

    public PokSelection defense(Integer... value) {
        addEquals(PokColumns.DEFENSE, value);
        return this;
    }

    public PokSelection defenseNot(Integer... value) {
        addNotEquals(PokColumns.DEFENSE, value);
        return this;
    }

    public PokSelection defenseGt(int value) {
        addGreaterThan(PokColumns.DEFENSE, value);
        return this;
    }

    public PokSelection defenseGtEq(int value) {
        addGreaterThanOrEquals(PokColumns.DEFENSE, value);
        return this;
    }

    public PokSelection defenseLt(int value) {
        addLessThan(PokColumns.DEFENSE, value);
        return this;
    }

    public PokSelection defenseLtEq(int value) {
        addLessThanOrEquals(PokColumns.DEFENSE, value);
        return this;
    }

    public PokSelection orderByDefense(boolean desc) {
        orderBy(PokColumns.DEFENSE, desc);
        return this;
    }

    public PokSelection orderByDefense() {
        orderBy(PokColumns.DEFENSE, false);
        return this;
    }

    public PokSelection spatk(Integer... value) {
        addEquals(PokColumns.SPATK, value);
        return this;
    }

    public PokSelection spatkNot(Integer... value) {
        addNotEquals(PokColumns.SPATK, value);
        return this;
    }

    public PokSelection spatkGt(int value) {
        addGreaterThan(PokColumns.SPATK, value);
        return this;
    }

    public PokSelection spatkGtEq(int value) {
        addGreaterThanOrEquals(PokColumns.SPATK, value);
        return this;
    }

    public PokSelection spatkLt(int value) {
        addLessThan(PokColumns.SPATK, value);
        return this;
    }

    public PokSelection spatkLtEq(int value) {
        addLessThanOrEquals(PokColumns.SPATK, value);
        return this;
    }

    public PokSelection orderBySpatk(boolean desc) {
        orderBy(PokColumns.SPATK, desc);
        return this;
    }

    public PokSelection orderBySpatk() {
        orderBy(PokColumns.SPATK, false);
        return this;
    }

    public PokSelection spdef(Integer... value) {
        addEquals(PokColumns.SPDEF, value);
        return this;
    }

    public PokSelection spdefNot(Integer... value) {
        addNotEquals(PokColumns.SPDEF, value);
        return this;
    }

    public PokSelection spdefGt(int value) {
        addGreaterThan(PokColumns.SPDEF, value);
        return this;
    }

    public PokSelection spdefGtEq(int value) {
        addGreaterThanOrEquals(PokColumns.SPDEF, value);
        return this;
    }

    public PokSelection spdefLt(int value) {
        addLessThan(PokColumns.SPDEF, value);
        return this;
    }

    public PokSelection spdefLtEq(int value) {
        addLessThanOrEquals(PokColumns.SPDEF, value);
        return this;
    }

    public PokSelection orderBySpdef(boolean desc) {
        orderBy(PokColumns.SPDEF, desc);
        return this;
    }

    public PokSelection orderBySpdef() {
        orderBy(PokColumns.SPDEF, false);
        return this;
    }

    public PokSelection weight(Integer... value) {
        addEquals(PokColumns.WEIGHT, value);
        return this;
    }

    public PokSelection weightNot(Integer... value) {
        addNotEquals(PokColumns.WEIGHT, value);
        return this;
    }

    public PokSelection weightGt(int value) {
        addGreaterThan(PokColumns.WEIGHT, value);
        return this;
    }

    public PokSelection weightGtEq(int value) {
        addGreaterThanOrEquals(PokColumns.WEIGHT, value);
        return this;
    }

    public PokSelection weightLt(int value) {
        addLessThan(PokColumns.WEIGHT, value);
        return this;
    }

    public PokSelection weightLtEq(int value) {
        addLessThanOrEquals(PokColumns.WEIGHT, value);
        return this;
    }

    public PokSelection orderByWeight(boolean desc) {
        orderBy(PokColumns.WEIGHT, desc);
        return this;
    }

    public PokSelection orderByWeight() {
        orderBy(PokColumns.WEIGHT, false);
        return this;
    }

    public PokSelection speed(Integer... value) {
        addEquals(PokColumns.SPEED, value);
        return this;
    }

    public PokSelection speedNot(Integer... value) {
        addNotEquals(PokColumns.SPEED, value);
        return this;
    }

    public PokSelection speedGt(int value) {
        addGreaterThan(PokColumns.SPEED, value);
        return this;
    }

    public PokSelection speedGtEq(int value) {
        addGreaterThanOrEquals(PokColumns.SPEED, value);
        return this;
    }

    public PokSelection speedLt(int value) {
        addLessThan(PokColumns.SPEED, value);
        return this;
    }

    public PokSelection speedLtEq(int value) {
        addLessThanOrEquals(PokColumns.SPEED, value);
        return this;
    }

    public PokSelection orderBySpeed(boolean desc) {
        orderBy(PokColumns.SPEED, desc);
        return this;
    }

    public PokSelection orderBySpeed() {
        orderBy(PokColumns.SPEED, false);
        return this;
    }

    public PokSelection hp(Integer... value) {
        addEquals(PokColumns.HP, value);
        return this;
    }

    public PokSelection hpNot(Integer... value) {
        addNotEquals(PokColumns.HP, value);
        return this;
    }

    public PokSelection hpGt(int value) {
        addGreaterThan(PokColumns.HP, value);
        return this;
    }

    public PokSelection hpGtEq(int value) {
        addGreaterThanOrEquals(PokColumns.HP, value);
        return this;
    }

    public PokSelection hpLt(int value) {
        addLessThan(PokColumns.HP, value);
        return this;
    }

    public PokSelection hpLtEq(int value) {
        addLessThanOrEquals(PokColumns.HP, value);
        return this;
    }

    public PokSelection orderByHp(boolean desc) {
        orderBy(PokColumns.HP, desc);
        return this;
    }

    public PokSelection orderByHp() {
        orderBy(PokColumns.HP, false);
        return this;
    }

    public PokSelection synctime(String... value) {
        addEquals(PokColumns.SYNCTIME, value);
        return this;
    }

    public PokSelection synctimeNot(String... value) {
        addNotEquals(PokColumns.SYNCTIME, value);
        return this;
    }

    public PokSelection synctimeLike(String... value) {
        addLike(PokColumns.SYNCTIME, value);
        return this;
    }

    public PokSelection synctimeContains(String... value) {
        addContains(PokColumns.SYNCTIME, value);
        return this;
    }

    public PokSelection synctimeStartsWith(String... value) {
        addStartsWith(PokColumns.SYNCTIME, value);
        return this;
    }

    public PokSelection synctimeEndsWith(String... value) {
        addEndsWith(PokColumns.SYNCTIME, value);
        return this;
    }

    public PokSelection orderBySynctime(boolean desc) {
        orderBy(PokColumns.SYNCTIME, desc);
        return this;
    }

    public PokSelection orderBySynctime() {
        orderBy(PokColumns.SYNCTIME, false);
        return this;
    }

    public PokSelection types(String... value) {
        addEquals(PokColumns.TYPES, value);
        return this;
    }

    public PokSelection typesNot(String... value) {
        addNotEquals(PokColumns.TYPES, value);
        return this;
    }

    public PokSelection typesLike(String... value) {
        addLike(PokColumns.TYPES, value);
        return this;
    }

    public PokSelection typesContains(String... value) {
        addContains(PokColumns.TYPES, value);
        return this;
    }

    public PokSelection typesStartsWith(String... value) {
        addStartsWith(PokColumns.TYPES, value);
        return this;
    }

    public PokSelection typesEndsWith(String... value) {
        addEndsWith(PokColumns.TYPES, value);
        return this;
    }

    public PokSelection orderByTypes(boolean desc) {
        orderBy(PokColumns.TYPES, desc);
        return this;
    }

    public PokSelection orderByTypes() {
        orderBy(PokColumns.TYPES, false);
        return this;
    }

    public PokSelection image(String... value) {
        addEquals(PokColumns.IMAGE, value);
        return this;
    }

    public PokSelection imageNot(String... value) {
        addNotEquals(PokColumns.IMAGE, value);
        return this;
    }

    public PokSelection imageLike(String... value) {
        addLike(PokColumns.IMAGE, value);
        return this;
    }

    public PokSelection imageContains(String... value) {
        addContains(PokColumns.IMAGE, value);
        return this;
    }

    public PokSelection imageStartsWith(String... value) {
        addStartsWith(PokColumns.IMAGE, value);
        return this;
    }

    public PokSelection imageEndsWith(String... value) {
        addEndsWith(PokColumns.IMAGE, value);
        return this;
    }

    public PokSelection orderByImage(boolean desc) {
        orderBy(PokColumns.IMAGE, desc);
        return this;
    }

    public PokSelection orderByImage() {
        orderBy(PokColumns.IMAGE, false);
        return this;
    }
}
