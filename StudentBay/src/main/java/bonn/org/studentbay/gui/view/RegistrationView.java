/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.AbstractErrorMessage;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author jens
 */
public class RegistrationView extends VerticalLayout implements View {
    public void setUp(){
        
        TextField benutzername = new TextField();
        benutzername.setCaption("Benutzername: ");
        
        TextField vorname = new TextField();
        vorname.setCaption("Vorname: ");
                
        TextField nachname = new TextField();
        nachname.setCaption("Nachname: ");
                
        DateField geburtstag = new DateField();
        geburtstag.setCaption("Geburtstag: ");
        
        TextField email = new TextField();
        email.setCaption("Email: ");
        
        PasswordField passwort = new PasswordField();
        passwort.setCaption("Passwort: ");
        
        PasswordField passworterneut = new PasswordField();
        passworterneut.setCaption("Passwort erneut eingeben: ");
          
        VerticalLayout registrationLayout = new VerticalLayout();
        registrationLayout.addComponents(benutzername, vorname, nachname, geburtstag, email, passwort, passworterneut);
        
        Panel registrationPanel = new Panel("Konto erstellen");
        registrationPanel.setSizeUndefined();

        this.addComponent(registrationPanel);
        this.setComponentAlignment(registrationPanel, Alignment.MIDDLE_CENTER);
        
        
        registrationPanel.setStyleName("center");
        registrationPanel.setContent(registrationLayout);
        // registrationPanel.setSizeUndefined();
        
        Button registrationButton = new Button("Registrieren", FontAwesome.ARROW_RIGHT);
        this.addComponent(registrationButton);
        this.setComponentAlignment(registrationButton, Alignment.MIDDLE_CENTER);
         
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
}
