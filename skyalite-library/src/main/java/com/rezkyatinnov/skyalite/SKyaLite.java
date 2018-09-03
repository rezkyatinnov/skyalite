package com.rezkyatinnov.skyalite;

import android.content.Context;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SKyaLite {
    private static final SKyaLite ourInstance = new SKyaLite();

    private String mDbName = "skyalite";
    private int mDbVersion = 1;
    private boolean mEncrypted = false;
    protected String CREATE_TABLE = "";
    protected String DROP_ALL = "";
    protected List<String> mTableList = new ArrayList<>();
    protected List<String> mCreateTableList = new ArrayList<>();
    private SKyaLitePort dbmObject;

    public static SKyaLite getInstance() {
        return ourInstance;
    }

    private SKyaLite() {
    }

    public void init(Context context, String dbName, int dbVersion, boolean encrypted){
        mDbName = dbName;
        mDbVersion = dbVersion;
        mEncrypted = encrypted;
        setupDb(context);
    }

    private void setupDb(Context context){
        Reflections reflections = new Reflections(context.getPackageName());
        Set<Class<?>> annotatedList = reflections.getTypesAnnotatedWith(TableName.class);
        for(Object annotated:annotatedList){
            mTableList.add(annotated.getClass().getAnnotation(TableName.class).value());
            mCreateTableList.add(getCreateTable(annotated.getClass().getAnnotation(TableName.class).value()));
        }

        if(mEncrypted){
            dbmObject = new SKyaLiteChiper();
        }else{
            dbmObject = new SKyaLiteVanilla();
        }

        dbmObject.get(context,new Object());
    }

    public String getDbName() {
        return mDbName;
    }

    public void setDbName(String dbName) {
        mDbName = dbName;
    }

    public int getDbVersion() {
        return mDbVersion;
    }

    public void setDbVersion(int mDbVersion) {
        this.mDbVersion = mDbVersion;
    }

    private String getCreateTable(String tableName){
            return "CREATE TABLE " + tableName + "(uuid TEXT, data BLOB, created_timestamp INTEGER, updated_timestamp INTEGER);";
    }
}
