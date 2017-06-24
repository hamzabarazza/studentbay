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

// *********** DER TEST SOLLTE FERTIG SEIN **********
public class SearchDAOTest {
    
    private Integer userid= 9412463;
    private String artikelname = "supertollartikel";
    private String beschreibung = "supermegatollesBuch";
    private String kategorie = "megatoll";
    private Integer artikelID = null;
    private Artikel artikel = new Artikel(artikelID,artikelname,beschreibung, kategorie);
   
            
    public SearchDAOTest() {
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
            ArtikelDAO.getInstance().registerArtikelDAO(userid,artikelname,beschreibung,kategorie);
        } catch (RegisterFail ex) {
            Logger.getLogger(SearchDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        artikelID = ArtikelDAO.getInstance().getArtikelIDFromArtikelname(artikelname);        
    }
    
    @After
    public void tearDown() {
    
        ArtikelDAO.getInstance().deleteArtikelWithID(artikelID);
        
    }

    /**
     * Test of getInstance method, of class SearchDAO.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        SearchDAO result = SearchDAO.getInstance();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getArtikelByNameDAO method, of class SearchDAO.
     */
    @Test
    public void testGetArtikelByNameDAO() throws Exception {
        System.out.println("getArtikelByNameDAO");
        String name = artikelname;
        List<Artikel> expResult = null;
        expResult.add(artikel);
        List<Artikel> result = SearchDAO.getArtikelByNameDAO(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
