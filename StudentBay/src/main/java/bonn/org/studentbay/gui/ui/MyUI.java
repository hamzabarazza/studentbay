package bonn.org.studentbay.gui.ui;


import javax.servlet.annotation.WebServlet;
import bonn.org.studentbay.gui.*;
import bonn.org.studentbay.gui.view.LoginView;
import bonn.org.studentbay.gui.view.MainView;

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
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    Navigator navi = new Navigator(this, this);
        
    navi.addView("login", LoginView.class);
    navi.addView("main", MainView.class);
    
       UI.getCurrent().getNavigator().navigateTo("main");
    }
    
    

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
