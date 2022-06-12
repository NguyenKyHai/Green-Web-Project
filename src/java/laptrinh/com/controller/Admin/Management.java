package laptrinh.com.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import laptrinh.com.dao.CartItemDao;
import laptrinh.com.dao.ProductDao;
import laptrinh.com.dao.UserDao;
import laptrinh.com.model.Users;

@WebServlet(name = "Management", urlPatterns = {"/management"})
public class Management extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("usersession");
        if (u.getRole() == 1) {
            ProductDao dao = new ProductDao();
            UserDao userdao = new UserDao();
            CartItemDao itemdao = new CartItemDao();
            long numproduct = dao.countProduct();
            long numuser = userdao.countUser();
            long numorder = itemdao.countCartItem();
            Date date;
            Date date2;
            Calendar cal = Calendar.getInstance();
            date=cal.getTime();
            cal.add(Calendar.DATE, -7);
            date2=cal.getTime();
            long numdate=itemdao.countCartByDate(date);
            long numweek=itemdao.countCartByWeek(date2, date);
            request.setAttribute("numdate", numdate);
            request.setAttribute("numweek", numweek);
            request.setAttribute("numproduct", numproduct);
            request.setAttribute("numuser", numuser);
            request.setAttribute("numorder", numorder);
            
            request.getRequestDispatcher("management.jsp").forward(request, response);
        } else {
            response.sendRedirect("error-page/error-page.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
