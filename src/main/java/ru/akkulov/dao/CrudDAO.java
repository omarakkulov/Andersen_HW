package ru.akkulov.dao;

import java.util.List;

public interface CrudDAO<T, U> {
    void add(T object);
    List<T> getAll();
    T getById(U id);
    void updateOne(T object);
    void deleteOne(U object);
}
