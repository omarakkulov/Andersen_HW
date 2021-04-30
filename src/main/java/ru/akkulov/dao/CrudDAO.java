package ru.akkulov.dao;

import java.util.List;

public interface CrudDAO<T> {
    void create(T t);
    List<T> readAll();
    T getById(int id);
    void updateOne(T t);
    void deleteOne(int id);
}
