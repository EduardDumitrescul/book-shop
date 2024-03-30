package org.example.data.mysql;

import org.example.data.entities.UserEntity;
import org.example.data.repositories.UserRepository;

import java.sql.*;

public class MySqlUserRepository implements UserRepository {

    private Connection connection = MySqlConnection.getConnection();

    private final String SELECT = "select * from users " +
            "where id = ?";
    @Override
    public UserEntity getUser(int id) {
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

    private final String COUNT_USERNAME = "select count(*) from users " +
            "where username = ?";
    @Override
    public boolean usernameExists(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(COUNT_USERNAME);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String INSERT = "insert into users(username, password, inventoryId) " +
            "values (?, ?, ?)";
    @Override
    public int add(UserEntity user) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.username);
            statement.setString(2, user.password);
            statement.setInt(3, user.inventoryId);
            statement.execute();
            ResultSet key = statement.getGeneratedKeys();
            key.next();
            return key.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String SELECT_USERNAME = "select * from users " +
            "where username = ?";
    @Override
    public UserEntity getByUsername(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USERNAME);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return createEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static UserEntity createEntity(ResultSet resultSet) throws SQLException {
        return new UserEntity(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4)
        );
    }

    private MySqlUserRepository() {}

    private static MySqlUserRepository instance = null;

    public static MySqlUserRepository getInstance() {
        if(instance == null) {
            instance = new MySqlUserRepository();
        }
        return instance;
    }
}
