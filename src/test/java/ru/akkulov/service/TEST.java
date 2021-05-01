//package ru.akkulov.service;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Ignore;
//import ru.akkulov.model.Employee;
//import org.junit.jupiter.api.*;
//import ru.akkulov.model.Feedback;
//import ru.akkulov.model.Project;
//import ru.akkulov.model.Team;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class TEST {
//    private int employee_id = 0;
//    private int employee_count = 0;
//    private EmployeeService employeeService;
//    private Employee employee;
//
//    private int project_id = 0;
//    private int project_count = 0;
//    private ProjectService projectService;
//    private Project project;
//
//    private int team_id = 0;
//    private int team_count = 0;
//    private TeamService teamService;
//    private Team team;
//
//    private int feedback_id = 0;
//    private int feedback_count = 0;
//    private FeedbackService feedbackService;
//    private Feedback feedback;
//
//    @Before
//    public void doBeforeEveryTest() {
//        team = new Team();
//        team.setName(Team.Names.BACKEND);
//
//
//        ///
//        project = new Project();
//        project.setName("Moon");
//        project.setCustomer(Project.Customer.Scientific_Corporation);
//        project.setDuration(56);
//        project.setMethodology(Project.Methodology.Object_Oriented_Programming);
//
//
//        ///
//        employee = new Employee();
//
//        employee.setFirst_name("John");
//        employee.setLast_name("Johnson");
//        employee.setEmail("jj@gmail.com");
//        employee.setPhone("88005553535");
//        employee.setDate_of_birth(LocalDate.of(1985, 5, 21));
//        employee.setExperience(8);
//        employee.setDate_of_employment(LocalDate.of(2018, 6, 14));
//        employee.setSkill_level(Employee.Skill_level.S3);
//        employee.setEng_level(Employee.Eng_level.C1);
//        employee.setSkype("johnJohnson");
//
//
//        ///
//        feedback = new Feedback();
//
//        feedback.setDescription("Best");
//        feedback.setDate(LocalDate.of(2000, 2, 2));
//
//    }
//
////    @After
////    public void doAfterEveryTest() {
////
////    }
//
//    @Test
//    @Ignore
//    void add() {
//        teamService = new TeamService();
//        teamService.create(team);
//        team_id++;
//        team_count++;
//
//        projectService = new ProjectService();
//        project.setTeam_id(team_id);
//        projectService.create(project);
//        project_id++;
//        project_count++;
//
//        employeeService = new EmployeeService();
//        employee.setTeam_id(team_id);
//        employee.setProject_id(project_id);
//        employeeService.create(employee);
//        employee_id++;
//        employee_count++;
//
//        feedbackService = new FeedbackService();
//        feedback.setEmployee_id(employee_id);
//        feedbackService.create(feedback);
//        feedback_id++;
//        feedback_count++;
//
//        assertEquals(team, teamService.getById(team_id));
//        assertEquals(project, projectService.getById(project_id));
//        assertEquals(employee, employeeService.getById(employee_id));
//        assertEquals(feedback, feedbackService.getById(feedback_id));
//    }
//
//    @Test
//    void getAll() {
//    }
//
//    @Test
//    void getById() {
//    }
//
//    @Test
//    void updateOne() {
//    }
//
//    @Test
//    void deleteOne() {
//    }
//}