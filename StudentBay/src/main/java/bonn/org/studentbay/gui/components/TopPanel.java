/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.components;

import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import static com.vaadin.server.Sizeable.UNITS_EM;
import com.vaadin.server.VaadinService;
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
       
       
         setWidth("100%");
        
        Boolean userLoggedIn = false;
  
        
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
        suche.addClickListener((Button.ClickEvent e) -> {
            //Aktion beim Suchebutton
        });
        suchFeld.addComponents(suchEingabe, suche);
        
        
        
      //Wenn eingeloggt dann Benutzername, sonst Login-Link--------------------------
      
        String username = User.getUsername();
       
          
          
       
        HorizontalLayout userLogReg = new HorizontalLayout();


        Boolean loginStatus = User.getLogged();
        if(!loginStatus){
        // Button zur RegistrationView
        Button mainToRegView = new Button("Registrieren");
        mainToRegView.addClickListener((Button.ClickEvent e)->{
            UI.getCurrent().getNavigator().navigateTo("registration");
        });
      
        
        // Button zur LoginView
        Button mainToLogin = new Button("Login");
        mainToLogin.addClickListener((Button.ClickEvent e)->{
            UI.getCurrent().getNavigator().navigateTo("login");
        });
        
        
        userLogReg.addComponents(mainToLogin, mainToRegView);
        }else{
        Label user = new Label("Hallo " + username + "!");
        user.setStyleName("benutzer");
        
        
        // Button zu ProfileView
        Button mainToProfile = new Button("Profile");
        mainToProfile.addClickListener((Button.ClickEvent e )->{
            UI.getCurrent().getNavigator().navigateTo("profile");
        });
        
        
         // Button zum Logout
        Button logout = new Button("Logout");
        logout.addClickListener((Button.ClickEvent e)->{
           
            getSession().getSession().invalidate();
            Page.getCurrent().reload();
          
              Notification notif = new Notification(
                " Auf Wiedersehen!",
                "Erfolgreich ausgeloggt!",
                Notification.TYPE_WARNING_MESSAGE);

            // Customize it
            notif.setDelayMsec(5000);

            // Show it in the page
            notif.show(Page.getCurrent());
            
             
        });
        
        
        userLogReg.addComponents( user, logout);
        
        }
        
        
        // Topleiste Inhalt + Alignment
        topLeiste.setWidth("100%");
        topLeiste.addComponents(begruessung, suchFeld, userLogReg);
        topLeiste.setComponentAlignment(userLogReg, Alignment.TOP_RIGHT);
        //topLeiste.setComponentAlignment(mainToLogin, Alignment.TOP_RIGHT);
        //topLeiste.setComponentAlignment(user, Alignment.TOP_RIGHT);
        topLeiste.setComponentAlignment(begruessung, Alignment.TOP_LEFT);
        topLeiste.setComponentAlignment(suchFeld, Alignment.TOP_CENTER);
        
        
        addComponent(topLeiste);
        
    }
    
     
     
    
}
