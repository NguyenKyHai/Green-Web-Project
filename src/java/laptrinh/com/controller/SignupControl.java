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
import laptrinh.com.service.JavaMail;
import laptrinh.com.service.RandomString;

@WebServlet(name = "SignupControl", urlPatterns = {"/signup"})
public class SignupControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doPost(request, response);
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String repass = request.getParameter("repass");

        if (!pass.equals(repass)) {
            request.setAttribute("message", "Mật khẩu chưa trùng khớp");
            request.setAttribute("username", user);
            request.setAttribute("pass", pass);
            request.setAttribute("email", email);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            UserDao userDao = new UserDao();
            boolean a = userDao.CheckLoginExist(user);
            boolean e=userDao.CheckEmailExist(email);
            if (a == false && e==false) {
                Users u = new Users(user, pass, email, 0);
                String code = RandomString.randomPassword();
                JavaMail.sendMail(email,"Ma xac nhan","Ma xac nhan cua ban la: "+code);
                HttpSession session = request.getSession();
                session.setAttribute("code", code);
                session.setAttribute("userC", u);
                request.getRequestDispatcher("confirm.jsp").forward(request, response);
            } 
            else if(e==true){
                request.setAttribute("message", "Email đã tồn tại");
                request.setAttribute("username", user);
                request.setAttribute("pass", pass);
                request.setAttribute("email", email);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else {
                request.setAttribute("message", "Tài khoản đã tồn tại");
                request.setAttribute("username", user);
                request.setAttribute("pass", pass);
                request.setAttribute("email", email);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
