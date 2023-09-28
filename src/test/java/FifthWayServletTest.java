import by.javarush.babinskiy.guest.FifthWayServlet;
import by.javarush.babinskiy.guest.FirstWayServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifthWayServletTest {
    @Test
    public void testDoPost() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpSession
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter("result-final")).thenReturn("result-finalOne-way");

        //мы проверяем, что значение атрибута "name-human" в объекте session равно Pet
        assertEquals("result-finalOne-way", request.getParameter("result-final"));
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
        FifthWayServlet fifthWayServlet = new FifthWayServlet();

        // Вызываем метод, который содержит код с использованием RequestDispatcher

        fifthWayServlet.doPost(request,response);
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
        FifthWayServlet fifthWayServlet = new FifthWayServlet();

        // Вызываем метод, который содержит код с использованием httpSession.invalidate() и response.sendRedirect()
        // Устанавливаем ожидания для методов моков
        fifthWayServlet.doPost(request, response);

        // Проверяем, что методы были вызваны с правильными аргументами
        Mockito.verify(session).invalidate();
        Mockito.verify(response).sendRedirect("index.jsp");
    }
}
