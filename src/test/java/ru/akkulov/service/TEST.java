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
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class TEST {
//    private int employee_id = 1;
//    private int employee_count = 1;
//    private EmployeeService employeeService;
//    private Employee employee;
//
//    private int project_id = 1;
//    private int project_count = 1;
//    private ProjectService projectService;
//    private Project project;
//
//    private int team_id = 1;
//    private int team_count = 1;
//    private TeamService teamService;
//    private Team team;
//
//    private int feedback_id = 1;
//    private int feedback_count = 1;
//    private FeedbackService feedbackService;
//    private Feedback feedback;
//
////    @After
////    public void doAfterEveryTest() {
////
////    }
//
//    @Test
//    void add() {
//        teamService = new TeamService();
//        team = new Team();
//        team.setId(team_id);
//        team.setName(Team.Names.BACKEND);
//        teamService.create(team);
//
//
//        projectService = new ProjectService();
//        project = new Project();
//        project.setId(project_id);
//        project.setName("Moon");
//        project.setCustomer(Project.Customer.Scientific_Corporation);
//        project.setDuration(56);
//        project.setMethodology(Project.Methodology.Object_Oriented_Programming);
//        project.setTeam_id(team_id);
//        projectService.create(project);
//
//
//        employeeService = new EmployeeService();
//        employee = new Employee();
//        employee.setId(employee_id);
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
//        employee.setTeam_id(team_id);
//        employee.setProject_id(project_id);
//        employeeService.create(employee);
//
//
//        feedbackService = new FeedbackService();
//        feedback = new Feedback();
//        feedback.setId(feedback_id);
//        feedback.setDescription("Best");
//        feedback.setDate(LocalDate.of(2000, 2, 2));
//        feedback.setEmployee_id(employee_id);
//        feedbackService.create(feedback);
//
//
//        assertEquals(team, teamService.getById(team_id));
//        assertEquals(project, projectService.getById(project_id));
//        assertEquals(employee, employeeService.getById(employee_id));
//        assertEquals(feedback, feedbackService.getById(feedback_id));
//
//        team_id++;
////        team_count++;
////
//        project_id++;
////        project_count++;
////
//        employee_id++;
////        employee_count++;
////
//        feedback_id++;
////        feedback_count++;
//    }
//
//    @Test
//    void getAll() {
//        Team team = new Team();
//        team.setId(team_id);
//        team.setName(Team.Names.BACKEND);
//
//        List<Team> teams = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            TeamService teamService = new TeamService();
//            teams.add(team);
//            teamService.create(team);
//            team_id++;
//        }
//
//        assertEquals(teams.size(), teamService.getAll().size());
//
////        List<Project> projects = new ArrayList<>();
////        List<Employee> employees = new ArrayList<>();
////        List<Feedback> feedbacks = new ArrayList<>();
//
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