/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.model.objects.dao.ArtikelDAO;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import com.vaadin.ui.UI;

/**
 *
 * @author jens
 */
public class ArtikelControl {
    
    public static void registerArtikel(Integer userid, String artikelname, String beschreibung, String kategorie) throws RegisterFail{
        
        ArtikelDAO.getInstance().registerArtikelDAO(userid, artikelname, beschreibung, kategorie);
        
        UI.getCurrent().getNavigator().navigateTo("main");
        
        
    }
}
