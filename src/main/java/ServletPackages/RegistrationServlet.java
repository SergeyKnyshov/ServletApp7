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




@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserProfile profile = new UserProfile(username, password, email);

        UserService.addSession(session.toString(), profile);

        if (req.getParameterValues("btnReg") != null ) {
            if (UserService.addNewUser(profile)) {
                resp.sendRedirect("login.jsp");
            }else {
                resp.sendRedirect("registration");
            }
        }

    }
}
