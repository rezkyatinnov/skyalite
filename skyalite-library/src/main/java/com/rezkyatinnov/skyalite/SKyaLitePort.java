package com.rezkyatinnov.skyalite;

import android.content.Context;

import java.util.List;

interface SKyaLitePort {
    <M> List<M> get(Context context, M model);

    <M> boolean save(Context context, M model);

    <M> boolean update(Context context, M model);

    void deleteAll(Context context);

    <M> boolean delete(Context context, M model);
}
