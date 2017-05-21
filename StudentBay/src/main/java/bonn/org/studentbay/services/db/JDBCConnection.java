/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.services.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class JDBCConnection {
    
    private static JDBCConnection connection = null;
    private String url = "jdbc:postesql://dumbo.inf.fh-bonn-rhein-sieg.de/atheis2s";
    private String login = "atheis2s";
    private String password = "atheis2s";
    private Connection conn;
    
    public static JDBCConnection getInstance(){
        if (connection == null) {
            connection = new JDBCConnection();
        }
        return connection;
    }
    
    private JDBCConnection(){
        this.initConnection();
    }
    
    public void initConnection(){
        try{
            DriverManager.registerDriver( new org.postgresql.Driver());
        } catch( SQLException ex){
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.openConnection();
    } 
    
    public void openConnection(){
        
        try{
            Properties props = new Properties();
            props.setProperty("user","atheis2s");
            props.setProperty("password", "atheis2s");
        
            this.conn = DriverManager.getConnection(this.url, props);
        } catch (SQLException ex){
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }    
       
    public Statement getStatement(){
        try {
            if( this.conn.isClosed()){
                this.openConnection();
            }
            return this.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  
    }
    
    public void closeConnection(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
                
}
    
    

