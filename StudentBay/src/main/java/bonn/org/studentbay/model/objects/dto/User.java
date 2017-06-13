/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dto;

import java.util.Date;

/**
 *
 * @author Lorse
 */
public class User implements java.io.Serializable {
    
    private static boolean geloggt = false;
    private Integer userID;
    private static String username;
    private static String vorname;
    private static String nachname;
    private static Date geburtstag;
    private static String email;
    private static String passwort;
    
    public User(){ 
    }
    
    public User(String username ,String vorname, String nachname, Date geburtstag, String email, String passwort){ 
        this.username= username;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
        this.email = email;
        this.passwort = passwort;
        this.geloggt = true;
    }
    
    
    public static Boolean getLogged(){
        return  geloggt;
    }
    
     public void setLogged(Boolean wert){
        this.geloggt = wert;
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
    
    public static String getUsername(){
        return username;
    }
    
    public void setUsername(String neuUsername){
        this.username = neuUsername;
    }
    
    public static String getVorname(){
        return vorname;
    }
    
    public void setVorname(String neuVorname){
        this.vorname = neuVorname;
    }
    
    public static String getNachname(){
        return nachname;
    }

    public void setNachname(String neuNachname){
        this.nachname = neuNachname;
    }

    public static Date getGeburtstag(){
       return geburtstag;
    }
    
    public void setGeburtstag(Date neuGeburtstag){
        this.geburtstag = neuGeburtstag;
    }
    
    public static String getEmail(){
        return email;
    }
    
    public void setEmail(String neuEmail){
        this.email = neuEmail;
    }
    
    public static String getPasswort(){
        return passwort;
    }
    
    public void setPasswort(String neuPasswort){
        this.passwort = neuPasswort;
    }
    
}
