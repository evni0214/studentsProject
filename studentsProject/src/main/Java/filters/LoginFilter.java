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
        if(currentRole == null) {
            httpServletResponse.sendRedirect("/login");
            return;
        }

        if(httpServletRequest.getPathInfo().startsWith("/admin")) {
            if(!currentRole.equals("admin")) {
                httpServletResponse.sendRedirect("/page_not_found");
                return;
            }
        }

        chain.doFilter(httpServletRequest, httpServletResponse);
    }

    public void destroy() {

    }
}
