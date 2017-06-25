/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import java.sql.SQLException;
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
public class ArtikelDAOTest {
    
    private static Integer userid = 999999999;
    private static String artikelname = "testRegisterArtikelDAO";
    private static String beschreibung = "this is just a test";
    private static String kategorie = "test";
    private static Integer artikelID = null;
    
    
    public ArtikelDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    
        try {
            ArtikelDAO.registerArtikelDAO(userid, artikelname, beschreibung, kategorie);
        } catch (RegisterFail ex) {
            Logger.getLogger(ArtikelDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        artikelID = ArtikelDAO.getInstance().getArtikelIDFromArtikelname(artikelname);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    
        artikelID = ArtikelDAO.getInstance().getArtikelIDFromArtikelname(artikelname);
        ArtikelDAO.getInstance().deleteArtikelWithID(userid);
        
    }
    
    @Before
    public void setUp() {

    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of getInstance method, of class ArtikelDAO.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ArtikelDAO result = ArtikelDAO.getInstance();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of registerArtikelDAO method, of class ArtikelDAO.
     */
    @Test
    public void testRegisterArtikelDAO() throws Exception {
        System.out.println("registerArtikelDAO");
        Integer useridTest = 999999998;
        String artikelnameTest = "thisIsJustATest";
        String beschreibungTest = "dont worry be happy";
        String kategorieTest = "testomat3000";
        String neuArtikelName = "neuArtikelNameTest";
        String neuArtikelBeschreibung = "neuArtikelBeschreibungTest";
        Integer artikelIDTest = null;
        
        // CREATE
        ArtikelDAO.registerArtikelDAO(useridTest, artikelnameTest, beschreibungTest, kategorieTest);
        
        // READ
        artikelIDTest = ArtikelDAO.getInstance().getArtikelIDFromArtikelname(artikelnameTest);
        
        assertEquals(artikelnameTest, ArtikelDAO.getInstance().getArtikelnameFromID(useridTest));
        assertEquals(beschreibungTest, ArtikelDAO.getInstance().getArtikelbezeichnungFromID(useridTest));
    
        // UPDATE 
        ArtikelDAO.getInstance().setArtikelNameFromID(artikelIDTest, neuArtikelName);
        ArtikelDAO.getInstance().setArtikelNameFromID(artikelIDTest, neuArtikelBeschreibung);
    
        assertEquals(neuArtikelName, ArtikelDAO.getInstance().getArtikelnameFromID(artikelID));
        assertEquals(neuArtikelBeschreibung, ArtikelDAO.getInstance().getArtikelbezeichnungFromID(artikelID));
        
        // DELETE
        ArtikelDAO.getInstance().deleteArtikelWithID(artikelID);
        
        assertNull(ArtikelDAO.getInstance().getArtikelnameFromID(artikelID));
        assertNull(ArtikelDAO.getInstance().getArtikelbezeichnungFromID(artikelID));
    
    }

    /**
     * Test of getArtikelbezeichnungFromID method, of class ArtikelDAO.
     */
    @Test
    public void testGetArtikelbezeichnungFromID() throws Exception {
        System.out.println("getArtikelbezeichnungFromID");
        Integer artikelIDTest = artikelID;
        ArtikelDAO instance = null;
        String expResult = beschreibung;
        String result = instance.getArtikelbezeichnungFromID(artikelIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setArtikelbezeichnungFromID method, of class ArtikelDAO.
     */
    @Test
    public void testSetArtikelbezeichnungFromID() throws Exception {
        System.out.println("setArtikelbezeichnungFromID");
        Integer artikelIDTest = artikelID;
        String neuArtikelbezeichnung = "neuArtikelBezeichnung";
        ArtikelDAO instance = null;
        boolean expResult = true;
        boolean result = instance.setArtikelbezeichnungFromID(artikelIDTest, neuArtikelbezeichnung);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getArtikelnameFromID method, of class ArtikelDAO.
     */
    @Test
    public void testGetArtikelnameFromID() throws Exception {
        System.out.println("getArtikelnameFromID");
        Integer artikelIDTest = artikelID;
        String expResult = artikelname;
        String result = ArtikelDAO.getInstance().getArtikelnameFromID(artikelIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setArtikelNameFromID method, of class ArtikelDAO.
     */
    @Test
    public void testSetArtikelNameFromID() throws Exception {
        System.out.println("setArtikelNameFromID");
        Integer artikelIDTest = artikelID;
        String neuArtikelname = "neuArtikelNameJustATest";
        ArtikelDAO instance = null;
        boolean result = instance.setArtikelNameFromID(artikelIDTest, neuArtikelname);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteArtikelWithID method, of class ArtikelDAO.
     */
    @Test
    public void testDeleteArtikelWithID() throws SQLException {
        System.out.println("deleteArtikelWithID");
        Integer artikelIDTest = artikelID;
        ArtikelDAO instance = null;
        instance.deleteArtikelWithID(artikelIDTest);
        // TODO review the generated test code and remove the default call to fail.
        
        assertNull(ArtikelDAO.getInstance().getArtikelbezeichnungFromID(artikelIDTest));
        assertNull(ArtikelDAO.getInstance().getArtikelnameFromID(artikelIDTest));
    }

    /**
     * Test of getArtikelIDFromArtikelname method, of class ArtikelDAO.
     */
    @Test
    public void testGetArtikelIDFromArtikelname() {
        System.out.println("getArtikelIDFromArtikelname");
        String artikelnameTest = artikelname;
        ArtikelDAO instance = null;
        Integer expResult = artikelID;
        Integer result = instance.getArtikelIDFromArtikelname(artikelname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
