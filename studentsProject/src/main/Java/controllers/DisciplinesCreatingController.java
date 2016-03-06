package controllers;

import database.DataService;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 20.02.2016.
 */
public class DisciplinesCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("titleAttribute", "Create new discipline");
        req.setAttribute("currentPage", "disciplinesCreating.jsp");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Discipline discipline = new Discipline(req.getParameter("disciplineName"));
        DataService service = new DataService();
        service.insertDiscipline(discipline);

        String currentRole = (String)req.getSession().getAttribute("role");
        resp.sendRedirect("/" + currentRole + "/disc_create");
        return;
    }
}
