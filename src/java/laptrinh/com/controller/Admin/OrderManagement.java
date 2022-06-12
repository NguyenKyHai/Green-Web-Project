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
import laptrinh.com.dao.CartDao;
import laptrinh.com.dao.CartItemDao;
import laptrinh.com.model.Cart;
import laptrinh.com.model.Cartitem;
import laptrinh.com.model.Users;

@WebServlet(name = "OrderManagement", urlPatterns = {"/order-management"})
public class OrderManagement extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("usersession");
        if (u.getRole() == 1) {
            Object t = request.getParameter("status");
            if (t == null) {
                CartItemDao dao = new CartItemDao();
                List<Cartitem> list = dao.findAllCartItem();
                request.setAttribute("listC", list);
                request.getRequestDispatcher("order-management.jsp").forward(request, response);
            } else {
                int status = Integer.parseInt(request.getParameter("status"));
                if (status == 1 || status == 0) {
                    CartItemDao dao = new CartItemDao();
                    List<Cartitem> list = dao.findStatus(status);
                    request.setAttribute("listC", list);
                    request.setAttribute("status", status);
                    request.getRequestDispatcher("order-management.jsp").forward(request, response);
                }

            }

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
