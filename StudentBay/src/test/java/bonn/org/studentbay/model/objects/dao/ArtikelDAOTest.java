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
    
    private static Integer userid = 1;
    private static String artikelname = "testRegisterArtikelDAO";
    private static String beschreibung = "this is just a test";
    private static String kategorie = "test";
    private static Integer artikelID = null;
    
     private static Integer userid2 = 1;
    private static String artikelname2 = "testRegisterArtikelDAO2";
    private static String beschreibung2 = "this is just a test2";
    private static String kategorie2 = "test2";
    private static Integer artikelID2 = null;
    
       private static Integer userid3 = 1;
    private static String artikelname3 = "testRegisterArtikelDAO3";
    private static String beschreibung3 = "this is just a test3";
    private static String kategorie3 = "test3";
    private static Integer artikelID3 = null;
    
    
    public ArtikelDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
    
        try {
            ArtikelDAO.registerArtikelDAO(userid, artikelname, beschreibung, kategorie);
        } catch (RegisterFail ex) {
            Logger.getLogger(ArtikelDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        artikelID = ArtikelDAO.getInstance().getArtikelIDFromArtikelname(artikelname);
        
        
        
        try {
            ArtikelDAO.registerArtikelDAO(userid2, artikelname2, beschreibung2, kategorie2);
        } catch (RegisterFail ex) {
            Logger.getLogger(ArtikelDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        artikelID2 = ArtikelDAO.getInstance().getArtikelIDFromArtikelname(artikelname2);
        
       
        try {
            ArtikelDAO.registerArtikelDAO(userid3, artikelname3, beschreibung3, kategorie3);
        } catch (RegisterFail ex) {
            Logger.getLogger(ArtikelDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        artikelID3 = ArtikelDAO.getInstance().getArtikelIDFromArtikelname(artikelname3);
        
        
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        ArtikelDAO.getInstance().deleteArtikelWithID(artikelID);
        ArtikelDAO.getInstance().deleteArtikelWithID(artikelID2);
    }
    
    @Before
    public void setUp() {

    }
    
    @After
    public void tearDown()  {
       
       
        
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
        Integer useridTest = 1;
        String artikelnameTest = "thisIsJustATest";
        String beschreibungTest = "dont worry be happy";
        String kategorieTest = "testomat3000";
        String neuArtikelName = "neuArtikelNameTest";
        String neuArtikelBeschreibung = "neuArtikelBeschreibungTest";
        Integer artikelIDTest ;
        
        // CREATE
        ArtikelDAO.registerArtikelDAO(useridTest, artikelnameTest, beschreibungTest, kategorieTest);
        
        // READ
        artikelIDTest = ArtikelDAO.getInstance().getArtikelIDFromArtikelname(artikelnameTest);
        
        assertEquals(artikelnameTest, ArtikelDAO.getInstance().getArtikelnameFromID(artikelIDTest));
        assertEquals(beschreibungTest, ArtikelDAO.getInstance().getArtikelbezeichnungFromID(artikelIDTest));
    
        // UPDATE 
        ArtikelDAO.getInstance().setArtikelNameFromID(artikelIDTest, neuArtikelName);
        ArtikelDAO.getInstance().setArtikelbezeichnungFromID(artikelIDTest, neuArtikelBeschreibung);
    
        assertEquals(neuArtikelName, ArtikelDAO.getInstance().getArtikelnameFromID(artikelIDTest));
        assertEquals(neuArtikelBeschreibung, ArtikelDAO.getInstance().getArtikelbezeichnungFromID(artikelIDTest));
        
        // DELETE
        ArtikelDAO.getInstance().deleteArtikelWithID(artikelIDTest);
        
        assertNull(ArtikelDAO.getInstance().getArtikelnameFromID(artikelIDTest));
        assertNull(ArtikelDAO.getInstance().getArtikelbezeichnungFromID(artikelIDTest));
    
    }

    /**
     * Test of getArtikelbezeichnungFromID method, of class ArtikelDAO.
     */
    @Test
    public void testGetArtikelbezeichnungFromID() throws Exception {
        System.out.println("getArtikelbezeichnungFromID");
        Integer artikelIDTest = artikelID2;
        
        String expResult = beschreibung2;
        String result = ArtikelDAO.getArtikelbezeichnungFromID(artikelIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getArtikelnameFromID method, of class ArtikelDAO.
     */
    @Test
    public void testGetArtikelnameFromID() throws Exception {
        System.out.println("getArtikelnameFromID");
        Integer artikelIDTest = artikelID2;
        String expResult = artikelname2;
        String result = ArtikelDAO.getInstance().getArtikelnameFromID(artikelIDTest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

  

    /**
     * Test of getArtikelIDFromArtikelname method, of class ArtikelDAO.
     */
    @Test
    public void testGetArtikelIDFromArtikelname() throws SQLException {
        System.out.println("getArtikelIDFromArtikelname");
        String artikelnameTest = artikelname2;
        Integer expResult = artikelID2;
        Integer result = ArtikelDAO.getArtikelIDFromArtikelname(artikelname2);
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
        boolean result = ArtikelDAO.setArtikelNameFromID(artikelIDTest, neuArtikelname);
        assertTrue(result);
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
        boolean result = ArtikelDAO.setArtikelbezeichnungFromID(artikelIDTest, neuArtikelbezeichnung);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
     /**
     * Test of deleteArtikelWithID method, of class ArtikelDAO.
     */
    @Test
    public void testDeleteArtikelWithID() throws SQLException {
        System.out.println("deleteArtikelWithID");
       
        Integer artikelIDTest = artikelID3;
        ArtikelDAO.deleteArtikelWithID(artikelIDTest);
        // TODO review the generated test code and remove the default call to fail.
        
        assertNull(ArtikelDAO.getInstance().getArtikelbezeichnungFromID(artikelIDTest));
        assertNull(ArtikelDAO.getInstance().getArtikelnameFromID(artikelIDTest));
    
    }
    
}
