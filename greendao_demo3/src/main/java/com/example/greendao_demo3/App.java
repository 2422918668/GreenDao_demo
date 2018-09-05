package com.example.greendao_demo3;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class App extends Application {

    private static App app;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        app = App.this;
        DaoMaster.DevOpenHelper studentTable = new DaoMaster.DevOpenHelper(this, "studentTable", null);
        SQLiteDatabase database = studentTable.getWritableDatabase();

        daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();

    }

    public static App getInstance() {
        if (null == app) {
            synchronized (App.class) {
                if (null == app) {
                    app = new App();
                }
            }
        }
        return app;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
