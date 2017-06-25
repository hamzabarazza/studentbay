/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

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
public class RegistrierungsDAOTest {
    
    private static String username = "hans";
    private static String vorname = "peter";
    private static String nachname = "lustig";
    private static String email = "peter@lustig.com";
    private static Date geburtstag = new Date(2323);
    private static String password = "peter123456";
    private static Integer userID;
    
    public RegistrierungsDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
         
        try {
            RegistrierungsDAO.getInstance().registerUserDAO(username,vorname,nachname,geburtstag,email,password);
        } catch (RegisterFail ex) {
            Logger.getLogger(RegistrierungsDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        userID = UserDAO.getInstance().getIDFromUsername(username); 
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    
        UserDAO.getInstance().deleteUserWithID(userID);
    
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of getInstance method, of class RegistrierungsDAO.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        RegistrierungsDAO result = RegistrierungsDAO.getInstance();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkUsernameExists method, of class RegistrierungsDAO.
     */
    @Test
    public void testCheckUsernameExists() throws SQLException {
        System.out.println("checkUsernameExists");
        String usernameFalse = "hans";
        String usernameTrue = "letsCheckIfThisUsernameExists";
        RegistrierungsDAO instance = null;
        boolean resultTrue = instance.checkUsernameExists(usernameTrue);
        boolean resultFalse = instance.checkUsernameExists(usernameFalse);
        assertFalse(resultFalse);
        assertTrue(resultTrue);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of checkEmailExists method, of class RegistrierungsDAO.
     */
    @Test
    public void testCheckEmailExists() throws SQLException {
        System.out.println("checkEmailExists");
        String emailFalse = "peter@lustig.com";
        String emailTrue = "checkIfthisEmailExists@what.com";
       
        boolean resultTrue = RegistrierungsDAO.checkEmailExists(emailTrue);
        boolean resultFalse = RegistrierungsDAO.checkEmailExists(emailFalse);
        assertFalse(resultFalse);
        assertTrue(resultTrue);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of registerUserDAO method, of class RegistrierungsDAO.
     */
    @Test
    public void testRegisterUserDAO() throws Exception {
        System.out.println("registerUserDAO");
        String usernameTest = "gustavo";
        String vornameTest = "gustavo";
        String nachnameTest = "frind";
        Date geburtstagTest = new Date(2323);
        String emailTest = "gustavo@fring.com";
        String passwordTest = "fring123456";
        String neuVorname = "neuVorname";
        String neuNachname = "neuNachname";
        String neuPassword = "password12345";
        
        // CREATE
        RegistrierungsDAO.registerUserDAO(usernameTest, vornameTest, nachnameTest, geburtstagTest, emailTest, passwordTest);
        
        // READ
        Integer userID2 = UserDAO.getInstance().getIDFromUsername(usernameTest);
        
        assertEquals(usernameTest, UserDAO.getInstance().getUsernameFromID(userID2));
        assertEquals(emailTest, UserDAO.getInstance().getEmailFromID(userID2));
        assertEquals(vornameTest, UserDAO.getInstance().getVornameFromID(userID2));
        assertEquals(nachnameTest, UserDAO.getInstance().getNachnameFromID(userID2));
        assertEquals(passwordTest, UserDAO.getInstance().getPasswordFromID(userID2));
        
        // UPDATE
        UserDAO.getInstance().setVornameFromID(userID2, neuVorname);
        UserDAO.getInstance().setNachnameFromID(userID2, neuNachname);
        UserDAO.getInstance().setPasswordFromID(userID2, neuPassword);
        assertEquals(neuVorname, UserDAO.getInstance().getVornameFromID(userID2));
        assertEquals(neuNachname, UserDAO.getInstance().getNachnameFromID(userID2));
        assertEquals(neuPassword, UserDAO.getInstance().getPasswordFromID(userID2));

        // DELETE
        UserDAO.getInstance().deleteUserWithID(userID2);
        assertNull(UserDAO.getInstance().getVornameFromID(userID2));
        assertNull(UserDAO.getInstance().getNachnameFromID(userID2));
        assertNull(UserDAO.getInstance().getPasswordFromID(userID2));
        assertNull(UserDAO.getInstance().getEmailFromID(userID2));
        assertNull(UserDAO.getInstance().getUsernameFromID(userID2));
        
        
    }
    
}
