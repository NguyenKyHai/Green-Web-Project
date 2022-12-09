/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinh.com.dao;

import java.util.List;
import laptrinh.com.model.Users;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Admin
 */
public class UserDaoNGTest {
    
    public UserDaoNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of findAllUser method, of class UserDao.
     */
     @Test
    public void testLogin() {
        System.out.println("Login");
        String username = "Khanh";
        String password = "19110227";
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.Login(username, password);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }
     @Test
    public void testCheckLoginExist() {
        System.out.println("CheckLoginExist");
        String username = "Khanh";
        UserDao instance = new UserDao();
        boolean expResult = true;
        boolean result = instance.CheckLoginExist(username);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
    }
     @Test
    public void testCheckEmailExist() {
        System.out.println("CheckEmailExist");
        String email = "abc@gmail.com";
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.CheckEmailExist(email);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
      
    }
}
