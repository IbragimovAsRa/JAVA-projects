import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;


public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("input servlet main");
        String username = request.getParameter("username");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println("\n");
        System.out.println(mail);
        System.out.println("\n");
        System.out.println(password);
        System.out.println("\n");
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("input servlet main");

    }
}











