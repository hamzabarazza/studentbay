/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control;

import bonn.org.studentbay.model.objects.dao.ShopDAO;
import bonn.org.studentbay.model.objects.dto.Artikel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lorse
 */
public class MeinShopControl {
    
    
    public static String getMeinShop(Integer user) throws SQLException {
        
        return ShopDAO.getInstance().getMeinShopDAO(user);
        
    }
    
    
    public static List<Artikel> getArtikelShop(Integer userID){
        
        return ShopDAO.getInstance().getArtikelShopDAO(userID);
        
    }
}