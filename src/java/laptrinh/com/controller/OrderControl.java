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
import laptrinh.com.dao.CartDao;
import laptrinh.com.dao.CartItemDao;
import laptrinh.com.model.Cart;
import laptrinh.com.model.Cartitem;
import laptrinh.com.model.Users;
import laptrinh.com.service.JavaMail;

@WebServlet(name = "OrderControl", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {

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
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String sodienthoai = request.getParameter("sodienthoai");
        String info = "Ho ten: " + username + "\nDia chi: " + address + "\nSDT: " + sodienthoai + "\n";

        HttpSession session = request.getSession();
        int qcart = (int) session.getAttribute("qcart");
        List<Cartitem> list = new ArrayList<>();
        Users u = new Users();
        CartDao dao = new CartDao();
        CartItemDao itemdao = new CartItemDao();
        java.util.Date date = new java.util.Date();

        Object obj = session.getAttribute("order");
        if (obj == null) {
            request.setAttribute("message", "Giỏ hàng đang rỗng. Vui lòng thêm sản phẩm vào giỏ hàng");
        } else {
            list = (List) session.getAttribute("order");
            u = (Users) session.getAttribute("usersession");
            Cart cart = new Cart(date, info, 0, u);
            dao.insert(cart);
            for (Cartitem item : list) {
                Cartitem cartitem = new Cartitem(item.getQuantity(), cart, item.getProductid());
                itemdao.insert(cartitem);
                info += cartitem.toString() + "\n";
            }

            long total = itemdao.getTotal(list);
            long sum = itemdao.getSum(total);
            String subject = "Hoa don tu GreenMarket";
            String text = "Chan thanh cam on quy khach da mua hang!"
                    + "\nThong tin chi tiet cua quy khach ve don hang:\n" + info
                    + "Tong tien: " + Long.toString(sum)
                    + "\nChung toi se lien he quy khach trong thoi gian som nhat";
            JavaMail.sendMail(u.getEmail(), subject, text);
            session.removeAttribute("order");
            session.removeAttribute("sum");
            session.removeAttribute("qcart");
            request.getRequestDispatcher("home").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
