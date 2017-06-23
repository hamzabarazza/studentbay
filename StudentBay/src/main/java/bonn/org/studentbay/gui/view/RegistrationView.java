/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import bonn.org.studentbay.model.objects.dao.RegistrierungsDAO;
import bonn.org.studentbay.model.objects.dto.Fachbereich;
import bonn.org.studentbay.process.control.RegistrationControl;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author jens
 */
public class RegistrationView extends VerticalLayout implements View {
    public void setUp(){
        
        List<Fachbereich> fachbereiche = new ArrayList<>();
        fachbereiche.add(new Fachbereich(1,"Wirtschaftswissenschaften"));
        fachbereiche.add(new Fachbereich(2,"Informatik"));
        fachbereiche.add(new Fachbereich(3,"EMT"));
        fachbereiche.add(new Fachbereich(5,"Angewandte Naturwissenschaften"));
        fachbereiche.add(new Fachbereich(6,"Sozialversicherung"));
        
        
        final TextField usernameField = new TextField();
        usernameField.setCaption("Benutzername*");
        
        final TextField vornameField = new TextField();
        vornameField.setCaption("Vorname*");
                
        final TextField nachnameField = new TextField();
        nachnameField.setCaption("Nachname*");
                
        final DateField geburtstagField = new DateField();
        geburtstagField.setCaption("Geburtstag*");
        
        final TextField emailField = new TextField();
        emailField.setCaption("Email*");
        
        final PasswordField passwordField = new PasswordField();
        passwordField.setCaption("Passwort*");
        
        final PasswordField passworderneutField = new PasswordField();
        passworderneutField.setCaption("Passwort erneut eingeben*");
        
        final CheckBox agbacceptBox = new CheckBox("AGB Akzeptieren*");
        
        
        /*
        // Regestrierungs Kriterien
        // Username Kritieren
        Label usernameKritierien = new Label("Benutzername muss 5-16 Zeichen lang sein.");
        this.addComponent(usernameKritierien);
        this.setComponentAlignment(usernameKritierien, Alignment.MIDDLE_RIGHT);
        
        // Email Kritieren
        Label emailKritierien = new Label("Email muss gültige Email-Adresse sein.");
        this.addComponent(emailKritierien);
        this.setComponentAlignment(emailKritierien, Alignment.MIDDLE_RIGHT);
        
        // Password Kritierien
        Label passwordKritierien = new Label("Passwörter müssen übereinstimmen und  mindestens 6 Zeichen lang sein.");
        this.addComponent(passwordKritierien);
        this.setComponentAlignment(passwordKritierien, Alignment.MIDDLE_RIGHT);
        
        // AGB Kritieren
        Label agbKritierien = new Label("AGB müssen akzeptiert werden.");
        this.addComponent(agbKritierien);
        this.setComponentAlignment(agbKritierien, Alignment.MIDDLE_RIGHT);
        
        */
        
        // Vertical Layout Box
        VerticalLayout registrationLayout = new VerticalLayout();
        registrationLayout.addComponents(usernameField, vornameField, nachnameField, geburtstagField, emailField, passwordField, passworderneutField,agbacceptBox);
        
        Panel registrationPanel = new Panel("Konto erstellen");
        registrationPanel.setSizeUndefined();

        this.addComponent(registrationPanel);
        this.setComponentAlignment(registrationPanel, Alignment.MIDDLE_CENTER);
        
       
        registrationPanel.setStyleName("center");
        registrationPanel.setContent(registrationLayout);
        // registrationPanel.setSizeUndefined();
        
        Button registrationButton = new Button("Registrieren", FontAwesome.ARROW_RIGHT);
       
        registrationButton.addClickListener(new Button.ClickListener(){
        
        @Override
        public void buttonClick(Button.ClickEvent event){
           
            // Attribute
            String username = usernameField.getValue();
            String vorname = vornameField.getValue();
            String nachname = nachnameField.getValue();
            Date geburtstag = geburtstagField.getValue();
            String email = emailField.getValue();
            String password = passwordField.getValue();
            String passworderneut = passworderneutField.getValue();
            Boolean agb = agbacceptBox.getValue();
            
            // Regeln
            // Username Regel , username muss mindestens 5 Zeichen lang sein
            if(username.length() < 5 || username.length() > 16){
                Notification.show("Fehler","Eingegebener Username zu kurz!", Notification.Type.ERROR_MESSAGE);
                passwordField.setValue("");
                passworderneutField.setValue("");
                
            }
            
            // Email Regel , emailField muss gültige Email sein
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(email);
            boolean matchFound = m.matches();
            if (!matchFound) {
                Notification.show("Fehler","Eingegebene Email nicht gültig!", Notification.Type.ERROR_MESSAGE);
                passwordField.setValue("");
                passworderneutField.setValue("");
            }
            
            // Password Regel , passwordField und passworderneutField muss übereinstimmen
            if (!password.equals(passworderneut) || password.length() < 6) {
                Notification.show("Fehler","Eingegebene Passwörter stimmen nicht überein oder sind zu kurz!", Notification.Type.ERROR_MESSAGE);
                passwordField.setValue("");
                passworderneutField.setValue("");
            }
            
            // AGBs Akzeptieren
            if (!agb) {
                Notification.show("Fehler","Bitte AGB akzeptieren!", Notification.Type.ERROR_MESSAGE);
                passwordField.setValue("");
                passworderneutField.setValue("");
            }
            
            // Checke ob Username oder Email schon vergeben sind
            boolean usernameCheck = RegistrierungsDAO.getInstance().checkUsernameExists(username);
            boolean emailCheck = RegistrierungsDAO.getInstance().checkEmailExists(email);
            
            if (!emailCheck) {
                Notification.show("Fehler","Email schon vergeben!",Notification.Type.ERROR_MESSAGE);
            }
            
            if (!usernameCheck) {
                Notification.show("Fehler","Username schon vergeben!",Notification.Type.ERROR_MESSAGE);
            }
            
            
            
            // Regestrierungs loschicken an DB
            try{
                if (agb && password.equals(passworderneut) && password.length() > 5 && matchFound && username.length() > 5 && username.length() < 16 && emailCheck && usernameCheck){
                    RegistrationControl.registerUser(username, vorname, nachname, geburtstag, email, password);
                }
            } catch (RegisterFail ex) {   
                Logger.getLogger(RegistrationView.class.getName()).log(Level.SEVERE, null, ex);
                Notification.show("Fehler","Registrierung fehlgeschlagen", Notification.Type.ERROR_MESSAGE);
                passwordField.setValue("");
                passworderneutField.setValue("");
            }   
               
                        
            
            
            
        }     
    });
        
      Button cancelButton = new Button("Zurück", FontAwesome.ARROW_LEFT);
   
    cancelButton.addClickListener(new Button.ClickListener(){
        
        @Override
        public void buttonClick(Button.ClickEvent event){
           
             UI.getCurrent().getNavigator().navigateTo("main");
        }  

    });  
        
        
       HorizontalLayout buttons = new HorizontalLayout();
     buttons.addComponent(cancelButton);
     buttons.addComponent(registrationButton);
     addComponent(buttons);
     
    setComponentAlignment(buttons, Alignment.MIDDLE_CENTER);
    
     
        
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
}
