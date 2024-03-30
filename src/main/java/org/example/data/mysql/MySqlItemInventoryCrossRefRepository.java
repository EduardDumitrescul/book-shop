package org.example.data.mysql;

import org.example.data.entities.InventoryItemCrossRef;
import org.example.data.repositories.ItemInventoryCrossRefRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlItemInventoryCrossRefRepository implements ItemInventoryCrossRefRepository {
    private Connection connection = MySqlConnection.getConnection();
    private final String SELECT = "select * from inventoryItemCrossRef " +
            "where itemId=? and inventoryId=?";


    @Override
    public InventoryItemCrossRef getInventoryItem(int inventoryId, int itemId) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, itemId);
            statement.setInt(2, inventoryId);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next()) {
                return null;
            }
            return createEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final String UPDATE = "update inventoryItemCrossRef " +
            "set count = ? " +
            "where itemId = ? and inventoryId = ?";
    @Override
    public void update(InventoryItemCrossRef inventoryItemCrossRef) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, inventoryItemCrossRef.count);
            statement.setInt(2, inventoryItemCrossRef.itemId);
            statement.setInt(3, inventoryItemCrossRef.inventoryId);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final String SELECT_BY_INVENTORY = "select * from inventoryItemCrossRef " +
            "where inventoryId = ?";
    @Override
    public List<InventoryItemCrossRef> getItemsByInventoryId(int inventoryId) {
        try {
            List<InventoryItemCrossRef> list = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_INVENTORY);
            statement.setInt(1, inventoryId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                list.add(createEntity(resultSet));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String INSERT = "insert into inventoryItemCrossRef " +
            "values(?, ?, ?)";
    @Override
    public void add(InventoryItemCrossRef inventoryItemCrossRef) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, inventoryItemCrossRef.itemId);
            statement.setInt(2, inventoryItemCrossRef.inventoryId);
            statement.setInt(3, inventoryItemCrossRef.count);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String DELETE = "delete from inventoryItemCrossRef " +
            "where itemId = ?";
    @Override
    public void deleteByItemId(int itemId) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, itemId);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private InventoryItemCrossRef createEntity(ResultSet resultSet) throws SQLException {
        return new InventoryItemCrossRef(
                resultSet.getInt(2),
                resultSet.getInt(1),
                resultSet.getInt(3)
        );
    }

    private MySqlItemInventoryCrossRefRepository() {}

    private static MySqlItemInventoryCrossRefRepository instance = null;

    public static MySqlItemInventoryCrossRefRepository getInstance() {
        if(instance == null) {
            instance = new MySqlItemInventoryCrossRefRepository();
        }
        return instance;
    }
}
