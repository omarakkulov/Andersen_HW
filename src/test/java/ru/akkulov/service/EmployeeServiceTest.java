package ru.akkulov.service;


import org.junit.Before;
import ru.akkulov.model.Employee;

class EmployeeServiceTest {
    EmployeeService employeeService;
    Employee employee;
    @Before
    private void logic(){
        employeeService = new EmployeeService();
        employee = new Employee();

        employee.setFirst_name("John");
        employee.setLast_name("Johnson");
        employee.setEmail("jj@mail.ru");
        employee.setPhone("568565468452");
        employee.setDate_of_birth("15.05.1999");
        employee.setExperience(1);
        employee.setDate_of_employment("21.05.2021");
        employee.setSkill_level("j1");
        employee.setEng_level("b1");
        employee.setSkype("johnjohnson");

    }

    @org.junit.jupiter.api.Test
    void add() {
        employeeService.add(employee);


    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }

    @org.junit.jupiter.api.Test
    void getById() {
    }

    @org.junit.jupiter.api.Test
    void updateOne() {
    }

    @org.junit.jupiter.api.Test
    void deleteOne() {
    }
}