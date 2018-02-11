package io.github.deepaksood619.khatriapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by deepak on 02/02/18.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE name = :itemname")
    User find(String itemname);

    @Insert
    void insertAll(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User user);
}