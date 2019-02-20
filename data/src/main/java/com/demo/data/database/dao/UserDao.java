package com.demo.data.database.dao;

import com.demo.data.database.entities.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void insertAll(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user WHERE cardNo=:cardNo AND password=:password")
    List<User> getUser(String cardNo, String password);

}
