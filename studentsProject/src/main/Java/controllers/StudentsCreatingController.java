package controllers;

import database.DataService;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by Evgeny on 20.02.2016.
 */
public class StudentsCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", "studentsCreating.jsp");
        req.setAttribute("titleAttribute", "Create new student");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student(req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("groupName"),
                Date.valueOf(req.getParameter("startDate")));
        DataService service = new DataService();
        service.insertStudent(student);
        req.setAttribute("currentPage", "studentsCreating.jsp");
        req.setAttribute("titleAttribute", "Create new student");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }
}
