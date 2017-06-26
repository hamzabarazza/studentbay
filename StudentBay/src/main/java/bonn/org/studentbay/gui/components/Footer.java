/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 *
 * @author Lorse
 */
public class Footer extends HorizontalLayout{

    
    public Footer(){
        setWidth("100%");
         HorizontalLayout footer = new HorizontalLayout();
        Label kontakt = new Label("Kontakt -");
        Label impressum = new Label("- Impressum");
        footer.setWidth("100%");
        HorizontalLayout footerPanel = new HorizontalLayout();
        footer.addComponent(footerPanel);
        footerPanel.addComponents(kontakt, impressum);
        footer.setComponentAlignment(footerPanel, Alignment.MIDDLE_CENTER);
        
        addComponent(footer);
    }
}
