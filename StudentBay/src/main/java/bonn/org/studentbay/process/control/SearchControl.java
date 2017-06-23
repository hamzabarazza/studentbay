/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.model.objects.dao.SearchDAO;
import bonn.org.studentbay.model.objects.dto.Artikel;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Lorse
 */
public class SearchControl {
//    private Artikel artikel1 = new Artikel("Algebra","BEschreibung","Munster_ubung");
//    private Artikel artikel2 = new Artikel("Algebra","BEschreibung","Folie");
//    private Artikel artikel3 = new Artikel("Datenbank","BEschreibung","SQL_abfragen");
//    private Artikel artikel4 = new Artikel("Datenbank","BEschreibung","Alte_klausure");
//   
//    private Artikel artikel5 = new Artikel("Modellierung","BEschreibung","Unterlagen");
//    private Artikel artikel6 = new Artikel("Analysis","BEschreibung","Alte_klausure");
//    private Artikel artikel7 = new Artikel("SE2","BEschreibung","Vaadin");
//    private Artikel artikel8 = new Artikel("SE2","BEschreibung","Alte_klausure");
//   
//    private Artikel artikel9 = new Artikel("SE2","BEschreibung","Übungen");
//    private static Artikel artikel10 = new Artikel("Graphentheorie",1,"BEschreibung","Alte_klausure");
//    private Artikel artikel11 = new Artikel("Nachhilfe","BEschreibung","In Programmierung");
//    private Artikel artikel12 = new Artikel("Nachhilfe","BEschreibung","In Algebra");
//    private Artikel artikel13 = new Artikel("Nachhilfe","BEschreibung","In Algodat");
//    
    
    
    public SearchControl(){  
    }
    public static SearchControl search = null;
    
    public static SearchControl getInstance(){
        if(search == null){
            search = new SearchControl();
        }
        return search;
    }
    public static List<Artikel> getArtikelByName(String name) throws SQLException{
        
        return SearchDAO.getInstance().getArtikelByNameDAO(name);
        
    }
    
    
}

