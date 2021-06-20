package account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deposit")
public class DepositController extends HttpServlet {
    DepositDAO dao = new DepositDAO();
    AccountDAO accDAO = new AccountDAO();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int amount = Integer.parseInt(request.getParameter("amount"));
        String email = request.getParameter("email");
        Deposit deposit = new Deposit();
        deposit.setDeposit(amount);
        deposit.setEmail(email);
        dao.save(deposit);

    }
}
