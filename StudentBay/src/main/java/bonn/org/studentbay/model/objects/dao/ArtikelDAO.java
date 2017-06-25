/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

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
                    + kategorie + "\'," + userid + ",(SELECT studentbay.nutzer.shopid FROM studentbay.nutzer WHERE userid = "+userid+"))");
  
        } catch (SQLException ex) {
            
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung! registerArtikel");
            
        }
        finally {
            
            JDBCConnection.getInstance().closeConnection();
            
        }
        
    }
    
    public static Integer getArtikelIDFromArtikelname(String artikelname) throws SQLException{
        
        Integer artikelIDReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT artikelid FROM studentbay.artikel WHERE studentbay.artikel.artikelname = \'" + artikelname + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } 
        
          while (set.next()) {
            artikelIDReturn = Integer.parseInt(set.getString(1));
        }
        
       
        return artikelIDReturn;
        
    }
    
    public static String getArtikelbezeichnungFromID(Integer artikelID) throws SQLException{
        
        String artikelbezeichnungReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
    
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT beschreibung FROM studentbay.artikel WHERE studentbay.artikel.artikelid = " + artikelID);
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } 
        
           while (set.next()) {
            artikelbezeichnungReturn = set.getString(1);
        }
        
      
        return artikelbezeichnungReturn;
        
    }
    

    public static String getArtikelnameFromID(Integer artikelID) throws SQLException{
        
        String artikelnameReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set =null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT artikelname FROM studentbay.artikel WHERE studentbay.artikel.artikelid = " + artikelID);
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } 
        
        
        while (set.next()) {
            artikelnameReturn = set.getString(1);
        }
        
        
        
        return artikelnameReturn;
        
    }
    
    
        public static boolean setArtikelbezeichnungFromID(Integer artikelID, String neuArtikelbezeichnung) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.artikel SET beschreibung = \'" + neuArtikelbezeichnung+ "\' WHERE artikelid = " + artikelID);
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
          
            
        return getArtikelbezeichnungFromID(artikelID).equals(neuArtikelbezeichnung);
        
    }
        
    public static boolean setArtikelNameFromID(Integer artikelID, String neuArtikelname) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.artikel SET artikelname = \'" + neuArtikelname + "\' WHERE artikelid = " + artikelID);
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getArtikelnameFromID(artikelID).equals(neuArtikelname);
        
    }
    
    
    public static void deleteArtikelWithID(Integer artikelID)throws SQLException{{
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("DELETE FROM studentbay.artikel WHERE artikelid = " + artikelID);
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
    }
    
}

}