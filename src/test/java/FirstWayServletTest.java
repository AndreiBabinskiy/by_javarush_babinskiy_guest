import by.javarush.babinskiy.guest.FirstWayServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstWayServletTest {
    @Test
    public void testDoPost() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpSession
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute("countWay")).thenReturn(0);
        Mockito.when(session.getAttribute("ipaddress")).thenReturn(false);
        Mockito.when(session.getAttribute("name-human")).thenReturn("Pet");

        //мы проверяем, что значение атрибута "countWay" в объекте session равно 0
        assertEquals(0,(int) session.getAttribute("countWay"));
        //мы проверяем, что значение атрибута "name-human" в объекте session равно Pet
        assertEquals("Pet", session.getAttribute("name-human"));
    }
    @Test
    public void testForWardingFirstWay() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Создаем мок для RequestDispatcher
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getRequestDispatcher("firstWay.jsp")).thenReturn(requestDispatcher);

        // Создаем экземпляр вашего сервлета
        FirstWayServlet firstWayServlet = new FirstWayServlet();

        // Вызываем метод, который содержит код с использованием RequestDispatcher
        firstWayServlet.doPost(request,response);
        // Проверяем, что методы были вызваны с правильными аргументами
        Mockito.verify(request).getRequestDispatcher("firstWay.jsp");
        Mockito.verify(requestDispatcher).forward(request, response);
    }
}
