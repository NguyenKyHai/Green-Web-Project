package laptrinh.com.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laptrinh.com.dao.UserDao;
import laptrinh.com.model.Users;

@WebServlet(name = "EditUser", urlPatterns = {"/edit-user"})
public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        UserDao dao = new UserDao();
        Users u = dao.findByUserId(id);
        request.setAttribute("user", u);
        request.getRequestDispatcher("user-management").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int role = Integer.parseInt(request.getParameter("role"));
        UserDao dao = new UserDao();
        Users u = dao.findByUserId(id);

        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        u.setRole(role);
        dao.update(u);
        request.setAttribute("user", u);
        request.getRequestDispatcher("user-management").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
