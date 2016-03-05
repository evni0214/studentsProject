package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 28.02.2016.
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        String currentRole = (String)httpServletRequest.getSession().getAttribute("role");
        String currentPage = httpServletRequest.getRequestURI();

        if(currentRole == null && !currentPage.equals("/login")) {
            httpServletResponse.sendRedirect("/login");
            System.out.println("User is not logged in.");
            return;
        } else {
            if(!(currentRole == null)) {
                currentRole = currentRole.toLowerCase();

                if(currentPage.startsWith("/administrator")) {
                    if(!currentRole.equals("administrator")) {
                        httpServletResponse.sendRedirect("/page_not_found");
                        return;
                    }
                }

                System.out.println("User is logged as " + currentRole);
            }
            chain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    public void destroy() {

    }
}
