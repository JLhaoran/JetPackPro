package com.haoran.jetpack.paging.ItemKeyed;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import com.haoran.jetpack.paging.Student;
import java.util.List;

/**
 * <li>Package: com.haoran.jetpack.paging.ItemKeyed</li>
 * <li>Author: haoran.li</li>
 * <li>Date:  2020/11/16</li>
 * <li>Description:
 * ItemKeyedDataSource<Key, Value>：适用于目标数据的加载依赖特定item的信息，
 * 即Key字段包含的是Item中的信息，比如需要根据第N项的信息加载第N+1项的数据，传参中需要传入第N项的ID时，
 * 该场景多出现于论坛类应用评论信息的请求。
 * </li>
 */
public class CustomItemDataSource extends ItemKeyedDataSource<Integer, Student> {
    private DataRepository dataRepository;

    public CustomItemDataSource(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Student> callback) {
        List<Student> dataList = dataRepository.initData(params.requestedLoadSize);
        callback.onResult(dataList);
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Student> callback) {
        List<Student> dataList = dataRepository.loadPageData(params.key, params.requestedLoadSize);
        if (dataList != null) {
            callback.onResult(dataList);
        }
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Student> callback) {
        List<Student> dataList = dataRepository.loadPageData(params.key, params.requestedLoadSize);
        if (dataList != null) {
            callback.onResult(dataList);
        }
    }

    @NonNull
    @Override
    public Integer getKey(@NonNull Student item) {
        return (int) System.currentTimeMillis();

    }
}
