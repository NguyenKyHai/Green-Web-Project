package laptrinh.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import laptrinh.com.dao.UserDao;
import laptrinh.com.model.Users;

@WebServlet(name = "ChangePassword", urlPatterns = {"/change-password"})
public class ChangePassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doPost(request, response);
        request.getRequestDispatcher("change-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String oldpass = request.getParameter("oldpass");
        String newpass = request.getParameter("newpass");
        String renewpass = request.getParameter("renewpass");
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("usersession");
        if (!u.getPassword().equals(oldpass)) {
            request.setAttribute("message", "Mật khẩu cũ sai");
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
        } else if (!newpass.equals(renewpass)) {
            request.setAttribute("message", "Mật khẩu mới chưa trùng khớp");
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
        } else {
            u.setPassword(newpass);
            UserDao dao = new UserDao();
            dao.update(u);
            request.setAttribute("message", "Thay đổi mật khẩu thành công");
            request.getRequestDispatcher("home").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
