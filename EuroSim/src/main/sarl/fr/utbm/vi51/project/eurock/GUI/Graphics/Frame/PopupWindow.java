package fr.utbm.vi51.project.eurock.GUI.Graphics.Frame;

import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicComponent.LabelComponent;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Layout.LayoutGUI;

public class PopupWindow extends AbstractFrame {

	public PopupWindow(String message)
	{
		super("Popup", 400, 150);
		
		int h = 400;
		int w = 150;
    	this.gui = new LayoutGUI<>(h, w);
        this.jlp.add(this.gui, new Integer(1));
        
        LabelComponent label = new LabelComponent(message, 10, 10, 390, 70);
        this.addGUI(label);
        
    	this.setContentPane(this.jlp);
    	this.setResizable(false);    	repaint();
	}


}
