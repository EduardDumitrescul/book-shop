package org.example.data.mysql;

import org.example.data.entities.ItemEntity;
import org.example.data.repositories.ItemRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySqlItemRepository implements ItemRepository {
    private final Connection connection = MySqlConnection.getConnection();

    private final String UPDATE = "update items " +
            "set price = ? " +
            "where id = ?";
    @Override
    public void update(ItemEntity item) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, item.price);
            statement.setInt(2, item.id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<ItemEntity> getById(List<Integer> ids) {
        List<ItemEntity> entities = new ArrayList<>();
        for(int id: ids) {
            ItemEntity item = getById(id);
            entities.add(item);
        }
        return entities;
    }


    private final String SELECT = "select * from items " +
            "where id = ?";
    @Override
    public ItemEntity getById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return createEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String SELECT_ALL = "select * from items";
    @Override
    public List<ItemEntity> getAll() {
        try {
            List<ItemEntity> entites = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                entites.add(createEntity(resultSet));
            }
            return entites;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String INSERT = "insert into items(price) " +
            "values(?)";
    @Override
    public int addItem(ItemEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.price);
            statement.execute();
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            return keys.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final String DELETE = "delete from items " +
            "where id= ?";
    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ItemEntity createEntity(ResultSet resultSet) throws SQLException {
        return new ItemEntity(
                resultSet.getInt(1),
                resultSet.getInt(2)
        );
    }

    private MySqlItemRepository() {}

    private static MySqlItemRepository instance = null;

    public static MySqlItemRepository getInstance() {
        if(instance == null) {
            instance = new MySqlItemRepository();
        }
        return instance;
    }
}
