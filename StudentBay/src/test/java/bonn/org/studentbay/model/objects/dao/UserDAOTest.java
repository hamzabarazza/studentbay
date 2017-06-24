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
    
    private String username = "thisistheUserDAOTest";
    private String vorname = "itsjustATest";
    private String nachname = "nothingtoWorryAbout";
    private Date geburtstag = null;
    private String email = "thisisjustaemail@test.com";
    private String password = "passwordtest123";
    private Integer userID = null;
    
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
    
        try {
            RegistrierungsDAO.getInstance().registerUserDAO(username, vorname, nachname, geburtstag, email, password);
        } catch (RegisterFail ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        userID = UserDAO.getInstance().getIDFromUsername(username);
    
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
        UserDAO instance = null;
        User result = instance.getDataForUser(usernameTest);
        assertNotNull(result);
        assertNotNull(result.getEmail());
        assertNotNull(result.getUsername());
        assertNotNull(result.getNachname());
        assertEquals(vorname, result.getVorname());
        assertEquals(password, result.getPasswort());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getUsernameFromID method, of class UserDAO.
     */
    @Test
    public void testGetUsernameFromID() throws Exception {
        System.out.println("getUsernameFromID");
        Integer userIDTest = userID;
        UserDAO instance = null;
        String expResult = username;
        String result = instance.getUsernameFromID(userIDTest);
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
        UserDAO instance = null;
        String expResult = vorname;
        String result = instance.getVornameFromID(userIDTest);
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
        UserDAO instance = null;
        String expResult = nachname;
        String result = instance.getNachnameFromID(userIDTest);
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
        UserDAO instance = null;
        String expResult = email;
        String result = instance.getEmailFromID(userIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDFromUsername method, of class UserDAO.
     */
    @Test
    public void testGetIDFromUsername() {
        System.out.println("getIDFromUsername");
        String usernameTest = username;
        UserDAO instance = null;
        Integer expResult = userID;
        Integer result = instance.getIDFromUsername(usernameTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setUsernameFromID method, of class UserDAO.
     */
    @Test
    public void testSetUsernameFromID() throws Exception {
        System.out.println("setUsernameFromID");
        Integer userIDTest = userID;
        String neuUsername = "usernameNeufürUserDAOTest";
        UserDAO instance = null;
        boolean result = instance.setUsernameFromID(userIDTest, neuUsername);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setVornameFromID method, of class UserDAO.
     */
    @Test
    public void testSetVornameFromID() throws Exception {
        System.out.println("setVornameFromID");
        Integer userIDTest = userID;
        String neuVorname = "neuVornameFürUserDAOTest";
        UserDAO instance = null;
        boolean result = instance.setVornameFromID(userIDTest, neuVorname);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNachnameFromID method, of class UserDAO.
     */
    @Test
    public void testSetNachnameFromID() throws Exception {
        System.out.println("setNachnameFromID");
        Integer userIDTest = userID;
        String neuNachname = "neuNachnameFürUserDAOTest";
        UserDAO instance = null;
        boolean result = instance.setNachnameFromID(userIDTest, neuNachname);
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
        UserDAO instance = null;
        boolean result = instance.setEmailFromID(userIDTest, neuEmail);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPasswordFromID method, of class UserDAO.
     */
    @Test
    public void testSetPasswordFromID() throws Exception {
        System.out.println("setPasswordFromID");
        Integer userIDTest = userID;
        String neuPassword = "superneuespasswordfürDAOTest";
        UserDAO instance = null;
        boolean result = instance.setPasswordFromID(userIDTest, neuPassword);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPasswordFromID method, of class UserDAO.
     */
    @Test
    public void testGetPasswordFromID() throws Exception {
        System.out.println("getPasswordFromID");
        Integer userIDTest = userID;
        UserDAO instance = null;
        String expResult = password;
        String result = instance.getPasswordFromID(userIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteUserWithID method, of class UserDAO.
     */
    @Test
    public void testDeleteUserWithID() {
        System.out.println("deleteUserWithID");
        Integer userIDTest = userID;
        UserDAO instance = null;
        instance.deleteUserWithID(userIDTest);
        // TODO review the generated test code and remove the default call to fail.
        try {
            assertNull(UserDAO.getInstance().getVornameFromID(userIDTest));
            assertNull(UserDAO.getInstance().getEmailFromID(userIDTest));        
            assertNull(UserDAO.getInstance().getNachnameFromID(userIDTest));

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
