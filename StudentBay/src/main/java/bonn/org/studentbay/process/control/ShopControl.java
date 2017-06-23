/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.model.objects.dao.ShopDAO;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import com.vaadin.ui.UI;

/**
 *
 * @author jens
 */
public class ShopControl {
    
    public static void registerShop(Integer userID, String shopname, Boolean vorkasse, Boolean nachnahme, Boolean paypal, Boolean rechnung, Boolean kreditkarte, Boolean lastschrift) throws RegisterFail{
  
        ShopDAO.getInstance().registerShopDAO(userID, shopname, vorkasse, nachnahme, paypal, rechnung, kreditkarte, lastschrift);
        
        UI.getCurrent().getNavigator().navigateTo("main");
        
        
    }
    
}
