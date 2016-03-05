package controllers;

import database.DataService;
import entity.Role;
import entity.Semester;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Evgeny on 28.02.2016.
 */
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Role> roles = service.selectAllRoles();
        req.setAttribute("rolesList", roles);
        req.setAttribute("titleAttribute", "Login page");
        req.setAttribute("currentPage", "loginPage.jsp");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("selectRole");

        Boolean loginIsValidated = service.validateUser(login, password);
        if(loginIsValidated) {
            Boolean roleIsValidated = service.validateRole(login, role);

            if(roleIsValidated) {
                req.getSession().setAttribute("role", role.toLowerCase());
                resp.sendRedirect("/" + role.toLowerCase() + "/home");
                return;
            } else {
                req.setAttribute("validation", "failed");
                req.setAttribute("errorCase", "roleNotFound");
            }
        } else {
            req.setAttribute("validation", "failed");
            req.setAttribute("errorCase", "userNotFound");
        }

        List<Role> roles = service.selectAllRoles();
        req.setAttribute("rolesList", roles);
        req.setAttribute("titleAttribute", "Login page");
        req.setAttribute("currentPage", "loginPage.jsp");
        req.getRequestDispatcher("/WEB-INF/JSP/template.jsp").forward(req, resp);
    }
}
