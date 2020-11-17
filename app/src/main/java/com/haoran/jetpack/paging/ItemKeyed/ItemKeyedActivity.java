package com.haoran.jetpack.paging.ItemKeyed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.haoran.jetpack.R;
import com.haoran.jetpack.paging.Student;

public class ItemKeyedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerPagingAdapter recyclerPagingAdapter;
    StudentViewModel personViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_keyed);

        recyclerView = findViewById(R.id.itemkeyed_recycle_view);
        recyclerPagingAdapter = new RecyclerPagingAdapter();

        personViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentViewModel.class);

        personViewModel.getPagedListLiveData().observe(this, new Observer<PagedList<Student>>() {
            @Override
            public void onChanged(PagedList<Student> persons) {
                recyclerPagingAdapter.submitList(persons);
            }
        });

        recyclerView.setAdapter(recyclerPagingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}