package laptrinh.com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import laptrinh.com.model.Cart;
import laptrinh.com.model.Cartitem;
import laptrinh.com.model.Product;
import laptrinh.com.util.JpaUtil;

public class CartItemDao {

    private long total;

    public long getTotal(List<Cartitem> list) {
        list.forEach(c -> {
            total = total + c.getQuantity() * c.getProductid().getPrice();
        });
        return total;
    }

    public long getVat(long total) {
        return (long) (total * 0.02);
    }

    public long getSum(long total) {
        return (long) (total * 1.02);
    }

    public List<Cartitem> findAllCartItem() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Cartitem> query = em.createQuery("SELECT c FROM Cartitem c", Cartitem.class);
        return query.getResultList();
    }

    public Cartitem findByCartItemId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Cartitem item = em.find(Cartitem.class, id);
        return item;
    }

    public long countCartItem() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery("SELECT count(c.id) FROM Cartitem c", Long.class);
        return query.getSingleResult();
    }

    public void insert(Cartitem item) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(item);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            em.close();
        }
    }

    public void update(Cartitem item) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.merge(item);
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
            Cartitem item = em.find(Cartitem.class, id);
            if (item != null) {
                em.remove(item);
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

    public String InvoiceInfo(List<Cartitem> list) {
        String info = "";
        info = list.stream().map(c -> c.toString() + "\n").reduce(info, String::concat);
        return info;
    }

    public List<Cartitem> findStatus(int status) {
        EntityManager em = JpaUtil.getEntityManager();

        TypedQuery<Cartitem> query = em.createQuery("SELECT c FROM Cartitem c where c.cartid.status=:status", Cartitem.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public long countCartByDate(Date buydate) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery("SELECT count(c.cartid) FROM Cartitem c where c.cartid.buydate=:buydate", Long.class);
        query.setParameter("buydate", buydate);
        return query.getSingleResult();
    }

    public List<Cartitem> findCartByDate(Date buydate) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Cartitem> query = em.createQuery("SELECT c FROM Cartitem c where c.cartid.buydate=:buydate", Cartitem.class);
        query.setParameter("buydate", buydate);
        return query.getResultList();
    }

    public long countCartByWeek(Date fromdate, Date todate) {
        //String fdate="04-12-2021";
        //String tdate="08-12-2021";
        // SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");
        // Date fromdate=df.parse(fdate);
        // Date todate=df.parse(tdate);
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery("SELECT count(c.cartid) FROM Cartitem c where c.cartid.buydate between :fromdate and :todate", Long.class);
        query.setParameter("fromdate", fromdate);
        query.setParameter("todate", todate);
        return query.getSingleResult();
    }

    public List<Cartitem> findCartByWeek(Date fromdate, Date todate) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Cartitem> query = em.createQuery("SELECT c FROM Cartitem c where c.cartid.buydate between :fromdate and :todate", Cartitem.class);
        query.setParameter("fromdate", fromdate);
        query.setParameter("todate", todate);
        return query.getResultList();
    }

    public long TotalCartByDate(Date buydate) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery("SELECT sum(c.productid.price) FROM Cartitem c where c.cartid.buydate=:buydate", Long.class);
        query.setParameter("buydate", buydate);
        return query.getSingleResult();
    }

    public long countUnsoldProduct() {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createNativeQuery("Select count(*) from Product p  where productid not in "
                + "(select c.productid from Cartitem c)");
        long count = (long) query.getSingleResult();
        return count;
    }

    public List<Product> ProductUnsold() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Product> query = (TypedQuery<Product>) em.createNativeQuery("Select * from Product where productid not in "
                + "(select productid from Cartitem) order by productid ", Product.class);
        return query.getResultList();
    }

    public static void main(String[] args) throws ParseException {
       CartItemDao itemdao = new CartItemDao();
       CartDao dao=new CartDao();
       ProductDao pdao=new ProductDao();
       Product p=pdao.findByProductId(8);
       Cart cart=dao.findByCartId(28);
       Cartitem item=new Cartitem(1,cart,p);
       itemdao.insert(item);
   }
}
