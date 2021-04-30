package ru.akkulov.dao;

import ru.akkulov.connection.SimpleConnectionPool;
import ru.akkulov.model.Employee;
import ru.akkulov.model.Team;
import ru.akkulov.connection.SimpleProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO implements CrudDAO<Team> {
    SimpleProperties properties = SimpleProperties.getProperties();

    private static final String ADD_SQL_QUERY = "INSERT INTO team (name, employee_id) VALUES (?, ?);";

    private static final String SELECT_ALL_SQL_QUERY = "SELECT * FROM team;";

    private static final String GET_BY_ID_SQL_QUERY = "SELECT id, name, employee_id FROM team WHERE id=?;";

    private static final String UPDATE_ONE_SQL_QUERY = "UPDATE team SET name=?, employee_id=? WHERE id=?;";

    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM team WHERE id=?;";

    @Override
    public void create(Team team) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(),
                properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_SQL_QUERY)
        ) {
            preparedStatement.setString(1, team.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Team> readAll() {
        List<Team> teamsList = new ArrayList<>();
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL_QUERY);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employer_id"));

                Team team = new Team();
                team.setId(resultSet.getInt("id"));
                team.setName(resultSet.getString("name"));
                team.setEmployee_id(employee.getId());
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Team getById(int id) {
        Team team = new Team();

        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL_QUERY)
        ) {

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                team.setId(resultSet.getInt("id"));
                team.setName(resultSet.getString("name"));
                team.setEmployee_id(resultSet.getInt("employee_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    @Override
    public void updateOne(Team team) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_SQL_QUERY)
        ) {
            preparedStatement.setString(1, team.getName());
            preparedStatement.setLong(2, team.getEmployee_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOne(int id) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL_QUERY)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
