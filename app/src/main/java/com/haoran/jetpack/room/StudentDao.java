package com.haoran.jetpack.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
     @Query("SELECT * FROM Student")
     List<Student> getAll();

     @Query("SELECT * FROM Student WHERE st_uid IN (:userIds)")
     List<Student> loadAllByIds(int[] userIds);

     @Query("SELECT * FROM Student WHERE st_name LIKE :first ")
     Student findByName(String first);

     @Insert
     void insertAll(Student... students);

     @Insert
     void insert(Student student);

     @Delete
      void delete(Student student);

     @Update
      void update(Student student);
}
