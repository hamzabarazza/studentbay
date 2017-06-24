/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.process.control.exceptions.RegisterFail;
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
    
    private String username = "hans";
    private String vorname = "peter";
    private String nachname = "lustig";
    private String email = "peter@lustig.com";
    private Date geburtstag = null;
    private String password = "peter123456";
    private Integer userID = UserDAO.getInstance().getIDFromUsername(username);
    
    public RegistrierungsDAOTest() {
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
            RegistrierungsDAO.getInstance().registerUserDAO(username,vorname,nachname,geburtstag,email,password);
        } catch (RegisterFail ex) {
            Logger.getLogger(RegistrierungsDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @After
    public void tearDown() {
        UserDAO.getInstance().deleteUserWithID(userID);
        
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
    public void testCheckUsernameExists() {
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
    public void testCheckEmailExists() {
        System.out.println("checkEmailExists");
        String emailFalse = "peter@lustig.com";
        String emailTrue = "checkIfthisEmailExists@what.com";
        RegistrierungsDAO instance = null;
        boolean resultTrue = instance.checkEmailExists(emailTrue);
        boolean resultFalse = instance.checkEmailExists(emailFalse);
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
        Date geburtstagTest = null;
        String emailTest = "gustavo@fring.com";
        String passwordTest = "fring123456";
        String neuVorname = "neuVorname";
        String neuNachname = "neuNachname";
        String neuPassword = "password12345";
        
        // CREATE
        RegistrierungsDAO.registerUserDAO(usernameTest, vornameTest, nachnameTest, geburtstagTest, emailTest, passwordTest);
        
        // READ
        Integer userID = UserDAO.getInstance().getIDFromUsername(username);
        
        assertEquals(username, UserDAO.getInstance().getUsernameFromID(userID));
        assertEquals(email, UserDAO.getInstance().getEmailFromID(userID));
        assertEquals(vorname, UserDAO.getInstance().getVornameFromID(userID));
        assertEquals(nachname, UserDAO.getInstance().getNachnameFromID(userID));
        assertEquals(password, UserDAO.getInstance().getPasswordFromID(userID));
        
        // UPDATE
        UserDAO.getInstance().setVornameFromID(userID, neuVorname);
        UserDAO.getInstance().setNachnameFromID(userID, neuNachname);
        UserDAO.getInstance().setPasswordFromID(userID, neuPassword);
        assertEquals(vorname, UserDAO.getInstance().getVornameFromID(userID));
        assertEquals(nachname, UserDAO.getInstance().getNachnameFromID(userID));
        assertEquals(password, UserDAO.getInstance().getPasswordFromID(userID));

        // DELETE
        UserDAO.getInstance().deleteUserWithID(userID);
        assertNull(UserDAO.getInstance().getVornameFromID(userID));
        assertNull(UserDAO.getInstance().getNachnameFromID(userID));
        assertNull(UserDAO.getInstance().getPasswordFromID(userID));
        assertNull(UserDAO.getInstance().getEmailFromID(userID));
        assertNull(UserDAO.getInstance().getUsernameFromID(userID));
        
        
    }
    
}
