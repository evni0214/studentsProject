package controllers;

import database.DataService;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class StudentsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Student> students = service.selectAllStudents();
        req.setAttribute("students", students);
        req.setAttribute("currentPage", "studentsList.jsp");
        req.setAttribute("titleAttribute", "List of students");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }
}