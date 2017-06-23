/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.LoginControl;
import bonn.org.studentbay.services.db.JDBCConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class UserDAO{

    private static UserDAO dao = null;
   
    private Integer userID = null;
    private String userVorname = null;
    private String userNachname = null;
    private Date userGeburtstag = null;
    private String userEmail = null;
    private String userPassword = null;
    private String userUsername = null;
    private Integer userFachbereichID = null;
    private Integer userShopID = null;
    private User userData = null;
    
    private UserDAO(){
        
    }
    
    public static UserDAO getInstance(){
        if ( dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }
    
    public User getDataForUser(String username) throws SQLException{
        Statement statement = null;
        
        statement = JDBCConnection.getInstance().getStatement();
        ResultSet rs = null;
        
        
        try{
            rs = statement.executeQuery("SELECT * FROM studentbay.nutzer WHERE studentbay.nutzer.username = \'" + username + "\'");
        } catch (SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (rs == null) {
            return null;
        }
        
        
        
        try {
            
            userID = rs.getInt(1);
            userVorname = rs.getString(2);
            userNachname = rs.getString(3);
            userGeburtstag = rs.getDate(10);
            userEmail = rs.getString(3);
            userPassword = rs.getString(4);
            userUsername = rs.getString(9);
            userFachbereichID = rs.getInt(11);
            userShopID = rs.getInt(12);
           
            userData = new User(userID, userUsername , userVorname, userNachname, userGeburtstag, userEmail, userPassword,userFachbereichID);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return userData;
        
        
    }    
    
    
    
}
