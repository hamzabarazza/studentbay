/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.model.objects.dto.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jens
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    
        User user = new User();
        private String username = "hans";
        private String vorname = "Hans";
        private String nachname = "Peter";
        
        
    }    
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class UserDAO.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        UserDAO expResult = null;
        UserDAO result = UserDAO.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDataForUser method, of class UserDAO.
     */
    @Test
    public void testGetDataForUser() throws Exception {
        System.out.println("getDataForUser");
        String username = "";
        UserDAO instance = null;
        User expResult = null;
        User result = instance.getDataForUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getUsernameFromID method, of class UserDAO.
     */
    @Test
    public void testGetUsernameFromID() throws Exception {
        System.out.println("getUsernameFromID");
        Integer userID = null;
        UserDAO instance = null;
        String expResult = "";
        String result = instance.getUsernameFromID(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getVornameFromID method, of class UserDAO.
     */
    @Test
    public void testGetVornameFromID() throws Exception {
        System.out.println("getVornameFromID");
        Integer userID = null;
        UserDAO instance = null;
        String expResult = "";
        String result = instance.getVornameFromID(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNachnameFromID method, of class UserDAO.
     */
    @Test
    public void testGetNachnameFromID() throws Exception {
        System.out.println("getNachnameFromID");
        Integer userID = null;
        UserDAO instance = null;
        String expResult = "";
        String result = instance.getNachnameFromID(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmailFromID method, of class UserDAO.
     */
    @Test
    public void testGetEmailFromID() throws Exception {
        System.out.println("getEmailFromID");
        Integer userID = null;
        UserDAO instance = null;
        String expResult = "";
        String result = instance.getEmailFromID(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setUsernameFromID method, of class UserDAO.
     */
    @Test
    public void testSetUsernameFromID() throws Exception {
        System.out.println("setUsernameFromID");
        Integer userID = null;
        String neuUsername = "";
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.setUsernameFromID(userID, neuUsername);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setVornameFromID method, of class UserDAO.
     */
    @Test
    public void testSetVornameFromID() throws Exception {
        System.out.println("setVornameFromID");
        Integer userID = null;
        String neuVorname = "";
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.setVornameFromID(userID, neuVorname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNachnameFromID method, of class UserDAO.
     */
    @Test
    public void testSetNachnameFromID() throws Exception {
        System.out.println("setNachnameFromID");
        Integer userID = null;
        String neuNachname = "";
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.setNachnameFromID(userID, neuNachname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmailFromID method, of class UserDAO.
     */
    @Test
    public void testSetEmailFromID() throws Exception {
        System.out.println("setEmailFromID");
        Integer userID = null;
        String neuEmail = "";
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.setEmailFromID(userID, neuEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteUserWithID method, of class UserDAO.
     */
    @Test
    public void testDeleteUserWithID() {
        System.out.println("deleteUserWithID");
        Integer userID = null;
        UserDAO instance = null;
        instance.deleteUserWithID(userID);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
