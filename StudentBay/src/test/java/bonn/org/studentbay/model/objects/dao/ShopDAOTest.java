/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.model.objects.dto.Artikel;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
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
    
    private Integer userID = 9654694;
    private String shopname = "superTollerNameFürDenShopDAOTest";
    private Boolean vorkasse = false;
    private Boolean nachnahme = false;
    private Boolean paypal = true;
    private Boolean rechnung = false;
    private Boolean kreditkarte = true;
    private Boolean lastschrift = true;
    private Integer shopID = null;
    
    
    public ShopDAOTest() {
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
            ShopDAO.getInstance().registerShopDAO(userID, shopname, vorkasse, nachnahme, paypal, rechnung, kreditkarte, lastschrift);
        } catch (RegisterFail ex) {
            Logger.getLogger(ShopDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        shopID = ShopDAO.getInstance().getShopIDWithUserID(userID);
    }
    
    @After
    public void tearDown() throws Exception {
    
        ShopDAO.getInstance().deleteShopWithID(shopID);
    
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
        Integer user = null;
        String expResult = "";
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
        Integer userID = null;
        List<Artikel> expResult = null;
        List<Artikel> result = ShopDAO.getArtikelShopDAO(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of registerShopDAO method, of class ShopDAO.
     */
    @Test
    public void testRegisterShopDAO() throws Exception {
        System.out.println("registerShopDAO");
        Integer userID = 4536747;
        String shopname = "anotherOneShopNameTest";
        Boolean vorkasse = false;
        Boolean nachnahme = false;
        Boolean paypal = false;
        Boolean rechnung = false;
        Boolean kreditkarte = false;
        Boolean lastschrift = false;
        ShopDAO.registerShopDAO(userID, shopname, vorkasse, nachnahme, paypal, rechnung, kreditkarte, lastschrift);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(shopname, ShopDAO.getInstance().getShopNameFromID(shopID));
        assertNotNull(ShopDAO.getInstance().getShopNameFromID(shopID));
        
    }

    /**
     * Test of getShopNameFromID method, of class ShopDAO.
     */
    @Test
    public void testGetShopNameFromID() {
        System.out.println("getShopNameFromID");
        Integer shopIDTest = shopID;
        ShopDAO instance = null;
        String expResult = shopname;
        String result = instance.getShopNameFromID(shopIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setShopNameFromID method, of class ShopDAO.
     */
    @Test
    public void testSetShopNameFromID() throws Exception {
        System.out.println("setShopNameFromID");
        Integer shopIDTest = shopID;
        String neuShopName = "neuerMegaGuterShopName";
        ShopDAO instance = null;
        boolean result = instance.setShopNameFromID(shopID, neuShopName);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteShopWithID method, of class ShopDAO.
     */
    @Test
    public void testDeleteShopWithID() {
        System.out.println("deleteShopWithID");
        Integer shopIDTest = shopID;
        ShopDAO instance = null;
        instance.deleteShopWithID(shopID);
        // TODO review the generated test code and remove the default call to fail.
        assertNull(ShopDAO.getInstance().getShopNameFromID(shopIDTest));
    }

    /**
     * Test of getShopIDWithUserID method, of class ShopDAO.
     */
    @Test
    public void testGetShopIDWithUserID() {
        System.out.println("getShopIDWithUserID");
        Integer userIDTest = userID;
        ShopDAO instance = null;
        Integer expResult = shopID;
        Integer result = instance.getShopIDWithUserID(userIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
