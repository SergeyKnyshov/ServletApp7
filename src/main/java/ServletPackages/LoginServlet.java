package ServletPackages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;




@WebServlet("/")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserProfile user;
        try {
            user = UserService.getUserByName(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (user == null) {
            resp.getWriter().write("You need to register");
            return;
        } else if (!user.getPass().equals(password)) {
            resp.getWriter().write("Incorrect password");
            return;
        }
        UserService.addNewUser(user);
        UserService.addSession(session.toString(), user);

        if (req.getParameterValues("btnLog") != null ) {
            String path = "/files" + "?path=C:\\Java\\" + username;
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
        }
            req.getRequestDispatcher("login.jsp").forward(req, resp);

    }
}
