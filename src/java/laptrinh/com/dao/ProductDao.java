package laptrinh.com.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import laptrinh.com.model.Product;
import laptrinh.com.util.JpaUtil;

public class ProductDao {

    public List<Product> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p order by p.productid", Product.class);
        return query.getResultList();
    }

    public Product findByProductId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Product> query = em.createNamedQuery("Product.findByProductid", Product.class);
        query.setParameter("productid", id);
        Product p = null;
        try {
            p = query.getSingleResult();
        } catch (NoResultException e) {

        }
        return p;
    }

    public List<Product> findByCategoryId(int c) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery query;
        query = em.createQuery("SELECT p FROM Product p Where p.categoryid.categoryid=:c", Product.class);
        query.setParameter("c", c);
        return query.getResultList();
    }

    public List<Product> searchByProductName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p Where lower(p.name) like lower(:name)", Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public long countProduct() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery("SELECT count(p.productid) FROM Product p", Long.class);
        return query.getSingleResult();
    }

    public List<Product> getNext12(int num) throws SQLException {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p order by p.productid", Product.class);
        List<Product> list = query.setMaxResults(12).setFirstResult((num - 1) * 12).getResultList();
        return list;
    }

    public List<Product> getRandom12() throws SQLException {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Product> query = (TypedQuery<Product>) em.createNativeQuery("SELECT * FROM Product ORDER BY random () limit 12", Product.class);
        List<Product> list = query.getResultList();
        return list;
    }

    public void insert(Product p) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(p);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            em.close();
        }
    }

    public void update(Product p) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.merge(p);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            Product p = em.find(Product.class, id);
            if (p != null) {
                em.remove(p);
            } else {
                throw new Exception("User can not found");
            }
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            em.close();
        }
    }

    
//    public static void main(String[] args) throws SQLException {
//        ProductDao dao = new ProductDao();
//        Product p = dao.findByProductId(8);
//               System.out.println(p.toString());
//    }
}
