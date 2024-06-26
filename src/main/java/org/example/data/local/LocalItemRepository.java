package org.example.data.local;

import org.example.data.entities.ItemEntity;
import org.example.data.repositories.ItemRepository;
import org.example.utils.ObjectCloningUtil;

import java.util.ArrayList;
import java.util.List;

public class LocalItemRepository implements ItemRepository {
    private final List<ItemEntity> items = new ArrayList<>();


    public void update(ItemEntity item) {
        for(int i = 0; i < items.size(); i ++) {
            if(items.get(i).id == item.id) {
                items.set(i, item.clone());
            }
        }
    }
    public List<ItemEntity> getById(List<Integer> ids) {
        List<ItemEntity> list = new ArrayList<>();
        for(ItemEntity entity: items) {
            if(ids.contains(entity.getId())) {
                list.add(entity.clone());
            }
        }
        return list;
    }

    public ItemEntity getById(int id) {
        for(ItemEntity entity: items) {
            if(entity.getId() == id) {
                return entity.clone();
            }
        }
        return null;
    }

    public List<ItemEntity> getAll() {
        return ObjectCloningUtil.cloneList(items);
    }

    public int addItem(ItemEntity entity) {
        ItemEntity item = entity.clone();
        generateId(item);
        items.add(item);
        return item.id;
    }
    public void delete(int id) {
        for(int i = 0; i < items.size(); i ++) {
            if(items.get(i).id == id) {
                items.remove(i);
                return;
            }
        }
    }

    private static int idCount = 0;
    private void generateId(ItemEntity entity) {
        idCount ++;
        entity.id = idCount;
    }

    private static LocalItemRepository instance = null;

    private LocalItemRepository() {}

    public static LocalItemRepository getInstance()   {
        if(instance == null) {
            instance = new LocalItemRepository();
        }
        return instance;
    }
}
