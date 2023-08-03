package org.sakuuj.learn;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserDao dao = new UserDao();
        List<User> users = dao.selectAll();

        resp.setContentType("text/html");
        System.out.println(users);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
