package org.example.data.mysql;

import org.example.data.entities.ShopEntity;
import org.example.data.repositories.ShopRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlShopRepository implements ShopRepository {

    private final Connection connection = MySqlConnection.getConnection();
    private final String SELECT = "select * from shops " +
            "where id = ?";
    @Override
    public ShopEntity getById(int id) {
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

    private final String INSERT = "insert into shops(openingHour, closingHour, location, itemsSold, dollarsReceived, inventoryId, ownerId) " +
            "values(?, ?, ?, ?, ?, ?, ?)";
    @Override
    public void addShop(ShopEntity shop) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, shop.openingHour);
            statement.setInt(2, shop.closingHour);
            statement.setString(3, shop.location);
            statement.setInt(4, shop.itemsSold);
            statement.setInt(5, shop.dollarsReceived);
            statement.setInt(6, shop.inventoryId);
            statement.setInt(7, shop.ownerId);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static ShopEntity createEntity(ResultSet resultSet) throws SQLException {
        return new ShopEntity(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getInt(3),
                resultSet.getString(4),
                resultSet.getInt(5),
                resultSet.getInt(6),
                resultSet.getInt(7),
                resultSet.getInt(8)
        );
    }

    private MySqlShopRepository() {}

    private static MySqlShopRepository instance = null;

    public static MySqlShopRepository getInstance() {
        if(instance == null) {
            instance = new MySqlShopRepository();
        }
        return instance;
    }
}
