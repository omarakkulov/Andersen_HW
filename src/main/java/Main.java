import ru.akkulov.dao.TeamDAO;
import ru.akkulov.model.Employee;
import ru.akkulov.dao.EmployeeDAO;
import ru.akkulov.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        Employee employee = new Employee();
        employee.setFirst_name("Omar");
        employee.setLast_name("Akkulov");
        employee.setEmail("omar-akkulov@mail.ru");
        employee.setPhone("89217683330");
        employee.setDate_of_birth("15.05.1999");
        employee.setExperience(1);
        employee.setDate_of_employment("21.05.2021");
        employee.setSkill_level("j1");
        employee.setEng_level("b1");
        employee.setSkype("omarakkulov");

        EmployeeService employeeService = new EmployeeService();
        employeeService.add(employee);
    }
}
