package ru.akkulov.dao;

import ru.akkulov.connection.SimpleConnectionPool;
import ru.akkulov.model.Team;
import ru.akkulov.connection.SimpleProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    private final SimpleProperties properties = SimpleProperties.getProperties();

    private static final String ADD_SQL_QUERY = "INSERT INTO team (name) VALUES (?);";

    private static final String SELECT_ALL_SQL_QUERY = "SELECT * FROM team;";

    private static final String GET_BY_ID_SQL_QUERY = "SELECT id, name FROM team WHERE id=?;";

    private static final String UPDATE_ONE_SQL_QUERY = "UPDATE team SET name=? WHERE id=?;";

    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM team WHERE id=?;";


    public void create(Team team) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(),
                properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_SQL_QUERY)
        ) {
            preparedStatement.setString(1, team.getName().name());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Team> readAll() {
        List<Team> teamsList = new ArrayList<>();

        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL_QUERY)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Team team = new Team();

                team.setId(resultSet.getInt("id"));
                team.setName(Team.Names.valueOf(resultSet.getString("name")));

                teamsList.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamsList;
    }


    public Team getById(int team_id) {
        Team team = new Team();

        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL_QUERY)
        ) {
            preparedStatement.setInt(1, team_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                team.setId(resultSet.getInt("id"));
                team.setName(Team.Names.valueOf(resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }


    public void updateOne(int team_id, Team.Names new_team_name) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_SQL_QUERY)
        ) {
            preparedStatement.setString(1, new_team_name.name());
            preparedStatement.setInt(2, team_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteOne(int team_id) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL_QUERY)
        ) {
            preparedStatement.setInt(1, team_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
