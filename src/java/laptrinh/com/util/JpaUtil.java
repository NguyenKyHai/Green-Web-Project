
package laptrinh.com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
     public static EntityManager getEntityManager(){
         EntityManagerFactory factory= Persistence.createEntityManagerFactory("WebProjectPU");
         return factory.createEntityManager();
     }
}
