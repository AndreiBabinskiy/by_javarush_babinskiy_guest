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

@WebServlet(name = "firstServlet", value = "/first-servlet")
public class FirstWayServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        count = 0;
        httpSession.setAttribute("countWay", count);

        count++;
        httpSession.setAttribute("countWay", count);

        String ipAddress = request.getRemoteAddr();
        httpSession.setAttribute("ipaddress",ipAddress);
        String nameWay = request.getParameter("name-human");
        if (nameWay != "") {
            httpSession.setAttribute("name-way", nameWay);
        } else {
            nameWay = "NoName";
            httpSession.setAttribute("name-way", nameWay);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("firstWay.jsp");
        requestDispatcher.forward(request, response);
    }
}