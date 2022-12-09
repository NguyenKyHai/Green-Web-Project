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
        String role = request.getParameter("role");

        if (role.equals("1") || role.equals("0")) {
            UserDao dao = new UserDao();
            Users u = dao.findByUserId(id);
            int r = Integer.parseInt(request.getParameter("role"));
            u.setRole(r);
            dao.update(u);
            request.setAttribute("user", u);
            request.getRequestDispatcher("user-management").forward(request, response);
        } else {
            request.setAttribute("message", "Có lỗi, vui lòng kiểm tra");
            request.getRequestDispatcher("user-management.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
