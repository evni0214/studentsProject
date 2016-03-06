package controllers;

import database.DataService;
import entity.Discipline;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 05.03.2016.
 */
public class DisciplinesModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        String disciplineId = req.getParameter("ids");
        if(!(disciplineId == null)) {
        Discipline discipline = service.selectDisciplineById(Long.parseLong(disciplineId));
        String disciplineName = discipline.getName();

            req.setAttribute("disciplineName", disciplineName);
            req.setAttribute("titleAttribute", "Modify discipline");
            req.setAttribute("currentPage", "disciplinesModifying.jsp");
            req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
        } else {
            String currentRole = (String)req.getSession().getAttribute("role");
            resp.sendRedirect("/" + currentRole + "/disc_list");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Discipline disciplineOldName = new Discipline(req.getParameter("oldDisciplineName"));
        Discipline disciplineNewName = new Discipline(req.getParameter("disciplineName"));
        DataService service = new DataService();

        service.updateDiscipline(disciplineOldName, disciplineNewName);

        String currentRole = (String)req.getSession().getAttribute("role");
        resp.sendRedirect("/" + currentRole + "/disc_list");
        return;
    }
}
