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
import bonn.org.studentbay.process.control.SearchControl;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Table;
/**
 *
 * @author Lorse
 */
public class SucheView extends VerticalLayout implements View{
    
    public void setUp(){
        
        
        Panel inhaltPanel = new Panel("");
        Label inhalt = new Label();
        
        VaadinSession session = UI.getCurrent().getSession();
        String suchText =  (String)session.getAttribute(Roles.CURRENT_SEARCH);
        
       
       BeanContainer<Integer,Artikel> data = new BeanContainer<Integer,Artikel>(Artikel.class);
       data.setBeanIdProperty("id");
       Table table = new Table("Treffer", data);
       table.setSizeFull();
       table.setSelectable(true);
       
       List list =  SearchControl.getInstance().getArtikelByName(suchText);
       data.removeAllItems();
       data.addAll(list);
       
       
        inhalt.setValue(table);
        inhaltPanel.setCaption("Ihre Suche zu \"" + suchText + "\" ergab folgende Treffer:");
      
        inhaltPanel.setContent(inhalt);
        
         inhaltPanel.setStyleName("content_block"); 
        
        
       
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

   

