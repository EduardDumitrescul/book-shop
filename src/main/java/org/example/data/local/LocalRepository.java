package org.example.data.local;

import org.example.data.entities.BaseEntity;
import org.example.data.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public abstract class LocalRepository<T extends BaseEntity> implements Repository<T> {
    private List<T> entities = new ArrayList<>();

    public int add(T entity) {
//        generateId(entity);
        entities.add((T) entity.clone());
        return entity.id;
    }

    public boolean exists(int id) {
        for(T entity: entities) {
            if(entity.id == id) {
                return true;
            }
        }
        return false;
    }

    public T getById(int id) {
        for(T entity: entities) {
            if(entity.id == id) {
                return (T) entity.clone();
            }
        }
        return null;
    }

    public void update(T entity) {
        for(int i = 0; i < entities.size(); i ++) {
            if(entities.get(i).id == entity.id) {
                entities.set(i, (T) entity.clone());
            }
        }
    }

    public void delete(int id) {
        for(int i = 0; i < entities.size(); i ++) {
            if(entities.get(i).id == id) {
                entities.remove(i);
                i --;
            }
        }
    }

    protected LocalRepository() {}

    public static LocalRepository getInstance() {
        return null;
    }
}
