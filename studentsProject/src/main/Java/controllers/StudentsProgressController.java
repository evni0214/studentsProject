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

/**
 * Created by Evgeny on 06.03.2016.
 */
public class StudentsProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        String studentId;

        if(req.getParameter("ids") == null)
            studentId = req.getParameter("studentId");
        else
            studentId = req.getParameter("ids");

        Student student = service.selectStudentById(studentId);
        List<Semester> semesterList = service.selectAllSemesters();
        Long semesterId = 0L;

        if(req.getParameter("selectSemester") == null) {
            semesterId = semesterList.get(0).getSemesterId();
            student.setMarks(service.selectStudentMarksBySemester(student, semesterList.get(0).getSemesterId()));
            req.setAttribute("semName", semesterList.get(0).getName());
        }
        else {
            semesterId = Long.parseLong(req.getParameter("selectSemester"));
            student.setMarks(service.selectStudentMarksBySemester(student, semesterId));
            for(Semester semester : semesterList) {
                if(semesterId == semester.getSemesterId()) {
                    req.setAttribute("semName", semester.getName());
                    break;
                }
                continue;
            }
        }

        req.setAttribute("semesterList", semesterList);
        req.setAttribute("marks", student.getMarks());
        req.setAttribute("studentId", student.getStudentId());
        req.setAttribute("lastName", student.getLastName());
        req.setAttribute("firstName", student.getFirstName());
        req.setAttribute("groupId", student.getGroupId());
        req.setAttribute("startDate", student.getStartDate());
        req.setAttribute("avgMark", student.getAvgMark());
        req.setAttribute("currentPage", "studentsProgress.jsp");
        req.setAttribute("titleAttribute", "Progress of selected student");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
