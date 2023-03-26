package ServletPackages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


@WebServlet("/files")
public class FileServlet extends HttpServlet {

    File file = new File("C:/Java");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = null;
        String username = req.getParameter("username");

        if(req.getParameterValues("btnUp") != null) {
            File newfile = file.getParentFile();
            File parent = new File("C:\\Java");

            if(!newfile.getPath().equals(parent.getPath())){

                file = file.getParentFile();
                path = file.getPath();
            }

        } else if (req.getParameterValues("btnFile") != null) {

            file = new File(req.getParameterValues("btnFile")[0]);
            path = file.getPath();

        }else {
            file = new File("C:\\Java\\" + username);
            path = file.getPath();
        }



        req.setAttribute("path", path);

        if(file.isDirectory()){

            File folder = new File(path);
            File[] files = folder.listFiles();

            req.setAttribute("file", file);
            req.setAttribute("files", files);

        }

        req.getRequestDispatcher("files.jsp").forward(req, resp);
}}