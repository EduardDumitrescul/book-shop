package org.example.data.repositories;

public interface Repository<T> {
    int add(T entity);

    boolean exists(int id);

    T getById(int id);

    void update(T entity);

    void delete(int id);
}
