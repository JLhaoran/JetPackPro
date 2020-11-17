package com.haoran.jetpack.paging.positional;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.haoran.jetpack.paging.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * <li>Package: com.haoran.jetpack.paging</li>
 * <li>Author: haoran.li</li>
 * <li>Date:  2020/11/16</li>
 * <li>Description: </li>
 */
public class StudentDataSource extends PositionalDataSource<Student> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Student> callback) {
        callback.onResult(loadData(0,Flag.SIZE),0,1000);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Student> callback) {
      callback.onResult(loadData(params.startPosition,params.loadSize));
    }


    private List<Student> loadData(int posion, int pageSize){
        List<Student> array = new ArrayList<>();
        for(int i= posion;i< posion + pageSize;i++){
            Student student = new Student();
            student.id = "id是"+i;
            student.name = "name是"+i;
            student.sex = "性别是"+i;
            array.add(student);
        }
        return array;
    }
}
