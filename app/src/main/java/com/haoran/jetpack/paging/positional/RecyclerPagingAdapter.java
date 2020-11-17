package com.haoran.jetpack.paging.positional;

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

/**
 * <li>Package: com.haoran.jetpack.paging</li>
 * <li>Author: haoran.li</li>
 * <li>Date:  2020/11/16</li>
 * <li>Description: </li>
 */
public class RecyclerPagingAdapter extends PagedListAdapter<Student, RecyclerPagingAdapter.MyRecyclerViewHolder> {

    // TODO 比较的行为
    private static DiffUtil.ItemCallback<Student> DIFF_STUDNET = new
            DiffUtil.ItemCallback<Student>() {

                // 一般是比较 唯一性的内容， ID
                @Override
                public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                    return oldItem.id.equals(newItem.id);
                }

                // 对象本身的比较
                @Override
                public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                    return oldItem.equals(newItem);
                }
            };

    public RecyclerPagingAdapter() {
        super(DIFF_STUDNET);
    }

    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {
        Student student = getItem(position);
        // item view 出来了， 分页库还在加载数据中，我就显示 Id加载中
        if (null == student) {
            holder.tvId.setText("Id加载中...");
            holder.tvName.setText("Name加载中...");
            holder.tvSex.setText("Sex加载中...");
        } else {
            holder.tvId.setText(student.id);
            holder.tvName.setText(student.name);
            holder.tvSex.setText(student.sex);
        }

    }

    // Item 优化的 ViewHolder
    public static class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvName;
        TextView tvSex;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id); // ID
            tvName = itemView.findViewById(R.id.tv_name); // 名称
            tvSex = itemView.findViewById(R.id.tv_sex); // 性别
        }

    }
}
