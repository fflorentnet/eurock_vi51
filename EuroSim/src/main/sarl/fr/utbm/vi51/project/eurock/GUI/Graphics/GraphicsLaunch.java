package fr.utbm.vi51.project.eurock.GUI.Graphics;


import java.util.Random;

import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Buttons.AddAgentButton;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Buttons.CenterButton;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Buttons.ZoomButton;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Frame.Window;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent.AbstractGraphicAgent;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent.GraphicSpectator;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicBuilding.GraphicScene;

@SuppressWarnings("deprecation")
public class GraphicsLaunch {

	public static Window w;

	public static void main(String[] args) {
		Window w = Window.getInstance();
    	w.repaint();
	}
	
}
