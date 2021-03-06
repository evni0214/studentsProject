package controllers;

import database.DataService;
import entity.Discipline;
import entity.Semester;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny on 20.02.2016.
 */
public class SemestersCreatingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Discipline> disciplineList = service.selectAllDisciplines();
        req.setAttribute("discList", disciplineList);
        req.setAttribute("titleAttribute", "Create new semester");
        req.setAttribute("currentPage", "semestersCreating.jsp");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Discipline> disciplineList = new ArrayList<Discipline>();
        String[] disciplinesStringList = req.getParameterValues("disciplineList");
        for(String currDisc : disciplinesStringList) {
            Discipline discipline = new Discipline(Long.parseLong(currDisc));
            disciplineList.add(discipline);
        }
        Semester semester = new Semester(req.getParameter("semesterName"),
                Long.parseLong(req.getParameter("semesterDuration")),
                disciplineList);
        DataService service = new DataService();
        semester.setSemesterId(service.insertSemester(semester));

        service.insertSemesterDisciplines(semester);

        String currentRole = (String)req.getSession().getAttribute("role");
        resp.sendRedirect("/" + currentRole + "/sem_create");
        return;
    }
}
