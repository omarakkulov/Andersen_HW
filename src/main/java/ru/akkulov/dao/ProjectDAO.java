package ru.akkulov.dao;

import ru.akkulov.connection.SimpleConnectionPool;
import ru.akkulov.connection.SimpleProperties;
import ru.akkulov.model.Employee;
import ru.akkulov.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    private final SimpleProperties properties = SimpleProperties.getProperties();
    // create
    private static final String ADD_SQL_QUERY = "INSERT INTO project (name, customer, duration, methodology, team_id) " +
            "VALUES (?,?,?,?,?);";

    private static final String SELECT_ALL_SQL_QUERY = "SELECT * FROM project;";

    private static final String GET_BY_ID_SQL_QUERY = "SELECT id, name, customer, duration, methodology, team_id " +
            "FROM project WHERE id=?;";

    private static final String UPDATE_ONE_SQL_QUERY = "UPDATE project SET name=?, customer=?, duration=?, methodology=? " +
            "WHERE id=?;";

    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM project WHERE id=?;";


    public void create(Project project) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(),
                properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_SQL_QUERY)
        ) {
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getCustomer().name());
            preparedStatement.setInt(3, project.getDuration());
            preparedStatement.setString(4, project.getMethodology().name());
            preparedStatement.setInt(5, project.getTeam_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Project> readAll() {
        List<Project> projectsList = new ArrayList<>();

        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL_QUERY)
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Project project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setCustomer(Project.Customer.valueOf(resultSet.getString("customer")));
                project.setDuration(resultSet.getInt("duration"));
                project.setMethodology(Project.Methodology.valueOf(resultSet.getString("methodology")));
                project.setTeam_id(resultSet.getInt("team_id"));

                projectsList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectsList;
    }

    public Project getById(int id) {
        Project project = new Project();

        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL_QUERY)
        ) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setCustomer(Project.Customer.valueOf(resultSet.getString("customer")));
                project.setDuration(resultSet.getInt("duration"));
                project.setMethodology(Project.Methodology.valueOf(resultSet.getString("methodology")));
                project.setTeam_id(resultSet.getInt("team_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    public void updateOne(Project project, int id) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_SQL_QUERY)
        ) {
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getCustomer().name());
            preparedStatement.setInt(3, project.getDuration());
            preparedStatement.setString(4, project.getMethodology().name());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOne(int id) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL_QUERY)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
