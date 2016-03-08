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
import java.util.List;

/**
 * Created by Evgeny on 08.03.2016.
 */
public class MarksManagementController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Student> studentList = service.selectAllStudents();
        List<Semester> semesterList = service.selectAllSemesters();
        List<Discipline> disciplineList = service.selectAllDisciplines();
        Long currentStudentId = 0L;
        Long currentSemesterId = 0L;
        Long currentDisciplineId = 0L;
        Integer currentMark;

        if(req.getAttribute("currentStudent") == null ||
                req.getAttribute("currentSemester") == null ||
                req.getAttribute("currentDiscipline") == null) {
            currentStudentId = studentList.get(0).getStudentId();
            currentSemesterId = semesterList.get(0).getSemesterId();
            currentDisciplineId = disciplineList.get(0).getDisciplineId();
        } else {
            currentStudentId = Long.parseLong((String)req.getAttribute("currentStudent"));
            currentSemesterId = Long.parseLong((String)req.getAttribute("currentSemester"));
            currentDisciplineId = Long.parseLong((String)req.getAttribute("currentDiscipline"));
        }

        req.setAttribute("studentList", studentList);
        req.setAttribute("semesterList", semesterList);
        req.setAttribute("disciplineList", disciplineList);
        req.setAttribute("currentStudent", currentStudentId);
        req.setAttribute("currentSemester", currentSemesterId);
        req.setAttribute("currentDiscipline", currentDisciplineId);

        req.setAttribute("titleAttribute", "Manage marks");
        req.setAttribute("currentPage", "marksManagement.jsp");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
