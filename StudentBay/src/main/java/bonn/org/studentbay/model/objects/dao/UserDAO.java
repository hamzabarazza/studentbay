/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.services.db.JDBCConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class UserDAO{

    private static UserDAO dao = null;
   
    private static Integer userID = null;
    private static String userVorname = null;
    private static String userNachname = null;
    private static Date userGeburtstag = null;
    private static String userEmail = null;
    private static String userPassword = null;
    private static String userUsername = null;
    private static Integer userFachbereichID = null;
    private static Integer userShopID = null;
    private static User userData = null;
    
    UserDAO(){
        
    }
    
    public static UserDAO getInstance(){
        if ( dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }
    
    public static User getDataForUser(String username) throws SQLException{
        Statement statement;
        
        statement = JDBCConnection.getInstance().getStatement();
        ResultSet rs = null;
        
        
        try{
            rs = statement.executeQuery("SELECT * FROM studentbay.nutzer WHERE studentbay.nutzer.username = \'" + username + "\'");
        } catch (SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (rs.next()) {
             userID = rs.getInt(1);
            userVorname = rs.getString(2);
            userNachname = rs.getString(3);
            userGeburtstag = rs.getDate(11);
            userEmail = rs.getString(4);
            userPassword = rs.getString(5);
            userUsername = rs.getString(10);
            userFachbereichID = rs.getInt(12);
            userShopID = rs.getInt(13);
           
            userData = new User(userID, userUsername , userVorname, userNachname, userGeburtstag, userEmail, userPassword,userFachbereichID);
           
        }
        
        
        
        return userData;
        
    }    
    
      
    
    public static String getUsernameFromID(Integer userID) throws SQLException{
        
        String usernameReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT username FROM studentbay.nutzer WHERE studentbay.nutzer.userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set.next()) {
             usernameReturn = set.getString(1);
        }
        
       
        return usernameReturn;
        
    }
    
    public static String getVornameFromID(Integer userID) throws SQLException{
        
        String vornameReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT vorname FROM studentbay.nutzer WHERE studentbay.nutzer.userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set.next()) {
             vornameReturn = set.getString(1);
        }
        
      
        return vornameReturn;
        
    }
    
    public static String getNachnameFromID(Integer userID) throws SQLException{
        
        String nachnameReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT nachname FROM studentbay.nutzer WHERE studentbay.nutzer.userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set.next()) {
            nachnameReturn = set.getString(1);
        }
        
       
        return nachnameReturn;
        
    }
    
    public static String getEmailFromID(Integer userID) throws SQLException{
        
        String emailReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT email FROM studentbay.nutzer WHERE studentbay.nutzer.userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set.next()) {
           emailReturn = set.getString(1);
        }
        
        
        return emailReturn;
        
    }
    
    public static Integer getIDFromUsername(String username) throws SQLException{
        
        Integer idReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT userid FROM studentbay.nutzer WHERE studentbay.nutzer.username = \'" + username + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set.next()) {
            idReturn = set.getInt(1);
        }
        
        
        return idReturn;
        
    }
    
    public static boolean setUsernameFromID(Integer userID, String neuUsername) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET username = \'" + neuUsername + "\' WHERE userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
           
        return getUsernameFromID(userID).equals(neuUsername);
        
    }
    
    public static boolean setVornameFromID(Integer userID, String neuVorname) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET vorname = \'" + neuVorname + "\' WHERE userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getVornameFromID(userID).equals(neuVorname);
        
    }
    
    public static boolean setNachnameFromID(Integer userID, String neuNachname) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET nachname = \'" + neuNachname + "\' WHERE userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getNachnameFromID(userID).equals(neuNachname);
        
    }
   
    public static boolean setEmailFromID(Integer userID, String neuEmail) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET email = \'" + neuEmail + "\' WHERE userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getEmailFromID(userID).equals(neuEmail);
        
    }
    
    public static  boolean setPasswordFromID(Integer userID, String neuPassword) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET password = \'" + neuPassword + "\' WHERE userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getPasswordFromID(userID).equals(neuPassword);
        
    }
    
    public static  String getPasswordFromID(Integer userID) throws SQLException{
        
        String passwordReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try{
            set = statement.executeQuery("SELECT password FROM studentbay.nutzer WHERE studentbay.nutzer.userid = " + userID);
        } catch (SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        if (set.next()) {
            passwordReturn = set.getString(1);
        }
        
       
        return passwordReturn;
        
        
    }
    
    public static void deleteUserWithID(Integer userID){
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("DELETE FROM studentbay.nutzer WHERE userid = " + userID);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
    }
    
}
