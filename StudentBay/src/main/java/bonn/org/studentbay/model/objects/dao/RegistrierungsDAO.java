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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class RegistrierungsDAO {
    
    private static RegistrierungsDAO dao = null;
    
    private RegistrierungsDAO(){
        
    }
    
    public static RegistrierungsDAO getInstance(){
        if ( dao == null) {
            dao = new RegistrierungsDAO();
        }
        return dao;
    }

    public boolean checkUsernameExists(String username){
       Statement statement = null;
        
        statement = JDBCConnection.getInstance().getStatement();
        ResultSet rs = null;
        
        
        try{
            rs = statement.executeQuery("SELECT * FROM studentbay.nutzer WHERE studentbay.nutzer.username = \'" + username + "\'");
        } catch (SQLException ex){
            Logger.getLogger(RegistrierungsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        // wenn er was findet, return = false | wenn er nichts findet return = true
       
        Boolean ausgabe = true;
        try {
            while(rs.next()){
                ausgabe = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrierungsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ausgabe;
        
    }
    
    public boolean checkEmailExists(String email){
       Statement statement = null;
        
        statement = JDBCConnection.getInstance().getStatement();
        ResultSet rs = null;
        
        
        try{
            rs = statement.executeQuery("SELECT * FROM studentbay.nutzer WHERE studentbay.nutzer.email = \'" + email + "\'");
        } catch (SQLException ex){
            Logger.getLogger(RegistrierungsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        // wenn er was findet, return = false | wenn er nichts findet return = true
        
        Boolean ausgabe = true;
        try {
            while(rs.next()){
                ausgabe = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrierungsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ausgabe;
        
    }
    
    public static void registerUserDAO(String username, String vorname, String nachname, Date geburtstag, String email, String password) throws RegisterFail, SQLException{
         
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;

        try {
            
            set = statement.executeQuery("INSERT INTO studentbay.nutzer (username,vorname,nachname,email,password,geburtsdatum) VALUES (\'" + username + "\', \'" + vorname + "\',\'" 
                    + nachname + "\',\'" + email + "\',\'" + password + "\', \'"+geburtstag+"\')");

        } catch (SQLException ex) {
            Logger.getLogger(RegistrierungsDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung! --registerUser");
        }
        
       
        finally {
            JDBCConnection.getInstance().closeConnection();
        }

    }
}