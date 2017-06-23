/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.model.objects.dao.LoginDAO;
import bonn.org.studentbay.process.control.exceptions.NoSuchUserOrPassword;
import com.vaadin.ui.UI;

/**
 *
 * @author jens
 */
public class LoginControl {

    
    public static void checkAuthenticaton(String login, String password) throws NoSuchUserOrPassword{
        
        LoginDAO.getInstance().checkAuthenticatonDAO(login, password);
        
        UI.getCurrent().getNavigator().navigateTo("main");
               
    }
}
