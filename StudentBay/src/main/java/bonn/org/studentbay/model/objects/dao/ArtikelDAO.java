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
                    + kategorie + "\',\'" + userid + "\',(SELECT studentbay.nutzer.shopid FROM studentbay.nutzer WHERE userid = "+userid+"))");
  
        } catch (SQLException ex) {
            
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung! registerArtikel");
            
        }
        finally {
            
            JDBCConnection.getInstance().closeConnection();
            
        }
        
    }
    
    public String getArtikelbezeichnungFromID(Integer artikelID) throws SQLException{
        
        String artikelbezeichnungReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
    
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT beschreibung FROM studentbay.artikel WHERE studentbay.artikel.artikelid = \'" + artikelID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } 
        
        if (set == null) {
            return null;
        }
        
        try {
           
            artikelbezeichnungReturn = set.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        return artikelbezeichnungReturn;
        
    }
    
    public boolean setArtikelbezeichnungFromID(Integer artikelID, String neuArtikelbezeichnung) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.artikel SET bezeichnung = \'" + neuArtikelbezeichnung+ "\' WHERE userid = \'" + artikelID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getArtikelbezeichnungFromID(artikelID).equals(neuArtikelbezeichnung);
        
    }
    
    
    public String getArtikelnameFromID(Integer artikelID) throws SQLException{
        
        String artikelnameReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT artikelname FROM studentbay.artikel WHERE studentbay.artikel.artikelid = \'" + artikelID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } 
        
        if (set == null) {
            return null;
        }
        
        try {
           
            artikelnameReturn = set.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        return artikelnameReturn;
        
    }
    
    public boolean setArtikelNameFromID(Integer artikelID, String neuArtikelname) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.artikel SET artikelname = \'" + neuArtikelname + "\' WHERE userid = \'" + artikelID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getArtikelnameFromID(artikelID).equals(neuArtikelname);
        
    }
    
    
    public void deleteArtikelWithID(Integer artikelID){
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("DELETE FROM studentbay.artikel WHERE artikelid = \'" + artikelID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtikelDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
    }
    
}
