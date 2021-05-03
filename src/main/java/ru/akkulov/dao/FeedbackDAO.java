package ru.akkulov.dao;

import ru.akkulov.connection.MyConnectionPool;
import ru.akkulov.model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    // create
    private static final String ADD_SQL_QUERY = "INSERT INTO feedback (description, date, employee_id) " +
            "VALUES (?,?,?);";

    private static final String SELECT_ALL_SQL_QUERY = "SELECT * FROM feedback;";

    private static final String GET_BY_ID_SQL_QUERY = "SELECT id, description, date, employee_id " +
            "FROM feedback WHERE id=?;";

    private static final String UPDATE_ONE_SQL_QUERY = "UPDATE feedback SET description=?, date=? " +
            "WHERE id=?;";

    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM feedback WHERE id=?;";

    public void create(Feedback feedback) {
        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_SQL_QUERY)
        ) {
            preparedStatement.setString(1, feedback.getDescription());
            preparedStatement.setDate(2, Date.valueOf(feedback.getDate()));
            preparedStatement.setInt(3, feedback.getEmployee_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Feedback> readAll() {
        List<Feedback> feedbacksList = new ArrayList<>();

        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL_QUERY)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Feedback feedback = new Feedback();

                feedback.setId(resultSet.getInt("id"));
                feedback.setDescription(resultSet.getString("description"));
                feedback.setDate(resultSet.getDate("date").toLocalDate());
                feedback.setEmployee_id(resultSet.getInt("employee_id"));

                feedbacksList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacksList;
    }

    public Feedback getById(int id) {
        Feedback feedback = new Feedback();
        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL_QUERY)
        ) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                feedback.setId(resultSet.getInt("id"));
                feedback.setDescription(resultSet.getString("description"));
                feedback.setDate(resultSet.getDate("date").toLocalDate());
                feedback.setEmployee_id(resultSet.getInt("employee_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }

    public void updateOne(Feedback feedback, int id) {
        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_SQL_QUERY)
        ) {
            preparedStatement.setString(1, feedback.getDescription());
            preparedStatement.setDate(2, Date.valueOf(feedback.getDate()));
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOne(int id) {
        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL_QUERY)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

