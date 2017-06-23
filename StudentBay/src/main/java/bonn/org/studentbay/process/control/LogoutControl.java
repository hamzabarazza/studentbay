/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

/**
 *
 * @author Lorse
 */
public class LogoutControl {
    
    public static void logout(){
        
            UI.getCurrent().getSession().close();
            //getSession().getSession().invalidate();
            Page.getCurrent().reload();
          
              Notification notif = new Notification(
                " Auf Wiedersehen!",
                "Erfolgreich ausgeloggt!",
                Notification.TYPE_WARNING_MESSAGE);

            // Customize it
            notif.setDelayMsec(5000);

            // Show it in the page
            notif.show(Page.getCurrent());
    }
    }
