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
import bonn.org.studentbay.process.control.LoginControl;
import bonn.org.studentbay.process.control.exceptions.NoSuchUserOrPassword;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Lorse
 */
public class AddShopView extends VerticalLayout implements View{
    
    public void setUp(){
        
        
        
        //Content-----------------------------------------------------------------
        Panel inhaltPanel = new Panel("Shop hinzufügen");
        inhaltPanel.setStyleName("content_block");
        
        
        if(User.getLogged()){
            
               
    TextField shopName = new TextField();
    shopName.setCaption("Shop Name");
    
    
    CheckBox checkbox1 = new CheckBox("Vorkasse");
    CheckBox checkbox2 = new CheckBox("Nachname");
    CheckBox checkbox3 = new CheckBox("PayPal");
    CheckBox checkbox4 = new CheckBox("Rechnung");
    CheckBox checkbox5 = new CheckBox("Kreditkarte");
    CheckBox checkbox6 = new CheckBox("Lastschrift");
    
    //checkbox2.setValue(true);

   
   
    Button addShopButton = new Button("Shop erstellen", FontAwesome.ARROW_RIGHT);
   
    addShopButton.addClickListener(new Button.ClickListener(){
        
        @Override
        public void buttonClick(Button.ClickEvent event){
           
            
        }     
    });  
    
  
      VerticalLayout addShopPanel = new VerticalLayout();
    addShopPanel.addComponent(shopName);
    addShopPanel.addComponents(checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6);
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
