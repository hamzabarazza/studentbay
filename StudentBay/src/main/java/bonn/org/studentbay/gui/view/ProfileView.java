/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author jens
 */
public class ProfileView extends VerticalLayout implements View{
    
    public void setUp(){
        
        Label usernameAnzeige = new Label("Username : ");
        Label vornameAnzeige = new Label("Vorname : ");
        Label nachnameAnzeige = new Label("Nachname : ");
        Label emailAnzeige = new Label("Email : ");
        
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
}
