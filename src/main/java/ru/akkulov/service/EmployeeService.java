package ru.akkulov.service;

import ru.akkulov.dao.EmployeeDAO;
import ru.akkulov.entity.Employee;
import ru.akkulov.logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements EmployeeDAO {
    Connection connection;

    {
        try {
            connection = Util.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, email, phone, date_of_birth, " +
                "experience, date_of_employment, skill_level, eng_level, skype) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

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

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT id, first_name, last_name, email, phone, date_of_birth, " +
                "experience, date_of_employment, skill_level, eng_level, skype " +
                "FROM employee;";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

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
            if (connection != null) {
                connection.close();
            }
            return employeeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getById(Long id) {
        String sql = "SELECT id, first_name, last_name, email, phone, date_of_birth, " +
                "experience, date_of_employment, skill_level, eng_level, skype " +
                "FROM employee WHERE id=?;";
        Employee employee = new Employee();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void udpate(Employee employee) {
        String sql = "UPDATE employee SET first_name=?, last_name=?, email=?, phone=?, date_of_birth=?, " +
                "experience=?, date_of_employment=?, skill_level=?, eng_level=?, skype=? " +
                "WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

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
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee employee) {
        String sql = "DELETE FROM employee WHERE id=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.executeUpdate();

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
