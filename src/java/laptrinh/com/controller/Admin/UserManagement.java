package laptrinh.com.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import laptrinh.com.dao.UserDao;
import laptrinh.com.model.Users;

@WebServlet(name = "UserManagement", urlPatterns = {"/user-management"})
public class UserManagement extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("usersession");
       if (u.getRole() == 1) {
            UserDao dao = new UserDao();
            List<Users> list = dao.findAllUser();
            request.setAttribute("listU", list);
            request.getRequestDispatcher("user-management.jsp").forward(request, response);
        }
       else {
         response.sendRedirect("error-page/error-page.jsp");
       }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
