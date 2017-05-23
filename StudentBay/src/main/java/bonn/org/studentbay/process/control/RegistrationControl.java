/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import bonn.org.studentbay.services.db.JDBCConnection;
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
    
    public static void registerUser(String username, String vorname, String nachname, LocalDate geburtstag, String email, String password) throws RegisterFail{
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("INSERT INTO studentbay.nutzer (userid,vorname,nachname,email,password,ort,plz,straße,hausnr,username,geburtsdatum,fachbereichid,shopid) "
                    + "VALUES (999," + "\'" + vorname + "\', " + "\'" + nachname + "\', " + "\'" + email + "\', " + "\'" + password + "\', "
                    + "\'" + "Musterstadt" + "\', " + "\'" + "76453" + "\', " + "\'" + "Musterstraße" + "\', " + "\'" + "2" + "\', "
                    + "\'" + username + "\', " + "\'" + geburtstag + "\', " + "\'" + "2" + "\', " + "\'" + "0" + "\', ");
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
    }
    
}
