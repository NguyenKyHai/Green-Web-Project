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
import laptrinh.com.dao.CategoryDao;
import laptrinh.com.dao.ProductDao;
import laptrinh.com.model.Category;
import laptrinh.com.model.Product;
import laptrinh.com.model.Users;

@WebServlet(name = "ProductManagement", urlPatterns = {"/product-management"})
public class ProductManagement extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("usersession");
        if (u.getRole() == 1) {
            CategoryDao categoryDao = new CategoryDao();
            ProductDao dao = new ProductDao();
            List<Product> list = dao.findAll();
            List<Category> listC = categoryDao.findAllCategory();
            long numproduct = dao.countProduct();
            request.setAttribute("listP", list);
            request.setAttribute("listC", listC);
            request.setAttribute("numproduct", numproduct);
            request.getRequestDispatcher("product-management.jsp").forward(request, response);
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
