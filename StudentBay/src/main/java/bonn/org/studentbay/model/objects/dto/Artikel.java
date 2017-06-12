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
public class Artikel {
    
    private String artikelName;
    private String artikelBeschreibung;
    private String artikelKategorie;
    private Integer artikelID;
    
    public Artikel(){
    }
    
    public Artikel(String artikelname, String beschreibung, String kategorie){
        this.artikelName = artikelname;
        this.artikelBeschreibung = beschreibung;
        this.artikelKategorie = kategorie;
    }

    public Integer getID(){
        return this.artikelID;
    }

    public String getArtikelname(){
        return this.artikelName;
    }
    
    public void setArtikelname(String neuArtikelName){
        this.artikelName = neuArtikelName;
    }
    
    public String getArtikelBeschreibung(){
        return this.artikelBeschreibung;
    }
    
    public void setArtikelBeschreibung(String neuArtikelBeschreibung){
        this.artikelBeschreibung = neuArtikelBeschreibung;
    }
    
    public String getArtikelKategorie(){
        return this.artikelKategorie;
    }
    
    public void setArtikelKategorie(String neuArtikelKategorie){
        this.artikelKategorie = neuArtikelKategorie;
    }
}

