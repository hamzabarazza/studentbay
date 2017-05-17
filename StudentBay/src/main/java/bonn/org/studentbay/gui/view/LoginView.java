/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Lorse
 */
public class LoginView extends VerticalLayout implements View{
public void setUp(){
    
    TextField username = new TextField();
    username.setCaption("Benutzername");
    
    
    PasswordField password = new PasswordField();
    password.setCaption("Passwort");
    
    
    VerticalLayout loginscreen = new VerticalLayout();
    loginscreen.addComponents(username, password);
    
    Panel login = new Panel("Bitte Loggen Sie sich hier ein:");
    this.addComponent(login);
    this.setComponentAlignment(login, Alignment.MIDDLE_CENTER);
    
    login.setContent(loginscreen);
    login.setSizeUndefined();
    Button loginButton = new Button("Login", FontAwesome.ARROW_RIGHT);
    
    loginscreen.addComponent(loginButton);
    
            
}
    
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
    
    
    
    
    
}
