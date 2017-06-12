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
public class Shop {
    
    private String shopName;
    private Boolean shopVorkasse;
    private Boolean shopNachnahme;
    private Boolean shopPaypal;
    private Boolean shopRechnung;
    private Boolean shopKreditkarte;
    private Boolean shopLastschrift;
    
    public Shop(){
    }

    public Shop(String shopName, Boolean shopVorkasse, Boolean shopNachnahme, Boolean shopPaypal, Boolean shopRechnung, Boolean shopKreditkarte, Boolean shopLastschrift){
        this.shopName = shopName;
        this.shopVorkasse = shopVorkasse;
        this.shopNachnahme = shopNachnahme;
        this.shopPaypal = shopPaypal;
        this.shopRechnung = shopRechnung;
        this.shopKreditkarte = shopKreditkarte;
        this.shopLastschrift = shopLastschrift;
    }
    
    public String getShopName(){
        return this.shopName;
    }
    
    public void setShopName(String neuShopName){
        this.shopName = neuShopName;
    }
    
    public Boolean getShopVorkasse(){
        return this.shopVorkasse;
    }
  
    public void setShopVorkasse(Boolean neuShopVorkasse){
        this.shopVorkasse = neuShopVorkasse;
    }
    
    public Boolean getShopNachnahme(){
        return this.shopNachnahme;
    }
  
    public void setShopNachnahme(Boolean neuShopNachnahme){
        this.shopNachnahme = neuShopNachnahme;
    }
    
    public Boolean getShopPaypal(){
        return this.shopPaypal;
    }
  
    public void setShopPaypal(Boolean neuShopPaypal){
        this.shopPaypal = neuShopPaypal;
    }
    
    public Boolean getShopRechnung(){
        return this.shopRechnung;
    }
    
    public void setShopRechnung(Boolean neuShopRechnung){
        this.shopRechnung = neuShopRechnung;
    }
    
    public Boolean getShopKreditkarte(){
        return this.shopKreditkarte;
    }
    
    public void setShopKreditkarte(Boolean neuShopKreditkarte){
        this.shopKreditkarte = neuShopKreditkarte;
    }
    
    public Boolean getShopLastschrift(){
        return this.shopLastschrift;
    }
    
    public void setShopLastschrift(Boolean neuShopLastschrift){
        this.shopLastschrift = neuShopLastschrift;
    }
}

