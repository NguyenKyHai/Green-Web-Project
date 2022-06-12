package laptrinh.com.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import laptrinh.com.dao.CartItemDao;
import laptrinh.com.model.Cartitem;
import laptrinh.com.model.Product;
import laptrinh.com.model.Users;

@WebServlet(name = "StatisticalByDate", urlPatterns = {"/statistical-by-date"})
public class StatisticalByDate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("usersession");
        if (u.getRole() == 1) {
            Object buydate = request.getParameter("date");
            if (buydate == null) {
                request.getRequestDispatcher("byday.jsp").forward(request, response);
            } else {
                String d = request.getParameter("date");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date date = df.parse(d);
                CartItemDao itemdao = new CartItemDao();
                long count = itemdao.countCartByDate(date);
                List<Cartitem> list = itemdao.findCartByDate(date);
                request.setAttribute("count", count);
                request.setAttribute("list", list);
                request.setAttribute("date", date);
                request.getRequestDispatcher("byday.jsp").forward(request, response);
            }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(StatisticalByDate.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(StatisticalByDate.class.getName()).log(Level.SEVERE, null, ex);
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
