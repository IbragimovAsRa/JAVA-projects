import models.Book;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View_book extends HttpServlet {
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
            Statement statement = connection.createStatement();
            String sql_command = "SELECT * FROM Books";
            ResultSet resultSet = statement.executeQuery(sql_command);

            ArrayList<Book> books = new ArrayList<Book>();

            while(resultSet.next()) {
                books.add(new Book(resultSet.getString(1), resultSet.getString(2)));
            }
            request.setAttribute("books_list", books);
            getServletContext().getRequestDispatcher("/view_book.jsp").forward(request, response);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }
    @Override
    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}