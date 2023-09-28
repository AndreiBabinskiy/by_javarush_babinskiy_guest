package by.javarush.babinskiy.guest;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "nameServlet", value = "/final-servlet")
public class FifthWayServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        String radioFinal = request.getParameter("result-final");
        httpSession.setAttribute("result-finalOne-way",radioFinal);
        if (radioFinal.equals("result-finalOne-way")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("firstWay.jsp");
            requestDispatcher.forward(request, response);
        } else {
            httpSession.invalidate();
            response.sendRedirect("index.jsp");
        }
    }
}