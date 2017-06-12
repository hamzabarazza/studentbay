/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import bonn.org.studentbay.gui.ui.MyUI;
import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.LoginControl;
import bonn.org.studentbay.services.util.Roles;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorse
 */
public class MainView extends VerticalLayout implements View{

    public void setUp() {
        //Äußester Rahmen----------------------------------------------------
        
        
        Boolean userLoggedIn = false;
        setWidth("100%");
        
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
      
       User current_user = (User) UI.getCurrent().getSession().getAttribute(Roles.CURRENT_USER);
          String username;
          try {
            username = current_user.getUsername();
            userLoggedIn = true;
        } catch (NullPointerException e) {
            username = "";
        }
       
        HorizontalLayout userLogReg = new HorizontalLayout();


        if(!userLoggedIn){
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
        
        
        //Navigation----------------------------------------------------
        HorizontalLayout navigation = new HorizontalLayout();
        Label platzhalter = new Label("");
        navigation.setWidth("100%");
        navigation.addComponent(platzhalter);
        navigation.setComponentAlignment(platzhalter, Alignment.MIDDLE_CENTER);
        //Mittlerer Bereich (News + Content)
        HorizontalLayout mitte = new HorizontalLayout();
        
        
        //Newsfeed----------------------------------------------------
        Panel newsfeed = new Panel("News");
        newsfeed.setWidth("250px");
        mitte.addComponent(newsfeed);
        
        
        
        //Inhalt des Newsfeeds
        FormLayout content = new FormLayout();
        content.addStyleName("mypanelcontent");
        //Favoriten-------------------------------------------------------
        if(userLoggedIn){
        content.addComponent(new Label("Favoriten:"));
        content.addComponent(new Label("Shop 1"));
        content.addComponent(new Label("Shop 2"));
        content.addComponent(new Label("Shop 3"));
        content.addComponent(new Label("Shop 4"));
        content.addComponent(new Label("-----------------"));
        }
        
        //Wichtige Informationen----------------------------------------------------
        Label informationen = new Label("Wichtige Informationen Rund um das Shoppingsystem. Hier finden Sie unter anderem auch sonderaktionen oder Rabattcodes.");
        informationen.setWidth("200px");
        content.addComponent(informationen);
        newsfeed.setContent(content);
        
        
        //Content-----------------------------------------------------------------
        Panel inhaltPanel = new Panel("Herzlich Willkommen bei StudentBay!");
        Label text = new Label("Hier erscheint das Suchergebnis!");
        inhaltPanel.setStyleName("content_block");
        mitte.addComponent(inhaltPanel);
        VerticalLayout inhalt = new VerticalLayout();
        //inhalt.addComponent(new Label("Hier ensteht der Inhalt"));
       // inhalt.addComponent(new LoginView());
        //?????????????????????????????????
        mitte.addComponent(inhalt);
        
        
        //Footer-----------------------------------------------------------------
        HorizontalLayout footer = new HorizontalLayout();
        Label kontakt = new Label("Kontakt");
        Label impressum = new Label("Impressum");
        footer.setWidth("100%");
        HorizontalLayout footerPanel = new HorizontalLayout();
        footer.addComponent(footerPanel);
        footerPanel.addComponents(kontakt, impressum);
        footer.setComponentAlignment(footerPanel, Alignment.MIDDLE_CENTER);
        
        //Alle Elemente hinzufügen
        addComponents(topLeiste, navigation, mitte, footer);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
    
}
