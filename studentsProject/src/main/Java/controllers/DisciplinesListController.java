package controllers;

import database.DBConnection;
import database.DataService;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;


public class DisciplinesListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Discipline> disciplineList = service.selectAllDisciplines();
        req.setAttribute("disciplineList", disciplineList);
        req.setAttribute("titleAttribute", "List of disciplines");
        req.setAttribute("currentPage", "disciplinesList.jsp");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] setOfIDs = req.getParameter("ids").split(",");
        DataService service = new DataService();

        service.deleteDisciplines(setOfIDs);

        String currentRole = (String)req.getSession().getAttribute("role");
        resp.sendRedirect("/" + currentRole + "/disc_list");
        return;
    }
}
