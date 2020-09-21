package com.haoran.jetpack.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1)
public abstract  class AppDatabase extends RoomDatabase {
    public abstract  StudentDao userDao();
}
