/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import bonn.org.studentbay.process.control.exceptions.DatabaseException;
import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.LoginControl;
import bonn.org.studentbay.services.db.JDBCConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class UserDAO{

    private static UserDAO dao = null;
    
    private UserDAO(){
        
    }
    
    public static UserDAO getInstance(){
        if ( dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }
    
    public String getUsernameForUser( User user) throws SQLException{
        Statement statement = null;
        
        statement = JDBCConnection.getInstance().getStatement();
        
        
        ResultSet rs = null;
        
        try{
            rs = statement.executeQuery("SELECT * FROM studentbay.nutzer");
        } catch (SQLException ex){
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (rs == null) {
            return null;
        }
        
        String username = null;
        
        try {
            username = rs.getString(2);
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        username = rs.getString(2);
        
        return username;
        
        
    }    
    
}
