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
        req.getRequestDispatcher("/WEB-INF/JSP/disciplinesCreating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Discipline discipline = new Discipline(req.getParameter("disciplineName"));
        DataService service = new DataService();
//        System.out.println(discipline.getDisciplineName());
        service.insertDiscipline(discipline);
//        System.out.println("INSERT STATEMENT PROCESSED");
        req.getRequestDispatcher("/WEB-INF/JSP/disciplinesCreating.jsp").forward(req, resp);
    }
}
