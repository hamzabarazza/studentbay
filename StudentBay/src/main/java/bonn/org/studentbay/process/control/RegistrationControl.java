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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class RegistrationControl{
    static private  int NEXTID = 1000;
     static private int userid;
    public static void registerUser(String username, String vorname, String nachname, LocalDate geburtstag, String email, String password) throws RegisterFail{
         
           
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            userid = NEXTID;
            NEXTID++;
/*
            set = statement.executeQuery("INSERT INTO studentbay.nutzer (userid,username,vorname,nachname,email,password,geburtsdatum) VALUES (\'" + userid + "\',\'" + username + "\', \'" + vorname + "\',\'" 
                    + nachname + "\',\'" + email + "\',\'" + password + "\', \'null\')");
            */

  set = statement.executeQuery("INSERT INTO studentbay.nutzer (userid,username,vorname,nachname,email,password,geburtsdatum) VALUES ('234','edfregr', 'sdsaf','sadasdasd','sdas@gmx.de','1234567','2004-05-20')");
           
  
  
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        
        
        UI.getCurrent().getNavigator().navigateTo("main");
        
        
    }
    
}
