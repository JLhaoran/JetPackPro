package com.haoran.jetpack.paging.positional;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.haoran.jetpack.paging.Student;

/**
 * <li>Package: com.haoran.jetpack.paging</li>
 * <li>Author: haoran.li</li>
 * <li>Date:  2020/11/16</li>
 * <li>Description: </li>
 */
public class StudentViewModel extends ViewModel {
    private final LiveData<PagedList<Student>> listLiveData;

    public StudentViewModel() {
        StudentDataSourceFactory factory = new StudentDataSourceFactory();

        this.listLiveData = new LivePagedListBuilder<Integer,Student>(factory,Flag.SIZE).build();
    }

    public LiveData<PagedList<Student>> getListLiveData() {
        return listLiveData;
    }

}
