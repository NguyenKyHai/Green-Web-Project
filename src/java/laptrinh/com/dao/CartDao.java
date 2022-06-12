package laptrinh.com.dao;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import laptrinh.com.model.Cart;
import laptrinh.com.model.Cartitem;
import java.util.Date;
import laptrinh.com.util.JpaUtil;

public class CartDao {

    public List<Cart> findAllCart() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Cart> query = em.createQuery("SELECT c FROM Cart c", Cart.class);
        return query.getResultList();
    }

    public Cart findByCartId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Cart cart = em.find(Cart.class, id);
        return cart;
    }

    public void insert(Cart cart) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(cart);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            em.close();
        }
    }

    public void update(Cart cart) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.merge(cart);
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
            Cart cart = em.find(Cart.class, id);
            if (cart != null) {
                em.remove(cart);
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

    public List<Cart> findStatus(int status) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Cart> query = em.createQuery("SELECT c FROM Cart c where c.status=:status", Cart.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Cart> countCartByDate(Date buydate) {

        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Cart> query = em.createNamedQuery("Cart.findByBuydate", Cart.class);
        query.setParameter("buydate", buydate);
        return query.getResultList();
    }

//    public static void main(String[] args) {
//        CartDao dao = new CartDao();
//        java.util.Date date = new java.util.Date();
//    }
}
