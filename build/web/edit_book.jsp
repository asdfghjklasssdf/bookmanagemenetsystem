<%-- 
    Document   : edit_book
    Created on : 15-Oct-2023, 4:00:09 pm
    Author     : Upendra Kumar Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Edit Book</h2>
<form action="UpdateBookServlet" method="post">
    <input type="hidden" name="id" value="book_id_to_edit"> <!-- Use JavaScript to populate this -->
    <label for="title">Title:</label>
    <input type="text" name="title" placeholder="Book Title" required>
    <br>
    <label for="author">Author:</label>
    <input type="text" name="author" placeholder="Author Name" required>
    <br>
    <label for="price">Price:</label>
    <input type="number" name="price" step="0.01" placeholder="Price" required>
    <br>
    <input type="submit" value="Update Book">
</form>

</body>
</html>
