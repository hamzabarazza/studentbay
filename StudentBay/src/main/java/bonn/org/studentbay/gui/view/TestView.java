/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.gui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Lorse
 */
public class TestView extends VerticalLayout implements View{

    public void setUp(){
        Label label = new Label("Leeeer");
        this.addComponent(label);
    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
       this.setUp();
    }
    
}
