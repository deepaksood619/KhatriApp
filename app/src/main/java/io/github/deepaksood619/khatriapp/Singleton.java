package io.github.deepaksood619.khatriapp;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by deepak on 02/02/18.
 */

public class Singleton {

    private static Singleton instance;

    private AppDatabase db;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return  instance;
    }

    public void init(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, "user_database").build();
    }

    public AppDatabase getDb() {
        if (db == null)
            throw new NullPointerException("Call init first");

        return db;
    }

}
