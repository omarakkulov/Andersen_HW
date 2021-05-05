import ru.akkulov.model.Employee;
import ru.akkulov.model.Project;
import ru.akkulov.service.EmployeeService;
import ru.akkulov.service.ProjectService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        Employee employee = new Employee();

        employee.setFirst_name("Omar");
        employee.setLast_name("Akkulov");
        employee.setEmail("omar-akkulov@mail.ru");
        employee.setPhone("89217683330");
        employee.setDate_of_birth(LocalDate.of(1999, 5, 21));
        employee.setExperience(1);
        employee.setDate_of_employment(LocalDate.of(2021, 6, 25));
        employee.setSkill_level(Employee.Skill_level.J1);
        employee.setEng_level(Employee.Eng_level.A1);
        employee.setSkype("omarakkulov");
        employee.setTeam_id(2);
        employee.setProject_id(1);

        employeeService.create(employee);


//        FeedbackService feedbackService = new FeedbackService();
//
//        Feedback feedback = new Feedback();
//
//        feedback.setDescription("хуета полнейшая]");
//        feedback.setDate(LocalDate.of(2021, 5, 26));
//        feedback.setEmployee_id(51);
//
//        feedbackService.deleteOne(5);

//        TeamService teamService = new TeamService();
//        Team team = new Team();
//        team.setName(Team.Names.BACKEND);
//        teamService.create(team);

        Project project = new Project();
        ProjectService projectService = new ProjectService();


    }
}
