<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="bookmanagemenetsystem.Book" %>
<%
    String url = "jdbc:mysql://localhost:3306/books";
    String user = "root";
    String password = "";
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<Book> books = new ArrayList<Book>();
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, password);
        String query = "SELECT * FROM book";
        statement = connection.prepareStatement(query);
        resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            double price = resultSet.getDouble("price");
            Book book = new Book(id, title, author, price);
            books.add(book);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>List of Books</h2>
   <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
        </tr>
        <%
            for (Book book : books) {
        %>
        <tr>
            <td><%= book.getId() %></td>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getPrice() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
