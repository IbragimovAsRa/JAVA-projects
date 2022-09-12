<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Book" %>
<%@ page import="java.lang.*" %>
<%@ page import="javax.servlet.*" %>


<html>
<head>
    <title>Содержимое библиотеки</title>
</head>
<body>

<h2><pre>
            Эти книги лежат на полках:
</pre>
</h2>
<img src="picture/view_book.png" style="float:left; margin-right:10px;"/>
<table border>
    <tr>
        <th>Название книги</th>
        <th>Автор книги</th>
    </tr>
<%
    List<Book> books = (List<Book>) request.getAttribute("books_list");
    for (int i = 0; i < books.size(); i++) {
        out.print("<tr>");
        out.print("<td>"  + books.get(i).getBookname() + "</td>");
        out.print("<td>"  +  books.get(i).getAuthor() + "</td>");
        out.print("</tr>");
    }
%>
</table>
<br>Вернуться на предыдущую страницу.
<form method="get" action="book_love.html">
    <input type="submit" value="Назад"/>
</form>
</body>
</html>
