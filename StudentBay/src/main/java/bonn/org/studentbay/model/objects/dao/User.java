/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dao;

import java.util.Date;

/**
 *
 * @author jens
 */
public class User implements java.io.Serializable{

    static private int NEXTID = 1000;
    
    private Integer userID;
    private String username;
    private String vorname;
    private String nachname;
    private Date geburtstag;
    private String email;
    private String passwort;
    
    public User(String username ,String vorname, String nachname, Date geburtstag, String email, String passwort){
        this.userID = NEXTID;
        ++NEXTID;
        this.username= username;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
        this.email = email;
        this.passwort = passwort;
    }
    
    public Integer getID(){
        return this. userID;
    }
    
    /*
    // userID sollte nicht überschrieben werden
    public void setID(Integer neuUserID){
        this.userID = neuUserID;
    }
    */
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String neuUsername){
        this.username = neuUsername;
    }
    
    public String getVorname(){
        return this.vorname;
    }
    
    public void setVorname(String neuVorname){
        this.vorname = neuVorname;
    }
    
    public String getNachname(){
        return this.nachname;
    }

    public void setNachname(String neuNachname){
        this.nachname = neuNachname;
    }

    public Date getGeburtstag(){
       return this.geburtstag;
    }
    
    public void setGeburtstag(Date neuGeburtstag){
        this.geburtstag = neuGeburtstag;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String neuEmail){
        this.email = neuEmail;
    }
    
    public String getPasswort(){
        return this.passwort;
    }
    
    public void setPasswort(String neuPasswort){
        this.passwort = neuPasswort;
    }
    
}
