package com.haoran.jetpack.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.haoran.jetpack.R;
import com.haoran.jetpack.room.AppDatabase;
import com.haoran.jetpack.room.Student;
import com.haoran.jetpack.room.StudentDao;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        DBTest dbTest = new DBTest();
        dbTest.start();

    }

    public class DBTest extends Thread{
        @Override
        public void run() {
            AppDatabase stdb= Room.databaseBuilder(getApplicationContext()
                    ,AppDatabase.class
                    ,"stDB").build();
            StudentDao dao = stdb.userDao();
            dao.insert(new Student(1,"stu","123"));
            dao.insert(new Student(2,"stu1","123"));
            dao.insert(new Student(3,"stu2","123"));
            dao.insert(new Student(4,"stu3","123"));

            List<Student> list=dao.getAll();
            Log.i("room",list.toString());
        }
    }
}
