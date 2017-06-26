/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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


// *********** DER TEST SOLLTE FERTIG SEIN **********
public class UserDAOTest {
    
    private static String username = "thisistheUserDAOTest";
    private static String vorname = "itsjustATest";
    private static String nachname = "nothingtoWorryAbout";
    private static Date geburtstag = new Date(232);
    private static String email = "thisisjustaemail@test.com";
    private static String password = "passwordtest123";
    private static Integer userID = null;
    
     private static String username2 = "thisistheUserDAOTest2";
    private static String vorname2 = "itsjustATest2";
    private static String nachname2 = "nothingtoWorryAbout2";
    private static Date geburtstag2 = new Date(232);
    private static String email2 = "thisisjustaemail@test.com2";
    private static String password2 = "passwordtest12322";
    private static Integer userID2 = null;
    
    
    private static String username3 = "thisistheUserDAOTest3";
    private static String vorname3 = "itsjustATest3";
    private static String nachname3 = "nothingtoWorryAbout3";
    private static Date geburtstag3 = new Date(232);
    private static String email3 = "thisisjustaemail@test.com3";
    private static String password3 = "passwordtest12333";
    private static Integer userID3 = null;
    
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
    
        try {
            RegistrierungsDAO.getInstance().registerUserDAO(username, vorname, nachname, geburtstag, email, password);
        } catch (RegisterFail ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        userID = UserDAO.getInstance().getIDFromUsername(username);
        
        
        try {
            RegistrierungsDAO.getInstance().registerUserDAO(username2, vorname2, nachname2, geburtstag2, email2, password2);
        } catch (RegisterFail ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        userID2 = UserDAO.getInstance().getIDFromUsername(username2);
  
    }
    
    @AfterClass
    public static void tearDownClass() {
    
        UserDAO.getInstance().deleteUserWithID(userID);
      UserDAO.getInstance().deleteUserWithID(userID2);
    }
    
    @Before
    public void setUp() {
    
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
        UserDAO result = UserDAO.getInstance();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDataForUser method, of class UserDAO.
     */
    @Test
    public void testGetDataForUser() throws Exception {
        System.out.println("getDataForUser");
        String usernameTest = username;
        User result = UserDAO.getDataForUser(usernameTest);
        assertNotNull(result);
        assertNotNull(result.getEmail());
        assertNotNull(result.getUsername());
        assertNotNull(result.getNachname());
        assertEquals(vorname, result.getVorname());
        assertEquals(password, result.getPasswort());
//         TODO review the generated test code and remove the default call to fail.
    }
//
    /**
     * Test of getUsernameFromID method, of class UserDAO.
     */
    @Test
    public void testGetUsernameFromID() throws Exception {
        System.out.println("getUsernameFromID");
        Integer userIDTest = userID;
        String expResult = username;
        String result = UserDAO.getUsernameFromID(userIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getVornameFromID method, of class UserDAO.
     */
    @Test
    public void testGetVornameFromID() throws Exception {
        System.out.println("getVornameFromID");
        Integer userIDTest = userID;
        String expResult = vorname;
        String result = UserDAO.getVornameFromID(userIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNachnameFromID method, of class UserDAO.
     */
    @Test
    public void testGetNachnameFromID() throws Exception {
        System.out.println("getNachnameFromID");
        Integer userIDTest = userID;
        String expResult = nachname;
        String result = UserDAO.getNachnameFromID(userIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmailFromID method, of class UserDAO.
     */
    @Test
    public void testGetEmailFromID() throws Exception {
        System.out.println("getEmailFromID");
        Integer userIDTest = userID;
        String expResult = email;
        String result = UserDAO.getEmailFromID(userIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDFromUsername method, of class UserDAO.
     */
    @Test
    public void testGetIDFromUsername() throws SQLException {
        System.out.println("getIDFromUsername");
        String usernameTest = username;
        Integer expResult = userID;
        Integer result = UserDAO.getIDFromUsername(usernameTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

        /**
     * Test of getPasswordFromID method, of class UserDAO.
     */
    @Test
    public void testGetPasswordFromID() throws Exception {
        System.out.println("getPasswordFromID");
        Integer userIDTest = userID;
        String expResult = password;
        String result = UserDAO.getPasswordFromID(userIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setUsernameFromID method, of class UserDAO.
     */
    @Test
    public void testSetUsernameFromID() throws Exception {
        System.out.println("setUsernameFromID");
        Integer userIDTest = userID2;
        String neuUsername = "usernameNeufürUserDAOTest";
        boolean result = UserDAO.setUsernameFromID(userIDTest, neuUsername);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setVornameFromID method, of class UserDAO.
     */
    @Test
    public void testSetVornameFromID() throws Exception {
        System.out.println("setVornameFromID");
        Integer userIDTest = userID2;
        String neuVorname = "neuVornameFürUserDAOTest";
        boolean result = UserDAO.setVornameFromID(userIDTest, neuVorname);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNachnameFromID method, of class UserDAO.
     */
    @Test
    public void testSetNachnameFromID() throws Exception {
        System.out.println("setNachnameFromID");
        Integer userIDTest = userID2;
        String neuNachname = "neuNachnameFürUserDAOTest";
        boolean result = UserDAO.setNachnameFromID(userIDTest, neuNachname);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmailFromID method, of class UserDAO.
     */
    @Test
    public void testSetEmailFromID() throws Exception {
        System.out.println("setEmailFromID");
        Integer userIDTest = userID;
        String neuEmail = "emailTest@UserDAO.com";
        boolean result = UserDAO.setEmailFromID(userIDTest, neuEmail);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPasswordFromID method, of class UserDAO.
     */
    @Test
    public void testSetPasswordFromID() throws Exception {
        System.out.println("setPasswordFromID");
        Integer userIDTest = userID2;
        String neuPassword = "superneuespasswordfürDAOTest";
        boolean result = UserDAO.setPasswordFromID(userIDTest, neuPassword);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of deleteUserWithID method, of class UserDAO.
     */
    @Test
    public void testDeleteUserWithID() throws SQLException {
        System.out.println("deleteUserWithID");
        Integer userIDTest = userID3;
        UserDAO.deleteUserWithID(userIDTest);
        // TODO review the generated test code and remove the default call to fail.
            assertNull(UserDAO.getInstance().getVornameFromID(userIDTest));
            assertNull(UserDAO.getInstance().getEmailFromID(userIDTest));        
            assertNull(UserDAO.getInstance().getNachnameFromID(userIDTest));
    }
    
}
