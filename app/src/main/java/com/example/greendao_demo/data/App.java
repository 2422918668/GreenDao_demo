package com.example.greendao_demo.data;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendao_demo.data.database.DaoMaster;
import com.example.greendao_demo.data.database.DaoSession;
import com.example.greendao_demo.data.database.UserDao;

public class App extends Application {

    private DaoSession daoSession;
    private DaoMaster daoMaster;
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();

        app = App.this;

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "baway", null);
        SQLiteDatabase db = helper.getWritableDatabase();

        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static App getInstance(){
        if (null == app){
            synchronized (App.class){
                if (null == app){
                    app = new App();
                }
            }
        }
        return app;
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}
