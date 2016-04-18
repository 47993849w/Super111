package com.example.tomecabello.myapplication.provider.pok;

import com.example.tomecabello.myapplication.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code pok} table.
 */
public interface PokModel extends BaseModel {

    /**
     * Get the {@code pkdx_id} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getPkdxId();

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Get the {@code catch_rate} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getCatchRate();

    /**
     * Get the {@code attack} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getAttack();

    /**
     * Get the {@code defense} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getDefense();

    /**
     * Get the {@code spatk} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getSpatk();

    /**
     * Get the {@code spdef} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getSpdef();

    /**
     * Get the {@code weight} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getWeight();

    /**
     * Get the {@code speed} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getSpeed();

    /**
     * Get the {@code hp} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getHp();

    /**
     * Get the {@code synctime} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSynctime();

    /**
     * Get the {@code types} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTypes();

    /**
     * Get the {@code image} value.
     * Can be {@code null}.
     */
    @Nullable
    String getImage();
}
