package laptrinh.com.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import laptrinh.com.model.Category;
import laptrinh.com.util.JpaUtil;

public class CategoryDao {

    public List<Category> findAllCategory() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Category> query = em.createNamedQuery("Category.findAll", Category.class);
        return query.getResultList();
    }

    public Category findByCategoryId(int cid) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Category> query = em.createNamedQuery("Category.findByCategoryid", Category.class);
        query.setParameter("categoryid", cid);
        return query.getSingleResult();
    }
//
//    public static void main(String[] args) {
//        CategoryDao dao=new CategoryDao();
//        List<Category> list=dao.findAllCategory();
//        list.forEach(c -> {
//            System.out.println(c.toString());
//         });
//    }
}
