package ru.akkulov.dao;

import ru.akkulov.connection.SimpleConnectionPool;
import ru.akkulov.model.Employee;
import ru.akkulov.connection.SimpleProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements CrudDAO<Employee, Integer> {

    SimpleProperties properties = SimpleProperties.getProperties();

    // create
    private static final String ADD_SQL_QUERY = "INSERT INTO employee (first_name, last_name, email, phone, date_of_birth, " +
            "experience, date_of_employment, skill_level, eng_level, skype) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?);";
    // read
    private static final String SELECT_ALL_SQL_QUERY = "SELECT id, first_name, last_name, email, phone, date_of_birth, " +
            "experience, date_of_employment, skill_level, eng_level, skype " +
            "FROM employee;";

    private static final String GET_BY_ID_SQL_QUERY = "SELECT id, first_name, last_name, email, phone, date_of_birth, " +
            "experience, date_of_employment, skill_level, eng_level, skype " +
            "FROM employee WHERE id=?;";
    // update
    private static final String UPDATE_ONE_SQL_QUERY = "UPDATE employee SET first_name=?, last_name=?, email=?, phone=?, date_of_birth=?, " +
            "experience=?, date_of_employment=?, skill_level=?, eng_level=?, skype=? " +
            "WHERE id=?;";
    // delete
    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM employee WHERE id=?;";

    @Override
    public void add(Employee employee) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_SQL_QUERY)
        ) {

            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getDate_of_birth());
            preparedStatement.setInt(6, employee.getExperience());
            preparedStatement.setString(7, employee.getDate_of_employment());
            preparedStatement.setString(8, employee.getSkill_level());
            preparedStatement.setString(9, employee.getEng_level());
            preparedStatement.setString(10, employee.getSkype());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();


        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL_QUERY)
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getLong("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setDate_of_birth(resultSet.getString("date_of_birth"));
                employee.setExperience(resultSet.getInt("experience"));
                employee.setDate_of_employment(resultSet.getString("date_of_employment"));
                employee.setEng_level(resultSet.getString("skill_level"));
                employee.setSkill_level(resultSet.getString("eng_level"));
                employee.setSkype(resultSet.getString("skype"));

                employeeList.add(employee);
            }
            return employeeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getById(Integer id) {
        Employee employee = new Employee();

        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL_QUERY)
        ) {

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getLong("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setDate_of_birth(resultSet.getString("date_of_birth"));
                employee.setExperience(resultSet.getInt("experience"));
                employee.setDate_of_employment(resultSet.getString("date_of_employment"));
                employee.setEng_level(resultSet.getString("skill_level"));
                employee.setSkill_level(resultSet.getString("eng_level"));
                employee.setSkype(resultSet.getString("skype"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateOne(Employee employee) {
        try (Connection connection = SimpleConnectionPool.create(properties.getUrl(), properties.getUser(),
                properties.getPassword()).
                getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_SQL_QUERY)
        ) {
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getDate_of_birth());
            preparedStatement.setInt(6, employee.getExperience());
            preparedStatement.setString(7, employee.getDate_of_employment());
            preparedStatement.setString(8, employee.getSkill_level());
            preparedStatement.setString(9, employee.getEng_level());
            preparedStatement.setString(10, employee.getSkype());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOne(Integer id) {
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
