/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import bonn.org.studentbay.gui.components.Footer;
import bonn.org.studentbay.gui.components.NavMenu;
import bonn.org.studentbay.gui.components.TopPanel;
import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author jens
 */
public class ProfileView extends VerticalLayout implements View{
    
    public void setUp(){
        
        VaadinSession session = UI.getCurrent().getSession();
       User user = (User) session.getAttribute(Roles.CURRENT_USER);
        
        //Content-----------------------------------------------------------------
        Panel inhaltPanel = new Panel("Dein Profil, " + user.getUsername());
        inhaltPanel.setStyleName("content_block");
        
        
        if(user.getLogged()){
            
            VerticalLayout inhalt = new VerticalLayout();
        Label usernameAnzeige = new Label("Username : " + user.getUsername());
        Label vornameAnzeige = new Label("Vorname : " + user.getVorname());
        Label nachnameAnzeige = new Label("Nachname : " + user.getNachname());
        Label emailAnzeige = new Label("Email : " + user.getEmail());
       
        inhalt.addComponents(usernameAnzeige, vornameAnzeige, nachnameAnzeige, emailAnzeige);
      
        inhaltPanel.setContent(inhalt);
         }else{
            Label ausgeloggt = new Label("Bitte logge dich ein!");
            
        inhaltPanel.setContent(ausgeloggt);
        }
        
        
       
         HorizontalLayout mitte = new HorizontalLayout();
        mitte.addComponent(new NavMenu()); //Navigation hinzufügen
        
        mitte.addComponent(inhaltPanel); //Content hinzufügen
       
        
       
        
        //Alle Elemente hinzufügen
        addComponents( new TopPanel(),  mitte, new Footer());
        
        
        
       
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
}
