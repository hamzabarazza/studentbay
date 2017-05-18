/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import bonn.org.studentbay.gui.ui.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.UI;

/**
 *
 * @author Lorse
 */
public class MainView extends VerticalLayout implements View{

    public void setUp() {
        //Äußester Rahmen----------------------------------------------------
        
        setWidth("100%");
        
        //Top Leiste----------------------------------------------------
        HorizontalLayout topLeiste = new HorizontalLayout();
        
        
        //Begrüßungstext----------------------------------------------------
        Label begruessung = new Label("[LOGO] Herzlich Willkommen! ");
        
        
        //Layout für die Suche---------------------------------------
        HorizontalLayout suchFeld = new HorizontalLayout();
        final TextField suchEingabe = new TextField();
        Button suche = new Button("Suchen", FontAwesome.SEARCH);
        suche.addClickListener((Button.ClickEvent e) -> {
            //Aktion beim Suchebutton
        });
        suchFeld.addComponents(suchEingabe, suche);
        
        
        //Wenn eingeloggt dann Benutzername, sonst Login-Link--------------------------
        Label user = new Label("User1234");
       
        
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
        
        // Topleiste Inhalt + Alignment
        topLeiste.setWidth("100%");
        topLeiste.addComponents(begruessung, suchFeld, mainToRegView, mainToLogin, user);
        topLeiste.setComponentAlignment(mainToRegView, Alignment.TOP_RIGHT);
        topLeiste.setComponentAlignment(mainToLogin, Alignment.TOP_RIGHT);
        topLeiste.setComponentAlignment(user, Alignment.TOP_RIGHT);
        topLeiste.setComponentAlignment(begruessung, Alignment.TOP_LEFT);
        topLeiste.setComponentAlignment(suchFeld, Alignment.TOP_CENTER);
        
        
        //Navigation----------------------------------------------------
        HorizontalLayout navigation = new HorizontalLayout();
        Label platzhalter = new Label("----Hier kommt die Naviogationsleiste hin----");
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
        content.addComponent(new Label("Favoriten:"));
        content.addComponent(new Label("Shop 1"));
        content.addComponent(new Label("Shop 2"));
        content.addComponent(new Label("Shop 3"));
        content.addComponent(new Label("Shop 4"));
        content.addComponent(new Label("-----------------"));
        
        
        //Wichtige Informationen----------------------------------------------------
        Label informationen = new Label("Wichtige Informationen Rund um das Shoppingsystem. Hier finden Sie unter anderem auch sonderaktionen oder Rabattcodes.");
        informationen.setWidth("200px");
        content.addComponent(informationen);
        newsfeed.setContent(content);
        
        
        //Content-----------------------------------------------------------------
        Panel inhaltPanel = new Panel("");
        inhaltPanel.setWidth("100%");
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
