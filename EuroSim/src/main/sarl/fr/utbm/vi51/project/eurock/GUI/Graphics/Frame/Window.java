package fr.utbm.vi51.project.eurock.GUI.Graphics.Frame;

import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent.AbstractGraphicAgent;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Layout.LayoutAgent;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Layout.LayoutGUI;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Layout.LayoutMap;



/**
 * 
 */
public class Window extends AbstractFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Window instance = null;
	public static Window getInstance()
	{
		if (instance == null)
			instance = new Window("EurockSims",700,700);
		return instance;
	}
	private Window(String title, int h, int w) {
		super(title, h, w);
		int wx, wy;
		wx = 800;
		wy = 800;
		this.gui = new LayoutGUI<>(h, w);
      	this.gui.setDoubleBuffered(true);
    	this.map = new LayoutMap<>(wx, wy);
    	this.agentLayout = new LayoutAgent<AbstractGraphicAgent>(wx, wy);
    	

    	this.map.setLocation((int) ((wx - h) * this.map.getZoom()/100),(int) ((wy - w) * this.map.getZoom()/100));
    	this.agentLayout.setLocation((int) ((wx - h) * this.map.getZoom()/100),(int) ((wy - w) * this.map.getZoom()/100));
    	this.mouse.add(map);
    	this.mouse.add(agentLayout);
		
		this.jlp.addMouseListener(this.mouse);
		this.jlp.addMouseMotionListener(this.mouse);
		this.jlp.addMouseWheelListener(this.mouse);
    	this.jlp.add(this.map, new Integer(0));
        this.jlp.add(this.agentLayout, new Integer(1));

        this.jlp.add(this.gui, new Integer(2));
    	this.setContentPane(this.jlp);
    	this.setResizable(false);
	}
}
