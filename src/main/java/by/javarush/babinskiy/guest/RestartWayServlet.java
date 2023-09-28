package by.javarush.babinskiy.guest;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static by.javarush.babinskiy.guest.StartingPathServlet.count;

@WebServlet(name = "restartServlet", value = "/restart-servlet")
public class RestartWayServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        String ipAddress = request.getRemoteAddr();
        httpSession.setAttribute("ipaddress",ipAddress);
        String nameWay = (String) httpSession.getAttribute("name-threeWay");
        httpSession.setAttribute("name-restartWay",nameWay);

        String radioRestart = request.getParameter("result-restart");
        httpSession.setAttribute("result-restartOne-way",radioRestart);
        if (radioRestart.equals("result-restartOne-way")) {
            count++;
            httpSession.setAttribute("countWay",count);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("firstWay.jsp");
            requestDispatcher.forward(request, response);
        } else {
            httpSession.invalidate();
            response.sendRedirect("index.jsp");
        }
    }
}