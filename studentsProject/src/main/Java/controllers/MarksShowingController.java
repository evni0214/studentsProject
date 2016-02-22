package controllers;

import database.DataService;
import entity.Semester;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class MarksShowingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Student> studentList = service.selectAllStudents();
        List<Semester> semesterList = service.selectAllSemesters();
        req.setAttribute("studentList", studentList);
        req.setAttribute("semesterList", semesterList);
        req.getRequestDispatcher("/WEB-INF/JSP/marksShowing.jsp").forward(req, resp);
    }
}
