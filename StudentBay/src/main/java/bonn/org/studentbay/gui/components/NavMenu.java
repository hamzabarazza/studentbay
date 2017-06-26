/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.components;

import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Lorse
 */
public class NavMenu extends HorizontalLayout{

    
    public NavMenu(){
    //Newsfeed----------------------------------------------------
        Panel newsfeed = new Panel("Navigation");
        newsfeed.setWidth("250px");
        newsfeed.setStyleName("navmenu");
        
        
        VaadinSession session = UI.getCurrent().getSession();
       User user = (User) session.getAttribute(Roles.CURRENT_USER);
        
       
    
        //Inhalt des Newsfeeds
        VerticalLayout content = new VerticalLayout();
        content.addStyleName("mypanelcontent");
        
        
        Button homeButton = new Button("Startseite");
        homeButton.addClickListener(new Button.ClickListener(){
            

            @Override
            public void buttonClick(Button.ClickEvent event) {
                UI.getCurrent().getNavigator().navigateTo("main");
            }
        });
        
        
        
        Button profileButton = new Button("Mein Profil");
         profileButton.addClickListener(new Button.ClickListener(){
          

            public void buttonClick(Button.ClickEvent event) {
                  UI.getCurrent().getNavigator().navigateTo("profile");
            }
        });
         
          Button meinShopButton = new Button("Mein Shop");
         meinShopButton.addClickListener(new Button.ClickListener(){
            

            public void buttonClick(Button.ClickEvent event) {
                UI.getCurrent().getNavigator().navigateTo("meinshop");
            }
        });
         
          Button addShopButton = new Button("Shop hinzufügen");
         addShopButton.addClickListener(new Button.ClickListener(){
            

            public void buttonClick(Button.ClickEvent event) {
                UI.getCurrent().getNavigator().navigateTo("addshop");
            }
        });
         
            Button addArtikelButton = new Button("Artikel hinzufügen");
         addArtikelButton.addClickListener(new Button.ClickListener(){
            public void buttonClick(Button.ClickEvent event) {
               UI.getCurrent().getNavigator().navigateTo("addartikel");
            }
            
        });
        
        
        content.addComponent(homeButton);
        
       //Nur wenn eingeloggt
       Boolean status;
       if(user==null){status = false;}else{status = true;}
        if(status){

        content.addComponent(meinShopButton);
        content.addComponent(profileButton);
        content.addComponent(addShopButton);
        content.addComponent(addArtikelButton);
        }
        
          
        Button videoButton = new Button("Zum Video");
         videoButton.addClickListener(new Button.ClickListener(){
          

            @Override
            public void buttonClick(Button.ClickEvent event) {
                  UI.getCurrent().getNavigator().navigateTo("video");
            }
        });
         
         
        content.addComponent(videoButton);
      
        newsfeed.setContent(content);
        
        addComponent(newsfeed);
        
        setMargin(true);
    }
}
