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

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        String url = "jdbc:mysql://localhost:3306/books";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE book SET title = ?, author = ?, price = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setDouble(3, price);
            statement.setInt(4, id);
            statement.executeUpdate();
            connection.close();
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
