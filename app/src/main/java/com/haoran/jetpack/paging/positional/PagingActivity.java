package com.haoran.jetpack.paging.positional;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.haoran.jetpack.R;
import com.haoran.jetpack.paging.Student;

public class PagingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerPagingAdapter recyclerPagingAdapter;
    private StudentViewModel viewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);

        recyclerView = findViewById(R.id.paging_recycle_view);
        recyclerPagingAdapter = new RecyclerPagingAdapter();

        viewModel = new ViewModelProvider(PagingActivity.this,new ViewModelProvider.NewInstanceFactory())
                .get(StudentViewModel.class);

        // LiveData 观察者 感应更新
        viewModel.getListLiveData().observe(this, new Observer<PagedList<Student>>() {
            @Override
            public void onChanged(PagedList<Student> students) {
                // 再这里更新适配器数据
                recyclerPagingAdapter.submitList(students);
            }
        });

        recyclerView.setAdapter(recyclerPagingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}