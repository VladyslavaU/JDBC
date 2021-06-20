package account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

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
            findCoupon(request, response);
        }
    }

    protected void createAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
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
        writer.print("</br><a href='/AccountAndDeposit.html'>Home</a>");
    }

    protected void findCoupon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        ArrayList<Account> accounts = dao.findByNames(firstName, lastName);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<b>Accounts found: ");
        for (Account account : accounts) {
            out.println("<br/>" + account);
        }
        out.print("<br/><a href='/AccountAndDeposit.html'>Home</a>");

    }
    }
