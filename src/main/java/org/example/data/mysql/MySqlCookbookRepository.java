package org.example.data.mysql;

import org.example.data.entities.ColoringBookEntity;
import org.example.data.entities.CookbookEntity;
import org.example.data.repositories.Repository;

import java.sql.*;

public class MySqlCookbookRepository implements Repository<CookbookEntity> {
    private final Connection connection = MySqlConnection.getConnection();
    private final String INSERT = "insert into cookbooks(id, skillLevel, numberOfRecipes, numberOfRecipesTried) " +
            "values(?, ?, ?, ?)";
    @Override
    public int add(CookbookEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.id);
            statement.setString(2, entity.skillLevel);
            statement.setInt(3, entity.numberOfRecipes);
            statement.setInt(4, entity.numberOfRecopesTried);
            statement.execute();
            return entity.id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final String COUNT_ID = "select count(*) from cookbooks " +
            "where id = ? ";
    @Override
    public boolean exists(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(COUNT_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final String SELECT = "select * from cookbooks " +
            "where id = ?";
    @Override
    public CookbookEntity getById(int id) {
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

    private final String UPDATE = "update cookbooks " +
            "set skillLevel = ?, numberOfRecipes = ?, numberOfRecipesTried = ? " +
            "where id = ?";
    @Override
    public void update(CookbookEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, entity.skillLevel);
            statement.setInt(2, entity.numberOfRecipes);
            statement.setInt(3, entity.numberOfRecopesTried);
            statement.setInt(4, entity.id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String DELETE = "delete from cookbooks " +
            "where id = ?";
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

    private static CookbookEntity createEntity(ResultSet resultSet) throws SQLException {
        return new CookbookEntity(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getInt(3),
                resultSet.getInt(4)
        );
    }

    private MySqlCookbookRepository() {}

    private static MySqlCookbookRepository instance = null;

    public static MySqlCookbookRepository getInstance() {
        if(instance == null) {
            instance = new MySqlCookbookRepository();
        }
        return instance;
    }
}
