package org.example.data.mysql;

import org.example.data.entities.InventoryEntity;
import org.example.data.repositories.InventoryRepository;

import java.sql.*;

public class MySqlInventoryRepository implements InventoryRepository {

    private final Connection connection = MySqlConnection.getConnection();

    private static final String INSERT = "INSERT INTO inventories values() ";
    private static  final String SELECT = "select id from inventories where id = ?";
    @Override
    public int add(InventoryEntity entity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next()) {
                return keys.getInt(1);
            }
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InventoryEntity getById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new InventoryEntity(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private MySqlInventoryRepository() {};
    private static MySqlInventoryRepository instance = null;

    public static MySqlInventoryRepository getInstance() {
        if(instance == null){
            instance = new MySqlInventoryRepository();
        }
        return instance;
    }
}
