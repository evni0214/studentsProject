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
        Semester currentSemester;
        List<Semester> semesterList = service.selectAllSemesters();
        String selectedSemester = req.getParameter("listOfSemesters");

        if(selectedSemester == null) {
            currentSemester = service.selectSemesterById(semesterList.get(0).getSemesterId());
        } else {
            currentSemester = service.selectSemesterById(Long.parseLong(selectedSemester));
        }

        req.setAttribute("semesterList", semesterList);
        req.setAttribute("currSemDisc", currentSemester.getDisciplineList());
        req.setAttribute("currSemDur", currentSemester.getDuration());
        req.setAttribute("currSemName", currentSemester.getName());
        req.setAttribute("currSemId", currentSemester.getSemesterId());
        req.setAttribute("titleAttribute", "List of semesters");
        req.setAttribute("currentPage", "semestersList.jsp");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        String semesterId = req.getParameter("ids");
        service.deleteSemesterById(semesterId);

        String currentRole = (String)req.getSession().getAttribute("role");
        resp.sendRedirect("/" + currentRole + "/sem_list");
        return;
    }
}
