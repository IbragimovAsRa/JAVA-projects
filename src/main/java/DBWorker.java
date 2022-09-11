import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private Connection connection;
    public DBWorker() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/productdb?serverTimezone=UTC",
                "aslan_user", "password");
    }

    public Connection getConnection() {
        return connection;
    }
}
