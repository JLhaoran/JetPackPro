package com.haoran.jetpack.paging.ItemKeyed;
import com.haoran.jetpack.paging.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * <li>Package: com.haoran.jetpack.paging.ItemKeyed</li>
 * <li>Author: haoran.li</li>
 * <li>Date:  2020/11/16</li>
 * <li>Description: </li>
 */
public class DataRepository {
    private List<Student> dataList = new ArrayList<>();

    public DataRepository() {
        for (int i = 0; i < 1000; i++) {
            Student student = new Student();
            student.id = "ID号是:" + i;
            student.sex = "性别号是:" + i;
            student.name = "姓名是:" + i;
            dataList.add(student);
        }
    }

    public List<Student> initData(int size) {
        return dataList.subList(0, size);
    }

    public List<Student> loadPageData(int page, int size) {
        int totalPage;
        if (dataList.size() % size == 0) {
            totalPage = dataList.size() / size;
        } else {
            totalPage = dataList.size() / size + 1;
        }

        if (page > totalPage || page < 1) {
            return null;
        }
        if (page == totalPage) {
            return dataList.subList((page - 1) * size, dataList.size());
        }
        return dataList.subList((page - 1) * size, page * size);
    }
}
