import by.javarush.babinskiy.guest.StartingPathServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class StartingPathServletTest {
    @Test
    public void testDoGet() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
    }
    @Test
    public void testForWardingStartingPath() throws ServletException, IOException {
        // Создаем моки для HttpServletRequest и HttpServletResponse
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Создаем мок для ServletContext
        ServletContext servletContext = Mockito.mock(ServletContext.class);

        // Создаем мок для RequestDispatcher
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        // Устанавливаем ожидания для методов моков
        Mockito.when(request.getServletContext()).thenReturn(servletContext);
        Mockito.when(servletContext.getRequestDispatcher("/index.jsp")).thenReturn(requestDispatcher);

        // Создаем экземпляр вашего сервлета
        StartingPathServlet startingPathServlet = new StartingPathServlet();

        // Вызываем метод, который содержит код с использованием getRequestDispatcher().forward()
        startingPathServlet.doGet(request, response);

        // Проверяем, что методы были вызваны с правильными аргументами
        Mockito.verify(servletContext).getRequestDispatcher("/index.jsp");
        Mockito.verify(requestDispatcher).forward(request, response);
    }
}
