package laptrinh.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import laptrinh.com.dao.CartItemDao;
import laptrinh.com.dao.ProductDao;
import laptrinh.com.model.Cartitem;
import laptrinh.com.model.Product;

@WebServlet(name = "AddToCart", urlPatterns = {"/addcart"})
public class AddToCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String q = request.getParameter("quantity");
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity;
        if (q == null) {
            quantity = 1;
        } else {
            quantity = Integer.parseInt(q);
        }
        ProductDao dao = new ProductDao();
        Product product = dao.findByProductId(id);
        if (product != null) {
            HttpSession session = request.getSession();
            List<Cartitem> list = new ArrayList<>();
            if (session.getAttribute("order") == null) {
                Cartitem cartitem = new Cartitem();
                cartitem.setProductid(product);
                cartitem.setQuantity(quantity);
                list.add(cartitem);
                session.setAttribute("order", list);
            } else {
                list = (List) session.getAttribute("order");
                Cartitem cartitem = new Cartitem();
                Boolean check = false;
                for (Cartitem c : list) {
                    if (Objects.equals(c.getProductid().getProductid(), product.getProductid())) {
                        c.setQuantity(c.getQuantity() + quantity);
                        check = true;
                    }
                }
                if (check == false) {
                    cartitem.setProductid(product);
                    cartitem.setQuantity(quantity);
                    list.add(cartitem);
                }
                session.setAttribute("order", list);
            }
            CartItemDao itemdao = new CartItemDao();
            int qcart = list.size();
            long total = itemdao.getTotal(list);
            long sum = itemdao.getSum(total);
            session.setAttribute("qcart", qcart);
            session.setAttribute("sum", sum);
            if(q==null){
            response.sendRedirect("home");
            }
            else {
                response.sendRedirect("cart");
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
