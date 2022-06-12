package laptrinh.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laptrinh.com.dao.UserDao;
import laptrinh.com.model.Users;
import laptrinh.com.service.JavaMail;
import laptrinh.com.service.RandomString;

@WebServlet(name = "ForgotPassword", urlPatterns = {"/forgot-password"})
public class ForgotPassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doPost(request, response);
        request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        UserDao dao = new UserDao();
        List<Users> list = dao.findByUsername(username);
        if (list.isEmpty()) {
            request.setAttribute("message", "Tài khoản không tồn tại");
            request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
        } else {
            Users u = list.get(0);
            if (u.getEmail() == null ? email != null : !u.getEmail().equals(email)) {
                request.setAttribute("message", "Email không tồn tại");
                request.setAttribute("username", username);
                request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
            } else {
                String pass = RandomString.randomPassword();
                u.setPassword(pass);
                dao.update(u);
                String text = "Mat khau moi la " + pass + "\nTran trong";
                JavaMail.sendMail(u.getEmail(), "Thay doi mat khau", text);
                request.setAttribute("message", "Thay đổi mật khẩu thành công. Vui lòng kiểm tra mail");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
