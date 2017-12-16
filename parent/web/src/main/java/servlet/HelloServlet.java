package servlet;


import control.service.Service;
import file.FileWork;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    private final Service service = new Service();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String repoMes = service.getHelloFromRepository();
        String servMes = service.getHelloFromService();
        String webMes = "Hello from Web! ";
        System.out.println(webMes);
        String message = repoMes + servMes + webMes;
        FileWork fileWork = new FileWork(getClass().getClassLoader().getResource("test.txt").getFile());
        String[] items = new String[]{repoMes, servMes, webMes};
        fileWork.writeToFile(items);
        req.setAttribute("message", message);
        req.getRequestDispatcher("WEB-INF/jsp/hello.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
