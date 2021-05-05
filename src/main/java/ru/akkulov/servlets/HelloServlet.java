package ru.akkulov.servlets;

import ru.akkulov.model.Employee;
import ru.akkulov.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HelloServlet extends HttpServlet {
    private static final String index = "/view/helloJSP.jsp";
    List<Employee> employeeList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService service = new EmployeeService();
        employeeList = service.getAll();

        req.setAttribute("employee", employeeList);
        req.getRequestDispatcher(index).forward(req, resp);
    }
}
