/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.model.objects.dao.RegistrierungsDAO;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import com.vaadin.ui.UI;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author jens
 */
public class RegistrationControl{
    
    public RegistrationControl(){  
    }
    
    public static void registerUser(String username, String vorname, String nachname, Date geburtstag, String email, String password) throws RegisterFail, SQLException{
          
            RegistrierungsDAO.getInstance().registerUserDAO(username,vorname,nachname,geburtstag,email,password);
            
            UI.getCurrent().getNavigator().navigateTo("main");
         
    }
    
}
