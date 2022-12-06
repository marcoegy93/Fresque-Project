package UI.components;



import javax.swing.*;

import appli.ImagePanelDrawUtil;

public class ActionButton extends JButton {
    public ActionButton(String name){
   
        setText(name);
        addActionListener(e -> {
        		ImagePanelDrawUtil.openModalAction(name);
        });
      
    }
    
 
}
