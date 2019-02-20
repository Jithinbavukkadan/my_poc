package com.demo.data.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public int cardNo;

    @ColumnInfo(name = "nick_name")
    public String nickName;

    @ColumnInfo(name = "mobno")
    public String mobNo;

    @ColumnInfo(name = "password")
    public String password;

}
