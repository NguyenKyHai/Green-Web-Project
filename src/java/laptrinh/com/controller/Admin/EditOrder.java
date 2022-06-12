package laptrinh.com.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laptrinh.com.dao.CartDao;
import laptrinh.com.dao.CartItemDao;
import laptrinh.com.model.Cart;
import laptrinh.com.model.Cartitem;

@WebServlet(name = "EditOrder", urlPatterns = {"/edit-order"})
public class EditOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int itemid = Integer.parseInt(request.getParameter("itemid"));
        //int cartid = Integer.parseInt(request.getParameter("cartid"));
        CartItemDao dao = new CartItemDao();
        Cartitem item = dao.findByCartItemId(itemid);
        request.setAttribute("item", item);
        request.getRequestDispatcher("order-management").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int cartid = Integer.parseInt(request.getParameter("cartid"));
        int status = Integer.parseInt(request.getParameter("tinhtrang"));
        CartDao dao=new CartDao();
        Cart cart=dao.findByCartId(cartid);
        cart.setStatus(status);
        dao.update(cart);
        response.sendRedirect("order-management");
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
