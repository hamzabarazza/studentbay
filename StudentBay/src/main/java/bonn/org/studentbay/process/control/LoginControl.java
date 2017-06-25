/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.model.objects.dao.LoginDAO;
import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.exceptions.NoSuchUserOrPassword;
import com.vaadin.ui.UI;
import java.sql.SQLException;

/**
 *
 * @author jens
 */
public class LoginControl {

    
    public static User checkAuthenticaton(String login, String password) throws NoSuchUserOrPassword, SQLException{
        User user = LoginDAO.getInstance().checkAuthenticatonDAO(login, password);
        return user;
               
    }
}
