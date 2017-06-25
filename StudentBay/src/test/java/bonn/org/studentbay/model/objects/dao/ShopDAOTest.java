/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.model.objects.dto.Artikel;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
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
public class ShopDAOTest {
    
    private static final Integer userID =1;
    private static final String shopname = "superTollerNameFürDenShopDAOTest";
    private static final Boolean vorkasse = false;
    private static final Boolean nachnahme = false;
    private static final Boolean paypal = true;
    private static final Boolean rechnung = false;
    private static final Boolean kreditkarte = true;
    private static final Boolean lastschrift = true;
    private static Integer shopID;
    
    
    public ShopDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException, RegisterFail {
        
//        RegistrierungsDAO.registerUserDAO("username", "vorname", "nachname", new Date(2122), "email", "password");
        
        
        
        try {
            ShopDAO.getInstance().registerShopDAO(userID, shopname, vorkasse, nachnahme, paypal, rechnung, kreditkarte, lastschrift);
        } catch (RegisterFail ex) {
            Logger.getLogger(ShopDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        shopID = ShopDAO.getInstance().getShopIDWithUserID(userID);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    
//        ShopDAO.getInstance().deleteShopWithID(shopID);
//           UserDAO.deleteUserWithID(userID);
    }
    
    @Before
    public void setUp() {
    
    }
    
    @After
    public void tearDown() throws Exception {
    
    }
    
    /**
     * Test of getInstance method, of class ShopDAO.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ShopDAO result = ShopDAO.getInstance();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }

//    /**
//     * Test of getMeinShopDAO method, of class ShopDAO.
//     */
//    @Test
//    public void testGetMeinShopDAO() throws Exception {
//        System.out.println("getMeinShopDAO");
//        Integer user = null;
//        String expResult = "";
//        String result = ShopDAO.getMeinShopDAO(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of getArtikelShopDAO method, of class ShopDAO.
//     */
//    @Test
//    public void testGetArtikelShopDAO() {
//        System.out.println("getArtikelShopDAO");
//        Integer userID = null;
//        List<Artikel> expResult = null;
//        List<Artikel> result = ShopDAO.getArtikelShopDAO(userID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of registerShopDAO method, of class ShopDAO.
//     */
//    @Test
//    public void testRegisterShopDAO() throws Exception {
//        System.out.println("registerShopDAO");
//        Integer userIDTest = 4536747;
//        String shopnameTest = "anotherOneShopNameTest";
//        Boolean vorkasseTest = false;
//        Boolean nachnahmeTest = false;
//        Boolean paypalTest = false;
//        Boolean rechnungTest = false;
//        Boolean kreditkarteTest = false;
//        Boolean lastschriftTest = false;
//        ShopDAO.registerShopDAO(userID, shopname, vorkasseTest, nachnahme, paypal, rechnung, kreditkarte, lastschrift);
//        // TODO review the generated test code and remove the default call to fail.
//        assertEquals(shopname, ShopDAO.getInstance().getShopNameFromID(shopID));
//        assertNotNull(ShopDAO.getInstance().getShopNameFromID(shopID));
//        
//    }
//
    /**
     * Test of getShopNameFromID method, of class ShopDAO.
     */
    @Test
    public void testGetShopNameFromID() throws SQLException {
        System.out.println("getShopNameFromID" + shopID);
        Integer shopIDTest = shopID;
        String expResult = shopname;
        String result = ShopDAO.getShopNameFromID(shopIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
//
//    /**
//     * Test of setShopNameFromID method, of class ShopDAO.
//     */
//    @Test
//    public void testSetShopNameFromID() throws Exception {
//        System.out.println("setShopNameFromID");
//        Integer shopIDTest = shopID;
//        String neuShopName = "neuerMegaGuterShopName";
//        ShopDAO instance = null;
//        boolean result = instance.setShopNameFromID(shopID, neuShopName);
//        assertTrue(result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of deleteShopWithID method, of class ShopDAO.
//     */
//    @Test
//    public void testDeleteShopWithID() {
//        System.out.println("deleteShopWithID");
//        Integer shopIDTest = shopID;
//        ShopDAO instance = null;
//        instance.deleteShopWithID(shopID);
//        // TODO review the generated test code and remove the default call to fail.
//        assertNull(ShopDAO.getInstance().getShopNameFromID(shopIDTest));
//    }
//
    /**
     * Test of getShopIDWithUserID method, of class ShopDAO.
     */
    @Test
    public void testGetShopIDWithUserID() throws SQLException {
        System.out.println("getShopIDWithUserID");
        Integer userIDTest = userID;
        Integer expResult = shopID;
        Integer result = ShopDAO.getShopIDWithUserID(userIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
//    
}
