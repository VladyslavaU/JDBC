package firstmvc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/averageController")
public class AverageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));

        AverageCalculatorModel model = new AverageCalculatorModel();
        int result = model.calculate(num1, num2);
        request.setAttribute("result", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultMVC.jsp");
        dispatcher.forward(request, response);
    }
}
