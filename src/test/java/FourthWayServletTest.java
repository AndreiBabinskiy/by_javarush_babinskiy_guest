import by.javarush.babinskiy.guest.FirstWayServlet;
import by.javarush.babinskiy.guest.FourthWayServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourthWayServletTest {
    @Test
    public void testDoPost() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpSession
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute("ipaddress")).thenReturn(false);
        Mockito.when(session.getAttribute("name-twoWay")).thenReturn("Pet");
        Mockito.when(request.getParameter("three-way")).thenReturn("result-restart-way");

        //мы проверяем, что значение атрибута "name-human" в объекте session равно Pet
        assertEquals("Pet", session.getAttribute("name-twoWay"));
        //мы проверяем, что значение атрибута "name-human" в объекте session равно Pet
        assertEquals("result-restart-way", request.getParameter("three-way"));
    }
    @Test
    public void testForWardingFourthWay() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Создаем мок для RequestDispatcher
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getRequestDispatcher("restart.jsp")).thenReturn(requestDispatcher);

        // Создаем экземпляр вашего сервлета
        FourthWayServlet fourthWayServlet = new FourthWayServlet();

        // Вызываем метод, который содержит код с использованием RequestDispatcher
        fourthWayServlet.doPost(request,response);
        // Проверяем, что методы были вызваны с правильными аргументами
        Mockito.verify(request).getRequestDispatcher("restart.jsp");
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
