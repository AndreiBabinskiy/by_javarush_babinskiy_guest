package by.javarush.babinskiy.guest;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "startServlet", value = "/start-servlet")
public class StartingPathServlet extends HttpServlet {
    public static Integer count = 0;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("visited", true);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}