/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.model.objects.dto.Artikel;
import bonn.org.studentbay.process.control.LoginControl;
import bonn.org.studentbay.services.db.JDBCConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class SearchDAO {
    
    private static SearchDAO dao = null;
    
    private SearchDAO(){
        
    }
    
    public static SearchDAO getInstance(){
        if ( dao == null) {
            dao = new SearchDAO();
        }
        return dao;
    }
    
    public static List<Artikel> getArtikelByNameDAO(String name) throws SQLException{
         // Datenbank-Zugriff
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT * FROM studentbay.artikel WHERE UPPER(studentbay.artikel.artikelname) LIKE UPPER(\'%"+name+"%\')");
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchDAO.class.getName()).log(Level.SEVERE, null, ex);
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
