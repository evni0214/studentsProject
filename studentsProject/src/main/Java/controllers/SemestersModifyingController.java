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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny on 06.03.2016.
 */
public class SemestersModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String semesterId = req.getParameter("ids");

        if(!(semesterId == null)) {
            DataService service = new DataService();
            Semester semester = service.selectSemesterById(Long.parseLong(semesterId));
            List<Discipline> semesterDisciplines = semester.getDisciplineList();
            List<Discipline> disciplineList = service.selectAllDisciplines();
            Map<Discipline, Integer> semDiscList = new HashMap<Discipline, Integer>();

            for(Discipline discipline : disciplineList) {
                if(semesterDisciplines.contains(discipline)) {
                    semDiscList.put(discipline, 1);
                } else {
                    semDiscList.put(discipline, 0);
                }
            }

            req.setAttribute("discList", semDiscList);
            req.setAttribute("semName", semester.getName());
            req.setAttribute("semDur", semester.getDuration());
            req.setAttribute("semId", semester.getSemesterId());
            req.setAttribute("titleAttribute", "Modify semester");
            req.setAttribute("currentPage", "semestersModifying.jsp");

            req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
        } else {
            String currentRole = (String)req.getSession().getAttribute("role");
            resp.sendRedirect("/" + currentRole + "/sem_list");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Discipline> disciplineList = new ArrayList<Discipline>();
        String[] disciplinesStringList = req.getParameterValues("disciplineList");

        for(String currDisc : disciplinesStringList) {
            Discipline discipline = new Discipline(Long.parseLong(currDisc));
            disciplineList.add(discipline);
        }

        Semester semester = new Semester(Long.parseLong(req.getParameter("semId")),
                req.getParameter("semesterName"),
                disciplineList,
                Long.parseLong(req.getParameter("semesterDuration")));

        service.updateSemesterById(semester);
        service.deleteDisciplinesBySemesterId(semester.getSemesterId());
        service.insertSemesterDisciplines(semester);

        String currentRole = (String)req.getSession().getAttribute("role");
        resp.sendRedirect("/" + currentRole + "/sem_list");
        return;
    }
}
