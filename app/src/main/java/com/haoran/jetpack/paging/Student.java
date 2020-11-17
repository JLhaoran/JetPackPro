package com.haoran.jetpack.paging;

import androidx.annotation.Nullable;

import java.util.Objects;

/**
 * <li>Package: com.haoran.jetpack.paging</li>
 * <li>Author: haoran.li</li>
 * <li>Date:  2020/11/16</li>
 * <li>Description: </li>
 */
public class Student {
    public String id;
    public String name;
    public String sex;


    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex);
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) &&
                name.equals(student.name) &&
                sex.equals(student.sex);
    }
}
