/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import bonn.org.studentbay.gui.components.Footer;
import bonn.org.studentbay.gui.components.NavMenu;
import bonn.org.studentbay.gui.components.TopPanel;
import bonn.org.studentbay.model.objects.dto.Artikel;
import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.ArtikelControl;
import bonn.org.studentbay.process.control.MeinShopControl;
import bonn.org.studentbay.process.control.SearchControl;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorse
 */
public class MeinShopView extends VerticalLayout implements View{
    
    public void setUp(){
        VaadinSession session = UI.getCurrent().getSession();
        User user = (User) session.getAttribute(Roles.CURRENT_USER);
        
        String meinShop = null;
        try {
            meinShop = MeinShopControl.getMeinShop(user.getID());
        } catch (SQLException ex) {
            Logger.getLogger(MeinShopView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Panel inhaltPanel;
        //Content-----------------------------------------------------------------
        if(meinShop.equals("")){
            inhaltPanel = new Panel("Mein Shop: Es wurde noch kein Shop erstellt!");
        }else{
           inhaltPanel = new Panel("Mein Shop: " + meinShop); 
        }
        
        inhaltPanel.setStyleName("content_block");
        
        
       
        if(user.getLogged()){
             
    
                    if(!meinShop.equals("")){

                        BeanContainer<Integer,Artikel> data = new BeanContainer<Integer,Artikel>(Artikel.class);
                        data.setBeanIdProperty("ID");
                        Table table = new Table("Treffer", data);
                        table.setSizeFull();
                        table.setSelectable(true);

                        List list;
                        list = MeinShopControl.getArtikelShop(user.getID());
                        data.removeAllItems();
                        data.addAll(list);

                         inhaltPanel.setContent(table);
                    }else{
                        inhaltPanel.setContent(new Label("Es wurden noch keine Artikel hinzugefügt!"));
                    }
                           
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
