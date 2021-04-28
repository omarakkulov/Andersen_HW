import ru.akkulov.entity.Employee;
import ru.akkulov.service.EmployeeService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        Employee employee = new Employee();
        employee.setFirst_name("Omasdasdasdar");
        employee.setLast_name("Akkuasdasdasdlov");
        employee.setEmail("omar-akkasdasdasdulov@mail.ru");
        employee.setPhone("8921768asdasdasd3330");
        employee.setDate_of_birth("15.05.1999");
        employee.setExperience(1);
        employee.setDate_of_employment("21.05.2021");
        employee.setSkill_level("j1");
        employee.setEng_level("b1");
        employee.setSkype("omarakkulov");

        employeeService.add(employee);

//        Employee employee1 = employeeService.getById(4L);
//        System.out.println(employee1);

//
//        List<Employee> list = employeeService.getAll();
//        for (Employee e : list) {
//            System.out.println(e);
//        }
    }
}
