/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.components;

import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.LogoutControl;
import bonn.org.studentbay.process.control.SearchControl;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import static com.vaadin.server.Sizeable.UNITS_EM;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.io.File;

/**
 *
 * @author Lorse
 */
public class TopPanel extends HorizontalLayout{

    
    public TopPanel(){
    
       // Label bla = new Label("askjnfkasjf");
       // addComponent(bla);
       
       VaadinSession session = UI.getCurrent().getSession();
       User user = (User) session.getAttribute(Roles.CURRENT_USER);
         setWidth("100%");
        setMargin(true);
     
        //Top Leiste----------------------------------------------------
        HorizontalLayout topLeiste = new HorizontalLayout();
        
        
       //Logo----------------------------------------------------
    
         // Find the application directory
        String basepath = VaadinService.getCurrent()
                          .getBaseDirectory().getAbsolutePath();

        // Image as a file resource
        FileResource resource = new FileResource(new File(basepath +
                                "/META-INF/logo.png"));

        // Show the image in the application
        Image begruessung = new Image("",resource);
        begruessung.setWidth(20, UNITS_EM);
        begruessung.setStyleName("logo");
        
        
        
        //Layout für die Suche---------------------------------------
        HorizontalLayout suchFeld = new HorizontalLayout();
        final TextField suchEingabe = new TextField();
        Button suche = new Button("Suchen", FontAwesome.SEARCH);
        suche.addClickListener(e ->  {
            //Aktion beim Suchebutton
            
         
         if(suchEingabe.getValue().equals("")){
            Notification.show(null,"Bitte geben Sie ein Suchwort ein!", Notification.Type.WARNING_MESSAGE);
        }else{   
                //Suchwort in Session speichern
                session.setAttribute(Roles.CURRENT_SEARCH, suchEingabe.getValue());
                //SearchControl.suchausgabe(suchEingabe.getValue());    
                //weiterleiten zu Suchview
                UI.getCurrent().getNavigator().navigateTo("suche");
                }   
        
            
        });
        suchFeld.addComponents(suchEingabe, suche);
        
        
        
      //Wenn eingeloggt dann Benutzername, sonst Login-Link--------------------------
      
        
       
          
          
       
        HorizontalLayout userLogReg = new HorizontalLayout();

        
        //Nur wenn eingeloggt
       Boolean status;
       if(user==null){status = false;}else{status = true;}
        if(!status){
        // Button zur RegistrationView
        Button mainToRegView = new Button("Registrieren");
        mainToRegView.addClickListener(e -> {
            UI.getCurrent().getNavigator().navigateTo("registration");
        });
      
        
        // Button zur LoginView
        Button mainToLogin = new Button("Login");
        mainToLogin.addClickListener(e -> {
            UI.getCurrent().getNavigator().navigateTo("login");
        });
        
        
        userLogReg.addComponents(mainToLogin, mainToRegView);
        }else{
            
        Label userWelcome = new Label("Hallo " + user.getUsername() + "!");
        userWelcome.setStyleName("benutzer");
        
        
        // Button zu ProfileView
        Button mainToProfile = new Button("Profile");
        mainToProfile.addClickListener((Button.ClickEvent e )->{
            UI.getCurrent().getNavigator().navigateTo("profile");
        });
        
        
         // Button zum Logout
        Button logout = new Button("Logout");
        logout.addClickListener(e -> {
           LogoutControl.logout();
            
             
        });
        
        
        userLogReg.addComponents( userWelcome, logout);
        
        }
        
        
        // Topleiste Inhalt + Alignment
        topLeiste.setWidth("100%");
        topLeiste.addComponents(begruessung, suchFeld, userLogReg);
        topLeiste.setComponentAlignment(userLogReg, Alignment.TOP_RIGHT);
        //topLeiste.setComponentAlignment(mainToLogin, Alignment.TOP_RIGHT);
        //topLeiste.setComponentAlignment(user, Alignment.TOP_RIGHT);
        topLeiste.setComponentAlignment(begruessung, Alignment.TOP_LEFT);
        topLeiste.setComponentAlignment(suchFeld, Alignment.TOP_CENTER);
        
        topLeiste.setMargin(true);
        addComponent(topLeiste);
        
    }
    
     
     
    
}
