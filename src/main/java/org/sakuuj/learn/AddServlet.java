package org.sakuuj.learn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usernameParam = req.getParameter("username");
        String emailParam = req.getParameter("email");
        String ageParam = req.getParameter("age");
        Integer age = null;
        if (null != ageParam) {
            age = Integer.parseInt(ageParam);
        }

        User user = User.builder()
                .name(usernameParam)
                .email(emailParam)
                .age(age)
                .build();

        UserDao dao = new UserDao();
        dao.insert(user);
    }
}
