package com.rezkyatinnov.skyalite;

import android.content.Context;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.Set;

public class SKyaLite {
    private static final SKyaLite ourInstance = new SKyaLite();

    private String mDbName = "skyalite";
    private Context mContext;
    private int mDbVersion = 1;
    protected String CREATE_TABLE = "";
    protected String DROP_ALL = "";

    public static SKyaLite getInstance() {
        return ourInstance;
    }

    private SKyaLite() {
    }

    public void init(Context context, String dbName, int dbVersion){
        mContext = context;
        mDbName = dbName;
        mDbVersion = dbVersion;
        setupDb(context.getPackageName());
    }

    private void setupDb(String packageName){
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(TableName.class);
    }

    public String getDbName() {
        return mDbName;
    }

    public void setDbName(String dbName) {
        mDbName = dbName;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    public int getDbVersion() {
        return mDbVersion;
    }

    public void setDbVersion(int mDbVersion) {
        this.mDbVersion = mDbVersion;
    }
}
