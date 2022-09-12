import models.Book;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add_book extends HttpServlet {
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


        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String login = "Aslanbek";
            String bookname = request.getParameter("bookname");
            String author = request.getParameter("author");

            try {
                Statement statement = connection.createStatement();
                String sql_command = "INSERT INTO Books VALUES(" +
                        "'" + login + "'" + "," + "'" + bookname + "'"  + "," + "'" + author + "'" +");";
                statement.executeUpdate(sql_command);
                statement.close();
                getServletContext().getRequestDispatcher("/add_book.html").forward(request, response);
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