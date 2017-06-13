/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.components;

import bonn.org.studentbay.model.objects.dto.User;
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
        
        
        Boolean status = User.getLogged();
        
        //Inhalt des Newsfeeds
        VerticalLayout content = new VerticalLayout();
        content.addStyleName("mypanelcontent");
        
        
        Button homeButton = new Button("Startseite");
        homeButton.addClickListener((Button.ClickEvent e)->{
            UI.getCurrent().getNavigator().navigateTo("main");
        });
        
        
        
        Button profileButton = new Button("mein Profil");
         profileButton.addClickListener((Button.ClickEvent e)->{
            UI.getCurrent().getNavigator().navigateTo("profile");
        });
         
          Button addShopButton = new Button("Shop hinzufügen");
         addShopButton.addClickListener((Button.ClickEvent e)->{
            UI.getCurrent().getNavigator().navigateTo("addshop");
        });
         
            Button addArtikelButton = new Button("Artikel hinzufügen");
         addArtikelButton.addClickListener((Button.ClickEvent e)->{
            UI.getCurrent().getNavigator().navigateTo("addartikel");
        });
        
        
        content.addComponent(homeButton);
        
       //Nur wenn eingeloggt
        if(status){

        content.addComponent(profileButton);
        content.addComponent(addShopButton);
        content.addComponent(addArtikelButton);
        }
        
      
        newsfeed.setContent(content);
        
        addComponent(newsfeed);
        
    }
}
