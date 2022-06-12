package laptrinh.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import laptrinh.com.model.Users;
import laptrinh.com.util.JpaUtil;

public class UserDao {

    public List<Users> findAllUser() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u order by u.id", Users.class);
        return query.getResultList();
    }

    public Users findByUserId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Users user = em.find(Users.class, id);
        return user;
    }

    public boolean Login(String username, String password) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u Where u.username=:username "
                + "and u.password=:password", Users.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Users> list = query.getResultList();
        return !list.isEmpty();
    }

    public List<Users> findByUsername(String username) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Users> query = em.createNamedQuery("Users.findByUsername", Users.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

    public boolean CheckLoginExist(String username) {
        EntityManager em = JpaUtil.getEntityManager();

        TypedQuery<Users> query = em.createNamedQuery("Users.findByUsername", Users.class);
        query.setParameter("username", username);
        List<Users> list = query.getResultList();
        return !list.isEmpty();
    }
    
    public boolean CheckEmailExist(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Users> query = em.createNamedQuery("Users.findByEmail", Users.class);
        query.setParameter("email", email);
        List<Users> list = query.getResultList();
        return !list.isEmpty();
    }

    public long countUser() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery("SELECT count(u.id) FROM Users u", Long.class);
        return query.getSingleResult();
    }

    public void insert(Users user) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(user);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            em.close();
        }
    }

    public void update(Users user) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.merge(user);
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
            Users user = em.find(Users.class, id);
            if (user != null) {
                em.remove(user);
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
//   public static void main(String[] args) {
//        UserDao dao = new UserDao();
//        String email="";
//        boolean a=dao.CheckEmailExist(email);
//        System.out.println(a);
//   }
}
