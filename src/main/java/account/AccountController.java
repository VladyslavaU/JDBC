package account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/account")
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;
    private AccountDAO dao = new AccountDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")){
            createAccount(request,response);
        } else if (action.equals("find")){

        }
    }

    protected void createAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("firstName");
        String email = request.getParameter("firstName");
        int balance = 0;

        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setEmail(email);
        account.setBalance(balance);

        dao.save(account);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<b>Account Created</b>");
        writer.print("</br><a href='/accanddep'>Home</a>");
    }
}
