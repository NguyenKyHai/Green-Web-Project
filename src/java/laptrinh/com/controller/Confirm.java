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

@WebServlet(name = "Confirm", urlPatterns = {"/confirm"})
public class Confirm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        String c = (String) session.getAttribute("code");
        if (c == null ? code == null : c.equals(code)) {
            Users u = (Users) session.getAttribute("userC");
            UserDao userDao = new UserDao();
            userDao.insert(u);
            session.removeAttribute("code");
            session.removeAttribute("user");
            response.sendRedirect("login.jsp");
        }
        else{
            response.sendRedirect("confirm.jsp");
        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
