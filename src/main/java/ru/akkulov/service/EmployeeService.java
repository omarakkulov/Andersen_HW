package ru.akkulov.service;

import lombok.Data;
import ru.akkulov.dao.EmployeeDAO;
import ru.akkulov.model.Employee;

import java.util.List;

@Data
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }

    public void add(Employee employee) {
        employeeDAO.create(employee);
    }

    public List<Employee> getAll() {
        return employeeDAO.readAll();
    }

    public Employee getById(Integer id) {
        return employeeDAO.getById(id);
    }

    public void updateOne(Employee employee) {
        employeeDAO.updateOne(employee);
    }

    public void deleteOne(Integer id) {
        employeeDAO.deleteOne(id);
    }
}
