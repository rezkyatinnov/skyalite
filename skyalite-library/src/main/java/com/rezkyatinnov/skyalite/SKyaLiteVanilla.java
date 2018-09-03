package com.rezkyatinnov.skyalite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

class SKyaLiteVanilla implements SKyaLitePort {
    @Override
    public <M> List<M> get(Context context, M object) {
        SQLiteDatabase db = SKyaLiteDBVanilla.getInstance(context).getReadableDatabase();
        String tableName = object.getClass().getAnnotation(TableName.class).value()
        Cursor cursor = db.query(true, tableName, new String[]{"data"}, null,
                null, null, null, null, null);

        List<M> model = ;
        if (cursor != null && cursor.moveToFirst()) {
            Gson gson = new Gson();
            model = gson.fromJson(cursor.getString(cursor.getColumnIndex("data")), object.getClass());
        }
        cursor.close();
        return model;
    }

    @Override
    public <M> boolean save(Context context, M model) {
        return false;
    }

    @Override
    public <M> boolean update(Context context, M model) {
        return false;
    }

    @Override
    public void deleteAll(Context context) {

    }

    @Override
    public <M> boolean delete(Context context, M model) {
        return false;
    }
}
