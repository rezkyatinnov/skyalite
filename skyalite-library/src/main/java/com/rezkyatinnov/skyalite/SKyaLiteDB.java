package com.rezkyatinnov.skyalite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SKyaLiteDB extends SQLiteOpenHelper {

    private static SKyaLiteDB instance = null;

    private SKyaLiteDB() {
        super(SKyaLite.getInstance().getContext(), SKyaLite.getInstance().getDbName(), null, SKyaLite.getInstance().getDbVersion());
    }

    // Lazy Initialization (If required then only)
    public static SKyaLiteDB getInstance() {
        if (instance == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (SKyaLiteDB.class) {
                if (instance == null) {
                    instance = new SKyaLiteDB();
                }
            }
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SKyaLite.getInstance().CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(SKyaLiteDB.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");

        db.execSQL(SKyaLite.getInstance().DROP_ALL);
        onCreate(db);
    }
    public SKyaLiteDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SKyaLiteDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }
}
