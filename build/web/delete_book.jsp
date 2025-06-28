<%-- 
    Document   : delete_book
    Created on : 15-Oct-2023, 4:01:59 pm
    Author     : Upendra Kumar Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Delete Book</h2>
    <form action="DeleteBookServlet" method="post">
         <input type="text" name="id" placeholder="Enter Book ID" required>
        <input type="submit" value="Delete Book">
    </form>
</body>
</html>

