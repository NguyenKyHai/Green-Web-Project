package laptrinh.com.controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laptrinh.com.dao.CategoryDao;
import laptrinh.com.dao.ProductDao;
import laptrinh.com.model.Category;
import laptrinh.com.model.Product;

@WebServlet(name = "EditProduct", urlPatterns = {"/edit-product"})
public class EditProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDao dao = new ProductDao();
        Product p = dao.findByProductId(id);
        request.setAttribute("product", p);
        request.getRequestDispatcher("product-management").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("productid"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        long price = Long.parseLong(request.getParameter("price"));
        int categoryid = Integer.parseInt(request.getParameter("category"));

        ProductDao dao = new ProductDao();
        CategoryDao categoryDao=new CategoryDao();
        Product p = dao.findByProductId(id);
        Category c=categoryDao.findByCategoryId(categoryid);
        List<Category> listC = categoryDao.findAllCategory();
        p.setName(name);
        p.setImage(image);
        p.setPrice(price);
        p.setCategoryid(c);
        dao.update(p);
        request.setAttribute("product", p);
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("product-management").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
