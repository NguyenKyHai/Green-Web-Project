package laptrinh.com.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laptrinh.com.dao.CategoryDao;
import laptrinh.com.dao.ProductDao;
import laptrinh.com.model.Category;
import laptrinh.com.model.Product;

@WebServlet(name = "AddProduct", urlPatterns = {"/add-product"})
public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        long price = Long.parseLong(request.getParameter("price"));
        String image = request.getParameter("image");
        int categoryid = Integer.parseInt(request.getParameter("category"));
        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.findByCategoryId(categoryid);
        ProductDao dao = new ProductDao();
        Product p = new Product(name, price, image, category);
        dao.insert(p);
        response.sendRedirect("product-management");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
