package ru.akkulov.dao;

import ru.akkulov.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    // create
    void add(Employee employee);

    // read
    List<Employee> getAll();

    Employee getById(Long id);

    // update
    void udpate(Employee employee);

    // delete
    void delete(Employee employee);
}
