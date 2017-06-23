/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.process.control.LoginControl;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import bonn.org.studentbay.services.db.JDBCConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class ArtikelDAO {
    private static ArtikelDAO dao = null;
    
    private ArtikelDAO(){
        
    }
    
    public static ArtikelDAO getInstance(){
        if ( dao == null) {
            dao = new ArtikelDAO();
        }
        return dao;
    }

    public static void registerArtikelDAO(Integer userid, String artikelname, String beschreibung, String kategorie) throws RegisterFail{
         
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            
            set = statement.executeQuery("INSERT INTO studentbay.artikel (artikelname, beschreibung, kategorie,userid,shopid) VALUES (\'" + artikelname + "\', \'" + beschreibung + "\',\'" 
                    + kategorie + "\',\'" + userid + "\',(SELECT studentbay.nutzer.shopid FROM studentbay.nutzer WHERE userid = "+userid+"))");
  
        } catch (SQLException ex) {
            
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung! registerArtikel");
            
        }
        finally {
            
            JDBCConnection.getInstance().closeConnection();
            
        }
        
    }

}
