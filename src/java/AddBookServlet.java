import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        String url = "jdbc:mysql://localhost:3306/books";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setDouble(3, price);
            statement.executeUpdate();
            connection.close();
            response.sendRedirect("index.html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
