
package laptrinh.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import laptrinh.com.dao.ProductDao;
import laptrinh.com.model.Cartitem;
import laptrinh.com.model.Product;

@WebServlet(name = "RemoveCart", urlPatterns = {"/remove"})
public class RemoveCart extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDao dao = new ProductDao();
        Product product = dao.findByProductId(id);
        HttpSession session = request.getSession();
        List<Cartitem> list = (List) session.getAttribute("order");
        int qcart=(int) session.getAttribute("qcart");
        for (int i=0;i<list.size();i++) {
            if (Objects.equals(product.getProductid(), list.get(i).getProductid().getProductid())) {
                     list.remove(i);
            }
        }
        qcart=list.size();
        session.setAttribute("qcart", qcart);
        session.setAttribute("order", list);
        response.sendRedirect("cart");
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
