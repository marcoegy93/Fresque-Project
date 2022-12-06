package UI.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import appli.ImagePanelDrawUtil;
import fresco.containers.Image;

public class ListPanel extends JPanel{
    private JList<String> listImage;
    
    
public ListPanel(String firstImageName) {
	   DefaultListModel<String> l = new DefaultListModel<>();
	     l.addElement(firstImageName);
	     listImage= new JList<>(l);
	     
	     listImage.setPreferredSize(new Dimension(250,550));
	     listImage.setSelectedIndex(0);
	     listImage.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				ImagePanelDrawUtil.setCurrentImage(listImage.getSelectedValue());
			}
		
	     
	     });
	     add( listImage);
	     
	     
	     JButton addNewImageBtn = new JButton("Add New Image");
	     addNewImageBtn.setPreferredSize(new Dimension(250,30));
	     addNewImageBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ImagePanelDrawUtil.addNewImageBtnClick();
				}
			});
	     
	     add(addNewImageBtn);
	     
	     
	    JButton showDrawing = new JButton("Show the Drawing");
	    showDrawing.setPreferredSize(new Dimension(250,30));

		    showDrawing .addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ImagePanelDrawUtil.showDrawingChange();

				}   
		    });
		    
		    add(showDrawing);

}
	public void setNewDataOnList(Set<Image> Images) {
		 String[] l = new String[ Images.size()];
	     int index = 0;
		 for(Image image :   Images) {
			l[index]=image.getName(); 
			index++;
		 }
	     listImage.setListData(l)  ;
	     listImage.setSelectedIndex( Images.size()-1);
	}


}
