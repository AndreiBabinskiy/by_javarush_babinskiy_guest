import by.javarush.babinskiy.guest.FirstWayServlet;
import by.javarush.babinskiy.guest.SecondWayServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondWayServletTest {
    @Test
    public void testDoPost() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpSession
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute("ipaddress")).thenReturn(false);
        Mockito.when(session.getAttribute("name-way")).thenReturn("Pet");
        Mockito.when(request.getParameter("one-way")).thenReturn("radioOne");

        //мы проверяем, что значение атрибута "name-human" в объекте session равно Pet
        assertEquals("Pet", session.getAttribute("name-way"));
        //мы проверяем, что значение атрибута "name-human" в объекте session равно Pet
        assertEquals("radioOne", request.getParameter("one-way"));
    }
    @Test
    public void testForWardingSecondWay() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Создаем мок для RequestDispatcher
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getRequestDispatcher("twoWay.jsp")).thenReturn(requestDispatcher);

        // Создаем экземпляр вашего сервлета
        SecondWayServlet secondWayServlet = new SecondWayServlet();

        // Вызываем метод, который содержит код с использованием RequestDispatcher
        secondWayServlet.doPost(request,response);
        // Проверяем, что методы были вызваны с правильными аргументами
        Mockito.verify(request).getRequestDispatcher("twoWay.jsp");
        Mockito.verify(requestDispatcher).forward(request, response);
    }
    @Test
    public void testForWardingFifthWay() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Создаем мок для RequestDispatcher
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getRequestDispatcher("fifth.jsp")).thenReturn(requestDispatcher);

        // Создаем экземпляр вашего сервлета
        FirstWayServlet firstWayServlet = new FirstWayServlet();

        // Вызываем метод, который содержит код с использованием RequestDispatcher
        firstWayServlet.doPost(request,response);
        // Проверяем, что методы были вызваны с правильными аргументами
        Mockito.verify(request).getRequestDispatcher("fifth.jsp");
        Mockito.verify(requestDispatcher).forward(request, response);
    }
}
