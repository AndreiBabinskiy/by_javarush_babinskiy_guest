import by.javarush.babinskiy.guest.FifthWayServlet;
import by.javarush.babinskiy.guest.RestartWayServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestartWayServletTest {
    @Test
    public void testDoPost() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpSession
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(session.getAttribute("ipaddress")).thenReturn(false);
        Mockito.when(session.getAttribute("name-threeWay")).thenReturn("Pet");
        Mockito.when(request.getParameter("result-restart")).thenReturn("result-restartOne-way");

        //мы проверяем, что значение атрибута "name-human" в объекте session равно Pet
        assertEquals("Pet", session.getAttribute("name-twoWay"));
        //мы проверяем, что значение атрибута "name-human" в объекте session равно Pet
        assertEquals("result-restartOne-way", request.getParameter("result-restart"));
    }
    @Test
    public void testForWardingFirthWay() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Создаем мок для RequestDispatcher
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getRequestDispatcher("firstWay.jsp")).thenReturn(requestDispatcher);

        // Создаем экземпляр вашего сервлета
        RestartWayServlet restartWayServlet = new RestartWayServlet();

        // Вызываем метод, который содержит код с использованием RequestDispatcher

        restartWayServlet.doPost(request,response);
        // Проверяем, что методы были вызваны с правильными аргументами
        Mockito.verify(request).getRequestDispatcher("firstWay.jsp");
        Mockito.verify(requestDispatcher).forward(request, response);
    }
    @Test
    public void testSessionInvalidationAndRedirect() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Создаем мок для HttpSession
        HttpSession session = Mockito.mock(HttpSession.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getSession()).thenReturn(session);

        // Создаем экземпляр сервлета
        RestartWayServlet restartWayServlet = new RestartWayServlet();

        // Вызываем метод, который содержит код с использованием httpSession.invalidate() и response.sendRedirect()
        // Устанавливаем ожидания для методов моков
        restartWayServlet.doPost(request, response);

        // Проверяем, что методы были вызваны с правильными аргументами
        Mockito.verify(session).invalidate();
        Mockito.verify(response).sendRedirect("index.jsp");
    }
}
