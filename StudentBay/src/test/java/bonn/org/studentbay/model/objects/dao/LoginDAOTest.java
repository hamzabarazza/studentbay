/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import bonn.org.studentbay.services.util.Roles;
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
public class LoginDAOTest {
    
    private String username = "thisisatest";
    private String vorname = "gustavtest";
    private String nachname = "hanspetertest";
    private Date geburtstag = null;
    private String email = "hanspeter@gustavtest.com";
    private String password = "hanspeter123";
    private Integer userID = null;
    
    
    public LoginDAOTest() {
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
            Logger.getLogger(LoginDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        userID = UserDAO.getInstance().getIDFromUsername(username);
        
    }
    
    @After
    public void tearDown() {
    
        UserDAO.getInstance().deleteUserWithID(userID);
        
    }

    /**
     * Test of getInstance method, of class LoginDAO.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        LoginDAO result = LoginDAO.getInstance();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkAuthenticatonDAO method, of class LoginDAO.
     */
    @Test
    public void testCheckAuthenticatonDAO() throws Exception {
        System.out.println("checkAuthenticatonDAO");
        String login = username;
        String passwordTest = password;
        LoginDAO.checkAuthenticatonDAO(login, passwordTest);
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(Roles.CURRENT_USER);
    }
    
}
