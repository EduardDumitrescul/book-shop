package org.example.data.mysql;

import org.example.data.entities.CookbookEntity;
import org.example.data.entities.NotebookEntity;
import org.example.data.repositories.Repository;

import java.sql.*;

public class MySqlNotebookRepository implements Repository<NotebookEntity> {
    private final Connection connection = MySqlConnection.getConnection();
    private final String INSERT = "insert into notebooks(id, type, numberOfPages, numberOfPagesWritten) " +
            "values(?, ?, ?, ?)";
    @Override
    public int add(NotebookEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.id);
            statement.setString(2, entity.type);
            statement.setInt(3, entity.numberOfPages);
            statement.setInt(4, entity.numberOfPagesWritten);
            statement.execute();
            return entity.id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final String COUNT_ID = "select count(*) from notebooks " +
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


    private final String SELECT = "select * from notebooks " +
            "where id = ?";
    @Override
    public NotebookEntity getById(int id) {
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

    private final String UPDATE = "update notebooks " +
            "set type = ?, numberOfPages = ?, numberOfPagesWritten = ? " +
            "where id = ?";
    @Override
    public void update(NotebookEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, entity.type);
            statement.setInt(2, entity.numberOfPages);
            statement.setInt(3, entity.numberOfPagesWritten);
            statement.setInt(4, entity.id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String DELETE = "delete from notebooks " +
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

    private static NotebookEntity createEntity(ResultSet resultSet) throws SQLException {
        return new NotebookEntity(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getInt(3),
                resultSet.getInt(4)
        );
    }

    private MySqlNotebookRepository() {}

    private static MySqlNotebookRepository instance = null;

    public static MySqlNotebookRepository getInstance() {
        if(instance == null) {
            instance = new MySqlNotebookRepository();
        }
        return instance;
    }
}
