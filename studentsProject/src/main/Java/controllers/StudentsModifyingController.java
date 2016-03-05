package controllers;

import database.DataService;
import entity.Semester;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Evgeny on 05.03.2016.
 */
public class StudentsModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("ids");
        if(!(studentId == null)) {
            DataService service = new DataService();
            Student student = service.selectStudentById(studentId);

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date sqlDate = student.getStartDate();
            String formattedDate = df.format(sqlDate);

            req.setAttribute("stud_last_name", student.getLastName());
            req.setAttribute("stud_first_name", student.getFirstName());
            req.setAttribute("stud_group_name", student.getGroupId());
            req.setAttribute("stud_start_date", formattedDate);
            req.setAttribute("studentId", studentId);
            req.setAttribute("titleAttribute", "Modify student");
            req.setAttribute("currentPage", "studentsModifying.jsp");

            req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
        }
        String currentRole = (String)req.getSession().getAttribute("role");
        resp.sendRedirect("/" + currentRole +"/stud_list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        SimpleDateFormat inputFormat = new SimpleDateFormat("mm/dd/yyyy");
        Date startDate = null;

        try {
            startDate = new Date(inputFormat.parse(req.getParameter("startDate")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Student student = new Student(req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("groupName"),
                startDate);
        student.setStudentId(Long.parseLong(studentId));
        DataService service = new DataService();
        service.updateStudent(student);

        String currentRole = (String)req.getSession().getAttribute("role");
        resp.sendRedirect("/" + currentRole + "/stud_list");
    }
}
