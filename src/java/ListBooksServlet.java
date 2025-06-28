import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListBooksServlet")
public class ListBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String url = "jdbc:mysql://localhost:3306/books";
        String user = "root";
        String password = "";
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM book";
            ResultSet resultSet = statement.executeQuery(query);
            
            out.println("<html><body>");
            out.println("<h2>List of Books</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th></tr>");
            
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt("id") + "</td>");
                out.println("<td>" + resultSet.getString("title") + "</td>");
                out.println("<td>" + resultSet.getString("author") + "</td>");
                out.println("<td>" + resultSet.getDouble("price") + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("</body></html>");
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
