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
    
    private boolean geloggt = false;
    private Integer userID;
    private String username;
    private String vorname;
    private String nachname;
    private Date geburtstag;
    private String email;
    private String passwort;
    private Integer fachbereichID;
    
    public User(){ 
    }
    
    public User(Integer userID, String username ,String vorname, String nachname, Date geburtstag, String email, String passwort, Integer fachbereichID){ 
        this.userID = userID;
        this.username= username;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
        this.email = email;
        this.passwort = passwort;
        this.geloggt = true;
        this.fachbereichID = fachbereichID;
    }
    
    
    
    
    public Boolean getLogged(){
        return  geloggt;
    }
    
     public void setLogged(Boolean wert){
        this.geloggt = wert;
    }
     
    
    public Integer getID(){
        return this. userID;
    }
    
     public void setID(Integer id){
        this.userID = id;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String neuUsername){
        this.username = neuUsername;
    }
    
    public String getVorname(){
        return vorname;
    }
    
    public void setVorname(String neuVorname){
        this.vorname = neuVorname;
    }
    
    public String getNachname(){
        return nachname;
    }

    public void setNachname(String neuNachname){
        this.nachname = neuNachname;
    }

    public Date getGeburtstag(){
       return geburtstag;
    }
    
    public void setGeburtstag(Date neuGeburtstag){
        this.geburtstag = neuGeburtstag;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String neuEmail){
        this.email = neuEmail;
    }
    
    public String getPasswort(){
        return passwort;
    }
    
    public void setPasswort(String neuPasswort){
        this.passwort = neuPasswort;
    }
    
    public Integer getFachbereichID(){
        return this.fachbereichID;
    }
    
    public void setFachbereichID(Integer neuFachbereichID){
        this.fachbereichID = neuFachbereichID;
    }
    
}
