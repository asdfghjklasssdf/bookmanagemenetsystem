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

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String url = "jdbc:mysql://localhost:3306/books";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM book WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
            response.sendRedirect("index.html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
