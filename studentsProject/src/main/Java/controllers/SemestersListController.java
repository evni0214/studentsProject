package controllers;

import database.DataService;
import entity.Semester;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class SemestersListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Semester> semesterList = service.selectAllSemesters();
        req.setAttribute("semesterList", semesterList);
        req.setAttribute("titleAttribute", "List of semesters");
        req.setAttribute("currentPage", "semestersList.jsp");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }
}
