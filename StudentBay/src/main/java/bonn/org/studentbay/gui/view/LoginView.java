/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import bonn.org.studentbay.gui.components.TopPanel;
import bonn.org.studentbay.process.control.LoginControl;
import bonn.org.studentbay.process.control.exceptions.NoSuchUserOrPassword;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
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
public class LoginView extends VerticalLayout implements View{
public void setUp(){
    
    
    TextField username = new TextField();
    username.setCaption("Benutzername");
    
    
    PasswordField passwordField = new PasswordField();
    passwordField.setCaption("Passwort");
    
    
    VerticalLayout loginscreen = new VerticalLayout();
    loginscreen.addComponents(username, passwordField);
    
    Panel login = new Panel("Bitte Loggen Sie sich hier ein:");
    this.addComponent(login);
    this.setComponentAlignment(login, Alignment.MIDDLE_CENTER);
    
    login.setContent(loginscreen);
    login.setSizeUndefined();
    Button loginButton = new Button("Login", FontAwesome.ARROW_RIGHT);
   
    loginButton.addClickListener(new Button.ClickListener(){
        
        @Override
        public void buttonClick(Button.ClickEvent event){
           
            String login = username.getValue();
            String password = passwordField.getValue();
            try {
                
                LoginControl.checkAuthenticaton(login, password);
            
            }catch (NoSuchUserOrPassword ex){
                // UI.getCurrent().getNavigator().navigateTo("login");
                Notification.show("Fehler","Login oder Password falsch!", Notification.Type.ERROR_MESSAGE);
                username.setValue("");
                passwordField.setValue("");
        
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
     buttons.addComponent(loginButton);
     addComponent(buttons);
     
    setComponentAlignment(buttons, Alignment.MIDDLE_CENTER);
    
    
    
    
    
    
}    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
    
    
    
    
    
}
