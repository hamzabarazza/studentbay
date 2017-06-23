/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.model.objects.dto;

/**
 *
 * @author jens
 */
public class Fachbereich {
    
    private Integer fachbereichID;
    private String fachbereichBezeichnung;
    
    public Fachbereich(Integer fachbereichID, String fachbereichBezeichnung){
        this.fachbereichID = fachbereichID;
        this.fachbereichBezeichnung = fachbereichBezeichnung;
    }
    
    public Integer getFachbereichID(){
        return this.fachbereichID;
    }
    
    public void setFachbereichID(Integer neuFachbereichID){
        this.fachbereichID = neuFachbereichID;
    }
    
    public String getFachbereichBezeichnung(){
        return this.fachbereichBezeichnung;
    }
    
    public void setFachbereichBezeichnung(String neuFachbereichBezeichnung){
        this.fachbereichBezeichnung = neuFachbereichBezeichnung;
    }
    
}
