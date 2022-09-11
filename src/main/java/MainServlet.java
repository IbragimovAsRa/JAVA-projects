import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;


public class MainServlet extends HttpServlet {
    Connection connection = null;

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/productdb?serverTimezone=UTC",
                    "aslan_user", "password");
            System.out.println("Successful connection to the database.\n");
        } catch (Exception exception) {
            System.out.println(exception);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("input servlet main");
        String username = request.getParameter("username");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");

        try {
            Statement statement = connection.createStatement();
            String sql_command = "INSERT INTO Users VALUES(" +
                    "'" + username + "'" + "," + "'" + password + "'"  + "," + "'" + mail + "'" +");";
            int rows = statement.executeUpdate(sql_command);
            System.out.println("ROWS" + rows);
                } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("input servlet main");

    }


    @Override
    public void destroy() {
        try {
            connection.close();
            System.out.println("CLOSE SUCCESSES");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}











