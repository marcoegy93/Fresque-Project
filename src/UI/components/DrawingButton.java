package UI.components;

import javax.swing.*;

import appli.ImagePanelDrawUtil;

public class DrawingButton extends JButton {
    public DrawingButton(String name){
   
        setText(name);
        addActionListener(e -> {
        		ImagePanelDrawUtil.openModalShape(name);

        });
      
    }
    
 
}
