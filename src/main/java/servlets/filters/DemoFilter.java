package servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/filterServlet")
public class DemoFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print("Pre Servlet");
        chain.doFilter(request, response);
        out.print("Post Servlet");
    }
}
