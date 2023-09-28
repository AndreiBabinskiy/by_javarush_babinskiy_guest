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

@WebServlet(name = "threeServlet", value = "/three-servlet")
public class ThirdWayServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        String ipAddress = request.getRemoteAddr();
        httpSession.setAttribute("ipaddress",ipAddress);
        String nameWay = (String) httpSession.getAttribute("name-firstWay");
        httpSession.setAttribute("name-twoWay",nameWay);

        String radio = request.getParameter("two-way");
        httpSession.setAttribute("radioTwo",radio);
        if (radio.equals("one-choice")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("threeWay.jsp");
            requestDispatcher.forward(request, response);
        } else {
            count++;
            httpSession.setAttribute("countWay", count);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("final.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}