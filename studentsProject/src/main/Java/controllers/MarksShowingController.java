package controllers;

import database.DataService;
import entity.Discipline;
import entity.Semester;
import entity.Student;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MarksShowingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Student> studentList = service.selectAllStudents();
        List<Semester> semesterList = service.selectAllSemesters();
        Map<Discipline, Integer> studentMarks = new HashMap<Discipline, Integer>();
        Student student;
        Long studentId = 0L;
        Long semesterId = 0L;

        if(req.getParameter("selectStudent") == null || req.getParameter("selectSemester") == null) {
            studentId = studentList.get(0).getStudentId();
            semesterId = semesterList.get(0).getSemesterId();
            student = service.selectStudentById(studentId);
            student.setMarks(service.selectAllStudentMarksBySemester(student, semesterId));
        } else {
            studentId = Long.parseLong(req.getParameter("selectStudent"));
            semesterId = Long.parseLong(req.getParameter("selectSemester"));
            student = service.selectStudentById(studentId);
            student.setMarks(service.selectAllStudentMarksBySemester(student, semesterId));
        }

        req.setAttribute("marks", student.getMarks());
        req.setAttribute("studentList", studentList);
        req.setAttribute("semesterList", semesterList);
        req.setAttribute("studentId", student.getStudentId());
        req.setAttribute("semesterId", semesterId);
        req.setAttribute("titleAttribute", "Show the marks");
        req.setAttribute("currentPage", "marksShowing.jsp");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }
}
