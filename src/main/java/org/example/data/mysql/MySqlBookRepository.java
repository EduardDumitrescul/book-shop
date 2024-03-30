package org.example.data.mysql;

import org.example.data.Seeder;
import org.example.data.entities.BookEntity;
import org.example.data.repositories.Repository;

import java.sql.*;

public class MySqlBookRepository implements Repository<BookEntity> {
    private Connection connection = MySqlConnection.getConnection();
    private final String INSERT = "insert into books(id, title, author, numberOfPages, numberOfPagesRead) " +
            "values(?, ?, ?, ?, ?)";
    @Override
    public int add(BookEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.id);
            statement.setString(2, entity.title);
            statement.setString(3, entity.author);
            statement.setInt(4, entity.numberOfPages);
            statement.setInt(5, entity.numberOfPagesRead);
            statement.execute();
            return entity.id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final String COUNT_ID = "select count(*) from books " +
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


    private final String SELECT = "select * from books " +
            "where id = ?";
    @Override
    public BookEntity getById(int id) {
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

    private final String UPDATE = "update books " +
            "set title = ?, author = ?, numberOfPages = ?, numberOfPagesRead = ? " +
            "where id = ?";
    @Override
    public void update(BookEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, entity.title);
            statement.setString(2, entity.author);
            statement.setInt(3, entity.numberOfPages);
            statement.setInt(4, entity.numberOfPagesRead);
            statement.setInt(5, entity.id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String DELETE = "delete from books " +
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

    private static BookEntity createEntity(ResultSet resultSet) throws SQLException {
        return new BookEntity(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4),
                resultSet.getInt(5)
        );
    }

    private MySqlBookRepository() {}

    private static MySqlBookRepository instance = null;

    public static MySqlBookRepository getInstance() {
        if(instance == null) {
            instance = new MySqlBookRepository();
        }
        return instance;
    }
}
