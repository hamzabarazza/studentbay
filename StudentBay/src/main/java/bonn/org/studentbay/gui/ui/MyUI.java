package bonn.org.studentbay.gui.ui;
import javax.servlet.annotation.WebServlet;
import bonn.org.studentbay.gui.*;
import bonn.org.studentbay.gui.view.AddArtikelView;
import bonn.org.studentbay.gui.view.AddShopView;
import bonn.org.studentbay.gui.view.LoginView;
import bonn.org.studentbay.gui.view.MainView;
import bonn.org.studentbay.gui.view.MeinShopView;
import bonn.org.studentbay.gui.view.ProfileView;
import bonn.org.studentbay.gui.view.RegistrationView;
import bonn.org.studentbay.gui.view.SucheView;
import com.vaadin.annotations.PreserveOnRefresh;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Title("StudentBay")
@PreserveOnRefresh
public class MyUI extends UI {

    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    Navigator navi = new Navigator(this, this);
        
    navi.addView("login", LoginView.class);
    navi.addView("main", MainView.class);
    navi.addView("registration", RegistrationView.class);
    navi.addView("profile", ProfileView.class);
    navi.addView("addshop", AddShopView.class);    
    navi.addView("addartikel", AddArtikelView.class);
    navi.addView("suche", SucheView.class);
    navi.addView("meinshop", MeinShopView.class);
    
       UI.getCurrent().getNavigator().navigateTo("main");
    }
    
    

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
