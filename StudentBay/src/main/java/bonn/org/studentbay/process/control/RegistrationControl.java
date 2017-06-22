/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import bonn.org.studentbay.services.db.JDBCConnection;
import com.vaadin.ui.UI;
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
public class RegistrationControl{
    
    public RegistrationControl(){  
    }
    
    public static void registerUser(String username, String vorname, String nachname, Date geburtstag, String email, String password) throws RegisterFail{
         
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;

        try {
            

            set = statement.executeQuery("INSERT INTO studentbay.nutzer (username,vorname,nachname,email,password,geburtsdatum) VALUES (\'" + username + "\', \'" + vorname + "\',\'" 
                    + nachname + "\',\'" + email + "\',\'" + password + "\', \'"+geburtstag+"\')");
            
       //Prepate Statements
  
  
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung! registerUser");
        }
        finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        
        
        UI.getCurrent().getNavigator().navigateTo("main");
        
        
    }
    
}
