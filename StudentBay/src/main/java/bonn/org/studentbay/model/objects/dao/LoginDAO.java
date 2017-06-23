/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.LoginControl;
import bonn.org.studentbay.process.control.exceptions.NoSuchUserOrPassword;
import bonn.org.studentbay.services.db.JDBCConnection;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class LoginDAO {
    private static LoginDAO dao = null;
    
    private LoginDAO(){
        
    }
    
    public static LoginDAO getInstance(){
        if ( dao == null) {
            dao = new LoginDAO();
        }
        return dao;
    }

    public static void checkAuthenticatonDAO(String login, String password) throws NoSuchUserOrPassword{
        
        // Datenbank-Zugriff
        
        Statement statement = JDBCConnection.getInstance().getStatement();
        ResultSet set = null;
        try {
            // SQL-Befehl
            set = statement.executeQuery("SELECT * FROM studentbay.nutzer WHERE studentbay.nutzer.username = \'" + login + "\'"
                                        + " AND studentbay.nutzer.password = \'" + password + "\'");
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
            // Fehler bei SQL
            System.out.println("Fehler in der SQL-Anweisung!");
        }
        
        User user = new User();
        
        try{
        
          if( set.next()){
            user.setID(set.getInt(1));
            user.setUsername(set.getString(10));
            user.setVorname(set.getString(2));
            user.setNachname(set.getString(3));
            user.setEmail(set.getString(4));
            user.setLogged(true);

           Notification notif = new Notification(
                "Herzlich Willkommen " + user.getUsername() + "!",
                "Der Login war erfolgreich",
                Notification.TYPE_WARNING_MESSAGE);

            // Customize it
            notif.setDelayMsec(3000);

            // Show it in the page
            notif.show(Page.getCurrent());
           
        } else {
            // Fehlerfall
            throw new NoSuchUserOrPassword();
        }
        } catch (SQLException ex){
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBCConnection.getInstance().closeConnection();
        }
        
        VaadinSession session = UI.getCurrent().getSession();
        session.setAttribute(Roles.CURRENT_USER, user);
        
        UI.getCurrent().getNavigator().navigateTo("main");
       
    }
    
}