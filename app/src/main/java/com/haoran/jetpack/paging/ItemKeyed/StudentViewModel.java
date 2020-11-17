package com.haoran.jetpack.paging.ItemKeyed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.haoran.jetpack.paging.Student;

public class StudentViewModel extends ViewModel {

    private final LiveData<PagedList<Student>> pagedListLiveData;

    public StudentViewModel() {
        // @1 Factory 的创建
        DataSource.Factory<Integer, Student> factory = new StudentDataSourceFactory();
        // @1 Factory
        pagedListLiveData = new LivePagedListBuilder<Integer, Student>(factory, ItemKeyedFlag.SIZE).build();
    }

    public LiveData<PagedList<Student>> getPagedListLiveData() {
        return pagedListLiveData;
    }
}
