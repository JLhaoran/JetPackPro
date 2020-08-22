package com.haoran.jetpack.lifecycle_mvp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.haoran.jetpack.R;
import com.haoran.jetpack.lifecycle_mvp.model.OrderListBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mac on 2018/6/7.
 */

public class DailyPagerAdapter extends RecyclerView.Adapter<DailyPagerAdapter.ViewHolder> implements View.OnClickListener {
    private List<OrderListBean.DataBean> mFruitList = new ArrayList<OrderListBean.DataBean>();
    Context context;
    OnItemClickListener mItemClickListener = null;

    public DailyPagerAdapter(Context context, List<OrderListBean.DataBean> fruitList) {
        mFruitList = fruitList;
        this.context = context;
    }
    public void setmItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_daily_goods, null);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(DailyPagerAdapter.ViewHolder holder, int position) {
        try {
            OrderListBean.DataBean fruit = mFruitList.get(position);
            Glide.with(context).load(fruit.getThumb()).into(holder.mMImageView);
            holder.tvName.setText(fruit.getTitle());
            holder.tvSummary.setText(fruit.getTime());

            if (null != fruit && !TextUtils.isEmpty(fruit.getPrice() + "")) {
                holder.tvPrice.setText("￥ " + fruit.getPrice());
            } else {
                holder.tvPrice.setText("￥ 0");
            }

        } catch (Exception e) {
        }


    }


    @Override
    public int getItemCount() {
        int count = 0;
        try {
            if (null != mFruitList) {
                count = mFruitList.size();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }


    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick((Integer) v.getTag());
        }


    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mMImageView;
        TextView tvName;
        TextView tvSummary;
        TextView tvPrice;

        TextView addBtn;
        TextView tvNum;
        TextView subBtn;
        View ly_base;


        public ViewHolder(View itemView) {
            super(itemView);
            mMImageView = (ImageView) itemView.findViewById(R.id.horizonItemImage_base);

            tvName = (TextView) itemView.findViewById(R.id.tvname_base);
            tvSummary = (TextView) itemView.findViewById(R.id.tv_summary);
            tvPrice = (TextView) itemView.findViewById(R.id.tvname_price);

            addBtn = (TextView) itemView.findViewById(R.id.img_price_add);
            subBtn = (TextView) itemView.findViewById(R.id.img_price_subtract);
            tvNum = (TextView) itemView.findViewById(R.id.tv_num_value);
            ly_base = (View) itemView.findViewById(R.id.rl_base);


        }
    }


}