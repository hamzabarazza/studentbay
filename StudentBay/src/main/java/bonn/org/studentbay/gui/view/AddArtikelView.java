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
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Lorse
 */
public class AddArtikelView extends VerticalLayout implements View{
    
    public void setUp(){
        
        
        
        //Content-----------------------------------------------------------------
        Panel inhaltPanel = new Panel("Artikel hinzufügen");
        inhaltPanel.setStyleName("content_block");
        
        
        if(User.getLogged()){
             
        //artikelname, beschreibung, kategorie       
    TextField artikelname = new TextField();
    artikelname.setCaption("Artikelname");
      
    TextField beschreibung = new TextField();
    beschreibung.setCaption("Beschreibung");
      
    TextField kategorie = new TextField();
    kategorie.setCaption("Kategorie");
    
    TextField preis = new TextField();
    preis.setCaption("Preis");
    
    
    
  
   
    Button addShopButton = new Button("Artikel hinzufügen", FontAwesome.ARROW_RIGHT);
   
    addShopButton.addClickListener(new Button.ClickListener(){
        
        @Override
        public void buttonClick(Button.ClickEvent event){
           
            
        }     
    });  
    
  
      VerticalLayout addShopPanel = new VerticalLayout();
    addShopPanel.addComponents(artikelname,beschreibung,kategorie,preis);
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
