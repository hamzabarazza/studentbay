/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.model.objects.dto.Artikel;
import bonn.org.studentbay.services.db.JDBCConnection;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
         // Datenbank-Zugriff
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT * FROM studentbay.artikel WHERE UPPER(studentbay.artikel.artikelname) LIKE UPPER(\'%"+name+"%\')");
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        Artikel artikel = null;
        
        ArrayList<Artikel> list = new ArrayList<Artikel>();
        try{
           
        while(set.next()){
            //Artikel in array einfügen
            artikel = new Artikel();
            artikel.setID(set.getInt(1));
            artikel.setArtikelname(set.getString(7));
            artikel.setArtikelBeschreibung(set.getString(2));
            artikel.setArtikelKategorie(set.getString(3));
            list.add(artikel);
      
        }
        } catch(SQLException ex){
            
        }
          
     
        
        return list;
    }
    
    
}

