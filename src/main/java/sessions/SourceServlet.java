package sessions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }
        response.addCookie(new Cookie("securityToken", "12345"));

        String userName = request.getParameter("userName");
        HttpSession session = request.getSession();
        session.setAttribute("user", userName);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String url = "targetServlet?sessionId=123";
        out.print("<a href='" + url + "'>Click Here To Get The User Name</a>");
    }
}
