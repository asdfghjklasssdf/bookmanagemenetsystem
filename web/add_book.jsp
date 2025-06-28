<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Add a New Book</h2>
    <form action="AddBookServlet" method="post">
       <h2>Add a New Book</h2>
    <label for="title">Title:</label>
    <input type="text" name="title" placeholder="Book Title" required>
    <br>
    <label for="author">Author:</label>
    <input type="text" name="author" placeholder="Author Name" required>
    <br>
    <label for="price">Price:</label>
    <input type="number" name="price" step="0.01" placeholder="Price" required>
    <br>
    <input type="submit" value="Add Book">
</form>

        <input type="submit" value="Add Book">
    </form>
</body>
</html>
