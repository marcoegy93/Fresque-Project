package App;

import java.awt.Dimension;


import Panels.FrescoPanel;

public class main {

	
	public static void main(String[] args) {
		
		GraphiqueInterface GI = new GraphiqueInterface();
	    
	    GI.add(new FrescoPanel());
	    //GI.add(Box.createRigidArea(new Dimension(5,0)));
	  //  GI.add(new GraphiquePanel());

	}
	

}
