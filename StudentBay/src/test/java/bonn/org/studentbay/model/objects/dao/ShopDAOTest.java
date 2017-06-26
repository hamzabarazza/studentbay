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
    
    private static  Integer userID;
    private static  String shopname = "superTollerNameFürDenShopDAOTest";
    private static  Boolean vorkasse = false;
    private static  Boolean nachnahme = false;
    private static  Boolean paypal = true;
    private static  Boolean rechnung = false;
    private static  Boolean kreditkarte = true;
    private static  Boolean lastschrift = true;
    private static Integer shopID;
    
      private static  Integer userID2;
    private static  String shopname2 = "superTollerNameFürDenShopDAOTest2";
    private static  Boolean vorkasse2 = false;
    private static  Boolean nachnahme2 = false;
    private static  Boolean paypal2 = true;
    private static  Boolean rechnung2 = false;
    private static  Boolean kreditkarte2 = true;
    private static  Boolean lastschrift2 = true;
    private static Integer shopID2;
    
      private static  Integer userID3;
    private static  String shopname3 = "superTollerNameFürDenShopDAOTest3";
    private static  Boolean vorkasse3 = false;
    private static  Boolean nachnahme3 = false;
    private static  Boolean paypal3 = true;
    private static  Boolean rechnung3 = false;
    private static  Boolean kreditkarte3 = true;
    private static  Boolean lastschrift3 = true;
    private static Integer shopID3;
    
    
    public ShopDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException, RegisterFail {
        
        RegistrierungsDAO.registerUserDAO("username", "vorname", "nachname", new Date(2122), "email", "password");
        userID = UserDAO.getIDFromUsername("username");
        
        
        try {
            ShopDAO.getInstance().registerShopDAO(userID, shopname, vorkasse, nachnahme, paypal, rechnung, kreditkarte, lastschrift);
        } catch (RegisterFail ex) {
            Logger.getLogger(ShopDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        shopID = ShopDAO.getInstance().getShopIDbyName(shopname);
      
        ShopDAO.setMeinShopDAO(userID, shopID);
        
        
        
        
          RegistrierungsDAO.registerUserDAO("username2", "vorname2", "nachname2", new Date(2122), "email2", "password2");
        userID2 = UserDAO.getIDFromUsername("username2");
        
        
        try {
            ShopDAO.getInstance().registerShopDAO(userID2, shopname2, vorkasse2, nachnahme2, paypal2, rechnung2, kreditkarte2, lastschrift2);
        } catch (RegisterFail ex) {
            Logger.getLogger(ShopDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        shopID2 = ShopDAO.getInstance().getShopIDbyName(shopname2);
      
        ShopDAO.setMeinShopDAO(userID2, shopID2);
        
        
        
          RegistrierungsDAO.registerUserDAO("username3", "vorname3", "nachname3", new Date(2122), "email3", "password3");
        userID3 = UserDAO.getIDFromUsername("username3");
        
        
        try {
            ShopDAO.getInstance().registerShopDAO(userID3, shopname3, vorkasse3, nachnahme3, paypal3, rechnung3, kreditkarte3, lastschrift3);
        } catch (RegisterFail ex) {
            Logger.getLogger(ShopDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        shopID3 = ShopDAO.getInstance().getShopIDbyName(shopname3);
      
        ShopDAO.setMeinShopDAO(userID3, shopID3);
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        UserDAO.deleteUserWithID(userID);
        ShopDAO.getInstance().deleteShopWithID(shopID);
        
        UserDAO.deleteUserWithID(userID2);
        ShopDAO.getInstance().deleteShopWithID(shopID2);
        
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

    /**
     * Test of getMeinShopDAO method, of class ShopDAO.
     */
    @Test
    public void testGetMeinShopDAO() throws Exception {
        System.out.println("getMeinShopDAO");
        Integer user = userID;
        String expResult = "superTollerNameFürDenShopDAOTest";
        String result = ShopDAO.getMeinShopDAO(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getArtikelShopDAO method, of class ShopDAO.
     */
    @Test
    public void testGetArtikelShopDAO() {
        System.out.println("getArtikelShopDAO");
        List<Artikel> expResult = null;
        List<Artikel> Result = ShopDAO.getArtikelShopDAO(userID);
        
        Artikel result = null;
        assertNull(result);
        
        // TODO review the generated test code and remove the default call to fail.
    }

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

    /**
     * Test of setShopNameFromID method, of class ShopDAO.
     */
    @Test
    public void testSetShopNameFromID() throws Exception {
        System.out.println("setShopNameFromID");
        String neuShopName = "neuerMegaGuterShopName";
        boolean result = ShopDAO.setShopNameFromID(shopID2, neuShopName);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteShopWithID method, of class ShopDAO.
     */
    @Test
    public void testDeleteShopWithID() throws SQLException {
        System.out.println("deleteShopWithID");
        UserDAO.deleteUserWithID(userID3);
        Integer shopIDTest = shopID3;
        ShopDAO instance = null;
        instance.deleteShopWithID(shopID3);
        // TODO review the generated test code and remove the default call to fail.
        assertNull(ShopDAO.getInstance().getShopNameFromID(shopIDTest));
    }

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
    
}
