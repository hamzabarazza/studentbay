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
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author jens
 */
public class ProfileView extends VerticalLayout implements View{
    
    public void setUp(){
        
        
        
        //Content-----------------------------------------------------------------
        Panel inhaltPanel = new Panel("Dein Profil, " + User.getUsername());
        inhaltPanel.setStyleName("content_block");
        
        
        if(User.getLogged()){
            
            VerticalLayout inhalt = new VerticalLayout();
        Label usernameAnzeige = new Label("Username : " + User.getUsername());
        Label vornameAnzeige = new Label("Vorname : " + User.getVorname());
        Label nachnameAnzeige = new Label("Nachname : " + User.getNachname());
        Label emailAnzeige = new Label("Email : " + User.getEmail());
       
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
