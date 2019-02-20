package com.demo.data.database;

import com.demo.data.database.dao.UserDao;
import com.demo.data.database.entities.User;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class LoyaltyDatabase extends RoomDatabase {
    public static LoyaltyDatabase getInstance(Context context) {
        return (LoyaltyDatabase) Room.databaseBuilder(context,
                LoyaltyDatabase.class, "loyalty_db").build();
    }

    public abstract UserDao userDao();
}
