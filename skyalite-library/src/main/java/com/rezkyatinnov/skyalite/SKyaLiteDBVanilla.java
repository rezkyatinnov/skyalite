package com.rezkyatinnov.skyalite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class SKyaLiteDBVanilla extends SQLiteOpenHelper {

    private static SKyaLiteDBVanilla instance = null;

    private SKyaLiteDBVanilla(Context context) {
        super(context, SKyaLite.getInstance().getDbName(), null, SKyaLite.getInstance().getDbVersion());
    }

    public static SKyaLiteDBVanilla getInstance(Context context) {
        if (instance == null) {
            synchronized (SKyaLiteDBVanilla.class) {
                if (instance == null) {
                    instance = new SKyaLiteDBVanilla(context);
                }
            }
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        for(String createTable : SKyaLite.getInstance().mCreateTableList) {
            database.execSQL(createTable);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(SKyaLiteDBVanilla.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");

        db.execSQL(SKyaLite.getInstance().DROP_ALL);
        onCreate(db);
    }
    public SKyaLiteDBVanilla(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SKyaLiteDBVanilla(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }
}
