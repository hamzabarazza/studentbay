/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import bonn.org.studentbay.gui.components.Footer;
import bonn.org.studentbay.gui.components.NavMenu;
import bonn.org.studentbay.gui.components.TopPanel;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Video;

/**
 *
 * @author Lorse
 */
public class VideoView extends VerticalLayout  implements View {

    
    
    public void setUp(){
        
        //Content-----------------------------------------------------------------
        Panel inhaltPanel = new Panel("Video ansehen");
        inhaltPanel.setStyleName("content_block");
        
       
        VerticalLayout addShopPanel = new VerticalLayout();    
           
          
        
//        
//
//            final Video v = new Video( "" );
//            v.setSources( 
//            new ExternalResource( "https://www.youtube.com/watch?v=qa6Y1aGXznM" )
//            );
//
//            v.setWidth( "640px" );
//            v.setHeight( "360px" );
//           
// 
//        Button playButton = new Button("Play video");
//         playButton.addClickListener(new Button.ClickListener(){
//          
//
//            @Override
//            public void buttonClick(Button.ClickEvent event) {
//                  v.play();
//            }
//        });
//         
//           Button pauseButton = new Button("Pause");
//         pauseButton.addClickListener(new Button.ClickListener(){
//          
//
//            @Override
//            public void buttonClick(Button.ClickEvent event) {
//                  v.pause();
//            }
//        });
//         
//            

    Embedded e = new Embedded(null, new ExternalResource(
                "https://www.youtube.com/v/HKqGb787EjQ&hl=en_US&fs=1&"));
e.setMimeType("application/x-shockwave-flash");
e.setParameter("allowFullScreen", "true");
e.setWidth("600px");
e.setHeight("350px");
addComponent(e);
          addShopPanel.addComponent(e);
            
        inhaltPanel.setContent(addShopPanel);
            
    
         HorizontalLayout mitte = new HorizontalLayout();
        mitte.addComponent(new NavMenu()); //Navigation hinzufügen
        
        mitte.addComponent(inhaltPanel); //Content hinzufügen
       
        
       
        
        //Alle Elemente hinzufügen
        addComponents( new TopPanel(),  mitte, new Footer());
        
        
    }
        
        
        
        
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.setUp();
    }
    
}
