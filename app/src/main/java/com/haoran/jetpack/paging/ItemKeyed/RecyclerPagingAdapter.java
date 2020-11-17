package com.haoran.jetpack.paging.ItemKeyed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.haoran.jetpack.R;
import com.haoran.jetpack.paging.Student;

public class RecyclerPagingAdapter extends PagedListAdapter<Student, RecyclerPagingAdapter.MyRecyclerViewHolder> {
    //需要oldStudent与新 newStudent 比较才能得出变化的数据
    private static DiffUtil.ItemCallback<Student> DIFF_STUDENT =
            new DiffUtil.ItemCallback<Student>() {
                // 判断Item是否已经存在
                @Override
                public boolean areItemsTheSame(Student oldStudent, Student newStudent) {
                    return oldStudent.id.equals(newStudent.id);
                }
                // 如果Item已经存在则会调用此方法，判断Item的内容是否一致
                @Override
                public boolean areContentsTheSame(Student oldStudent, Student newStudent) {
                    return oldStudent.equals(newStudent);
                }
            };

    protected RecyclerPagingAdapter() {
        super(DIFF_STUDENT);
    }

    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {
        Student Student = getItem(position);
        if (null == Student) {
            holder.tvId.setText("Id加载中");
            holder.tvName.setText("Name加载中");
            holder.tvSex.setText("Sex加载中");
        } else if (null != Student) {
            holder.tvId.setText(Student.id);
            holder.tvName.setText(Student.name);
            holder.tvSex.setText(Student.sex);

        }
    }

    public static class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvName;
        TextView tvSex;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSex = itemView.findViewById(R.id.tv_sex);
        }
    }

}
