/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import static bonn.org.studentbay.model.objects.dao.UserDAO.getPasswordFromID;
import bonn.org.studentbay.model.objects.dto.Artikel;
import bonn.org.studentbay.process.control.LoginControl;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import bonn.org.studentbay.services.db.JDBCConnection;
import com.vaadin.ui.UI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class ShopDAO {
    
    private static ShopDAO dao = null;
    
    private ShopDAO(){
        
    }
    
    public static ShopDAO getInstance(){
        if ( dao == null) {
            dao = new ShopDAO();
        }
        return dao;
    }
    
    public static String getMeinShopDAO(Integer user) throws SQLException {
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT * FROM studentbay.shop WHERE studentbay.shop.shopid IN (SELECT studentbay.nutzer.shopid FROM studentbay.nutzer WHERE studentbay.nutzer.shopid IS NOT NULL AND studentbay.nutzer.userid = "+ user + ")");
            
        } catch (SQLException ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
      if(set.next()){
          return set.getString(3);
      }else{
          return "";
      }
         
    }
    
      public static void setMeinShopDAO(Integer userID, Integer shopID) throws SQLException {
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET shopid = " + shopID + " WHERE userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        
      }
      
      
    public static Integer getShopIDbyName(String shopName) throws SQLException{
        
        Integer shopidReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        
        try{
            set = statement.executeQuery("SELECT shopid FROM studentbay.shop WHERE studentbay.shop.name = \'" + shopName + "\'");
        } catch (SQLException ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set.next()) {
            shopidReturn = Integer.parseInt(set.getString(1));
        }
        
        
        return shopidReturn;
        
    }
    public static List<Artikel> getArtikelShopDAO(Integer userID){
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT * FROM studentbay.artikel WHERE studentbay.artikel.shopid IN (SELECT studentbay.nutzer.shopid FROM studentbay.nutzer WHERE studentbay.nutzer.userid = "+ userID +")");
            
        } catch (SQLException ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
          
     
        
        return list;
    }
    
    public static void registerShopDAO(Integer userID, String shopname, Boolean vorkasse, Boolean nachnahme, Boolean paypal, Boolean rechnung, Boolean kreditkarte, Boolean lastschrift) throws RegisterFail{
         
         
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {

            set = statement.executeQuery("INSERT INTO studentbay.shop (erstelldatum, name, vorkasse, nachname, paypal, rechnung, kreditkarte, lastschrift) VALUES (\'2012-10-10\', \'" + shopname + "\', " + vorkasse + "," 
                    + nachnahme + ", " + paypal + ", " + rechnung + ", " + kreditkarte + ", " + lastschrift + ")");
            
    
        } catch (SQLException ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung! registerShop");
        }
        finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
    }
    
    public static String getShopNameFromID(Integer shopID) throws SQLException{
        
        String shopNameReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        
        try{
            set = statement.executeQuery("SELECT name FROM studentbay.shop WHERE studentbay.shop.shopid = " + shopID);
        } catch (SQLException ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set.next()) {
            shopNameReturn = set.getString(1);
        }
        
        
        return shopNameReturn;
        
    }
    
    public static boolean setShopNameFromID(Integer shopID, String neuShopName) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.shop SET name = \'" + neuShopName + "\' WHERE shopid = " + shopID);
            
        } catch (SQLException ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getShopNameFromID(shopID).equals(neuShopName);
        
    }
    
    public static Integer getShopIDWithUserID(Integer userID) throws SQLException{
        
        Integer shopIDReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        
        try{
            set = statement.executeQuery("SELECT * FROM studentbay.nutzer WHERE studentbay.nutzer.userid = " + userID);
        } catch (SQLException ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set.next()) {
             shopIDReturn = set.getInt(13);
        }
        
        return shopIDReturn;
        
    }
    
    public static void deleteShopWithID(Integer shopID){
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("DELETE FROM studentbay.shop WHERE shopid = " + shopID);
            
        } catch (SQLException ex) {
            Logger.getLogger(ShopDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
    }
    
}
