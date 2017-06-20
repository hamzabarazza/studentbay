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
import bonn.org.studentbay.process.control.ArtikelControl;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorse
 */
public class AddArtikelView extends VerticalLayout implements View{
    
    public void setUp(){
        
        
        
        //Content-----------------------------------------------------------------
        Panel inhaltPanel = new Panel("Artikel hinzufügen");
        inhaltPanel.setStyleName("content_block");
        
        VaadinSession session = UI.getCurrent().getSession();
       User user = (User) session.getAttribute(Roles.CURRENT_USER);
        if(user.getLogged()){
             
        //artikelname, beschreibung, kategorie       
    TextField artikelname = new TextField();
    artikelname.setCaption("Artikelname");
      
    TextField beschreibung = new TextField();
    beschreibung.setCaption("Beschreibung");
      
    TextField kategorie = new TextField();
    kategorie.setCaption("Kategorie");
    
    
    
    
    
  
   
    Button addShopButton = new Button("Artikel hinzufügen", FontAwesome.ARROW_RIGHT);
   
    addShopButton.addClickListener(new Button.ClickListener(){
        
        @Override
        public void buttonClick(Button.ClickEvent event){
            try {
                ArtikelControl.registerArtikel(artikelname.getValue(), beschreibung.getValue(), kategorie.getValue());
            } catch (RegisterFail ex) {
                Logger.getLogger(AddArtikelView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }     
    });  
    
  
      VerticalLayout addShopPanel = new VerticalLayout();
    addShopPanel.addComponents(artikelname,beschreibung,kategorie);
    addShopPanel.addComponent(addShopButton);
     
   
            inhaltPanel.setContent(addShopPanel);
            
    
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
