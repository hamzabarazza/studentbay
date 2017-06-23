/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

/**
 *
 * @author jens
 */
public class ShopDAO {
    
    private static ShopDAO dao = null;
    
    private ShopDAO(){
        
    }
    
    public static ShopDAO getInstance(){
        if ( dao == null) {
            dao = new ShopDAO();
        }
        return dao;
    }
    
}
