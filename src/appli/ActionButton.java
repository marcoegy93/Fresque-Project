package appli;



import javax.swing.*;

public class ActionButton extends JButton {
    public ActionButton(String name){
   
        setText(name);
        addActionListener(e -> {
        		ImagePanelDrawUtil.openModalAction(name);
        });
      
    }
    
 
}
