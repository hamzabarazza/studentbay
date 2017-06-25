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
   
    private Integer userID = null;
    private String userVorname = null;
    private String userNachname = null;
    private Date userGeburtstag = null;
    private String userEmail = null;
    private String userPassword = null;
    private String userUsername = null;
    private Integer userFachbereichID = null;
    private Integer userShopID = null;
    private User userData = null;
    
    UserDAO(){
        
    }
    
    public static UserDAO getInstance(){
        if ( dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }
    
    public User getDataForUser(String username) throws SQLException{
        Statement statement;
        
        statement = JDBCConnection.getInstance().getStatement();
        ResultSet rs = null;
        
        
        try{
            rs = statement.executeQuery("SELECT * FROM studentbay.nutzer WHERE studentbay.nutzer.username = \'" + username + "\'");
        } catch (SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (rs == null) {
            return null;
        }
        
        try {
            
            userID = rs.getInt(1);
            userVorname = rs.getString(2);
            userNachname = rs.getString(3);
            userGeburtstag = rs.getDate(10);
            userEmail = rs.getString(3);
            userPassword = rs.getString(4);
            userUsername = rs.getString(9);
            userFachbereichID = rs.getInt(11);
            userShopID = rs.getInt(12);
           
            userData = new User(userID, userUsername , userVorname, userNachname, userGeburtstag, userEmail, userPassword,userFachbereichID);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userData;
        
    }    
    
    public String getUsernameFromID(Integer userID) throws SQLException{
        
        String usernameReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT username FROM studentbay.nutzer WHERE studentbay.nutzer.userid = \'" + userID+ "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set == null) {
            return null;
        }
        
        try {
           
            usernameReturn = set.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        return usernameReturn;
        
    }
    
    public String getVornameFromID(Integer userID) throws SQLException{
        
        String vornameReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT vorname FROM studentbay.nutzer WHERE studentbay.nutzer.userid = \'" + userID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set == null) {
            return null;
        }
        
        try {
           
            vornameReturn = set.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        return vornameReturn;
        
    }
    
    public String getNachnameFromID(Integer userID) throws SQLException{
        
        String nachnameReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT nachname FROM studentbay.nutzer WHERE studentbay.nutzer.userid = \'" + userID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set == null) {
            return null;
        }
        
        try {
           
            nachnameReturn = set.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        return nachnameReturn;
        
    }
    
    public String getEmailFromID(Integer userID) throws SQLException{
        
        String emailReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT email FROM studentbay.nutzer WHERE studentbay.nutzer.userid = \'" + userID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set == null) {
            return null;
        }
        
        try {
           
            emailReturn = set.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        return emailReturn;
        
    }
    
    public Integer getIDFromUsername(String username){
        
        Integer idReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT email FROM studentbay.nutzer WHERE studentbay.nutzer.username = \'" + username + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        if (set == null) {
            return null;
        }
        
        try {
           
            idReturn = set.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        return idReturn;
        
    }
    
    public boolean setUsernameFromID(Integer userID, String neuUsername) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET username = \'" + neuUsername + "\' WHERE userid = \'" + userID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
           
        return getUsernameFromID(userID).equals(neuUsername);
        
    }
    
    public boolean setVornameFromID(Integer userID, String neuVorname) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET vorname = \'" + neuVorname + "\' WHERE userid = \'" + userID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getVornameFromID(userID).equals(neuVorname);
        
    }
    
    public boolean setNachnameFromID(Integer userID, String neuNachname) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET nachname = \'" + neuNachname + "\' WHERE userid = \'" + userID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getNachnameFromID(userID).equals(neuNachname);
        
    }
   
    public boolean setEmailFromID(Integer userID, String neuEmail) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET email = \'" + neuEmail + "\' WHERE userid = \'" + userID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getEmailFromID(userID).equals(neuEmail);
        
    }
    
    public boolean setPasswordFromID(Integer userID, String neuPassword) throws SQLException{
       
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("UPDATE studentbay.nutzer SET password = \'" + neuPassword + "\' WHERE userid = \'" + userID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
           
        return getEmailFromID(userID).equals(neuPassword);
        
    }
    
    public String getPasswordFromID(Integer userID) throws SQLException{
        
        String passwordReturn = null;
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try{
            set = statement.executeQuery("SELECT password FROM studentbay.nutzer WHERE studentbay.nutzer.userid = \'" + userID + "\'");
        } catch (SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        if (set == null) {
            return null;
        }
        
        try {
           
            passwordReturn = set.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        return passwordReturn;
        
        
    }
    
    public void deleteUserWithID(Integer userID){
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("DELETE FROM studentbay.nutzer WHERE userid = \'" + userID + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
    }
    
}
