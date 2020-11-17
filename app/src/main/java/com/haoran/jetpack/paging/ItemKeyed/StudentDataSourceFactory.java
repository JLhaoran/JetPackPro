package com.haoran.jetpack.paging.ItemKeyed;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.haoran.jetpack.paging.Student;

/**
 * <li>Package: com.haoran.jetpack.paging.ItemKeyed</li>
 * <li>Author: haoran.li</li>
 * <li>Date:  2020/11/16</li>
 * <li>Description: </li>
 */
public class StudentDataSourceFactory extends DataSource.Factory<Integer, Student>{
    @NonNull
    @Override
    public DataSource<Integer, Student> create() {

        return new CustomItemDataSource(new DataRepository());
    }
}
