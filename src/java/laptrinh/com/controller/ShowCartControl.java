package laptrinh.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import laptrinh.com.dao.CartItemDao;
import laptrinh.com.dao.CategoryDao;
import laptrinh.com.model.Cartitem;
import laptrinh.com.model.Category;

@WebServlet(name = "ShowCartControl", urlPatterns = {"/cart"})
public class ShowCartControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Cartitem> list = new ArrayList<>();
        CartItemDao dao = new CartItemDao();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("order");
        if (obj == null) {
            response.sendRedirect("cart.jsp");
        } else {
            list = (List) session.getAttribute("order");
            long total = dao.getTotal(list);
            long vat = dao.getVat(total);
            long sum = dao.getSum(total);
            int qcart = list.size();
            CategoryDao categoryDao = new CategoryDao();
            List<Category> listCategorys = categoryDao.findAllCategory();
            request.setAttribute("listC", listCategorys);
            request.setAttribute("list", list);
            session.setAttribute("sum", sum);
            session.setAttribute("qcart", qcart);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
