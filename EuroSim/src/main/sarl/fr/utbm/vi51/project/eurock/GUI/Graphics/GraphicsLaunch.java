package fr.utbm.vi51.project.eurock.GUI.Graphics;


import java.util.Random;

import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Buttons.AddBusButton;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Buttons.CenterButton;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Buttons.ZoomButton;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Frame.Window;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent.AbstractGraphicAgent;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent.GraphicArtist;

@SuppressWarnings("deprecation")
public class GraphicsLaunch {

	public static Window w;

	public static void main(String[] args) {
		w = new Window("BusNetwork",700,700);
		w.setVisible(true);
		ZoomButton zplus = new ZoomButton("+", 0, 200, 40, 40, 10);
    	ZoomButton zminus = new ZoomButton("-", 0, 240, 40, 40, -10);
    	AddBusButton busButt = new AddBusButton("A", 0, 280, 40, 40, CardinalSystem.NORTHEAST);
    	CenterButton center = new CenterButton("C",0, 320, 40, 40);
    	
    	AbstractGraphicAgent agentTemp;
    	for (int i = 0; i < 10; i++)
    	{
    		Random rand = new Random();
    		int x = rand.nextInt((800 - 0) + 1) + 0;
    		int y = rand.nextInt((800 - 0) + 1) + 0;
    		agentTemp = new GraphicArtist(null, new Point2f(x, y));
    		w.addAgent(agentTemp);
    		//w.addNetworkElement(new YellowBus(x,y) );
    	}
    	
    	zplus.setLayout(w.getMap());
    	zminus.setLayout(w.getMap());
    	
    	zplus.setLayout(w.getNetwork());
    	zminus.setLayout(w.getNetwork());
    	
    	busButt.setLayout(w.getMap());
    	center.setLayout(w.getMap());
    	

    	
    	w.addGUI(zplus);
    	w.addGUI(zminus);
    	w.addGUI(busButt);
    	w.addGUI(center);
    	w.repaint();
	}
	
}
