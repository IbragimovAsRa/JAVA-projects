
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Book" %>
<%@ page import = "java.lang.*" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<Book> books = (List<Book>) request.getAttribute("books_list");
    Book book = books.get(0);
    out.println("<p>"+ book.getBookname() + "</p>");
%>
<br>Вернуться на предыдущую страницу.
<form method="get" action="book_love.html">
    <input type="submit" value="Назад"/>
</form>
</body>
</html>
