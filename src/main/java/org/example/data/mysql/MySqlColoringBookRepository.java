package org.example.data.mysql;

import org.example.data.entities.BookEntity;
import org.example.data.entities.ColoringBookEntity;
import org.example.data.repositories.Repository;

import java.sql.*;

public class MySqlColoringBookRepository implements Repository<ColoringBookEntity> {
    private final Connection connection = MySqlConnection.getConnection();
    private final String INSERT = "insert into coloringBooks(id, theme, numberOfDrawings, numberOfDrawingsCompleted) " +
            "values(?, ?, ?, ?)";
    @Override
    public int add(ColoringBookEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.id);
            statement.setString(2, entity.theme);
            statement.setInt(3, entity.numberOfDrawings);
            statement.setInt(4, entity.numberOfDrawingCompleted);
            statement.execute();
            return entity.id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final String COUNT_ID = "select count(*) from coloringBooks " +
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


    private final String SELECT = "select * from coloringBooks " +
            "where id = ?";
    @Override
    public ColoringBookEntity getById(int id) {
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

    private final String UPDATE = "update coloringBooks " +
            "set theme = ?, numberOfDrawings = ?, numberOfDrawingsCompleted = ? " +
            "where id = ?";
    @Override
    public void update(ColoringBookEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, entity.theme);
            statement.setInt(2, entity.numberOfDrawings);
            statement.setInt(3, entity.numberOfDrawingCompleted);
            statement.setInt(4, entity.id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String DELETE = "delete from coloringBooks " +
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

    private static ColoringBookEntity createEntity(ResultSet resultSet) throws SQLException {
        return new ColoringBookEntity(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getInt(3),
                resultSet.getInt(4)
        );
    }

    private MySqlColoringBookRepository() {}

    private static MySqlColoringBookRepository instance = null;

    public static MySqlColoringBookRepository getInstance() {
        if(instance == null) {
            instance = new MySqlColoringBookRepository();
        }
        return instance;
    }
}
