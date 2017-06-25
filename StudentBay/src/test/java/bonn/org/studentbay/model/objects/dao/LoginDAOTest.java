/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
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
public class LoginDAOTest {
    
    private static String username = "thisisatest";
    private static String vorname = "gustavtest";
    private static String nachname = "hanspetertest";
    private static Date geburtstag = new Date(2324);
    private static String email = "hanspeter@gustavtest.com";
    private static String password = "hanspeter123";
    private static Integer userID = null;
    
    
    public LoginDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
    
        try {
            RegistrierungsDAO.getInstance().registerUserDAO(username, vorname, nachname, geburtstag, email, password);
        } catch (RegisterFail ex) {
            Logger.getLogger(LoginDAOTest.class.getName()).log(Level.SEVERE, null, ex);
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
     * @throws java.lang.Exception
     */
    @Test
    public void testCheckAuthenticatonDAO() throws Exception {
        System.out.println("checkAuthenticatonDAO");
        String login = username;
        String passwordTest = password;
        User result = LoginDAO.checkAuthenticatonDAO(login, passwordTest);
       
        // TODO review the generated test code and remove the default call to fail.
      
        assertNotNull(result);
    }
    
}
