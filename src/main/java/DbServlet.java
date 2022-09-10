import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DbServlet extends HttpServlet {
    Connection connection = null;
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/productdb?serverTimezone=UTC",
                    "aslan_user", "password");
            System.out.println("___________________ Successful connection to the database ____________________\n");
        }
        catch (Exception exception) {
            System.out.println("ERROR1");
            System.out.println(exception);

        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Statement stmt = connection.createStatement();
            stmt.close();
            System.out.println("succses");
            if(connection == null) {
                System.out.println("ERROR3");
            }
        } catch (SQLException e) {
            System.out.println("ERROR2");
            throw new RuntimeException(e);
        }
    }
    @Override
    public void destroy() {
        try {
            connection.close();
            System.out.println("CLOSE SUCCESSES");
        } catch (SQLException e) {
            System.out.println("ERROR2");
            throw new RuntimeException(e);
        }
    }

}