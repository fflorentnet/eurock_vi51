package fr.utbm.vi51.project.eurock.GUI.Graphics.Frame;

import java.util.Iterator;

import fr.utbm.info.vi51.framework.environment.AgentBody;
import fr.utbm.info.vi51.framework.environment.SituatedObject;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Buttons.AddAgentButton;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Buttons.ZoomButton;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent.AbstractGraphicAgent;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent.GraphicArtist;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent.GraphicSecurityAgent;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent.GraphicSpectator;
import fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicBuilding.GraphicScene;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Layout.LayoutAgent;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Layout.LayoutGUI;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Layout.LayoutMap;
import fr.utbm.vi51.project.eurock.environment.WorldModel;



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
	private WorldModel environment;
	public static Window getInstance()
	{
		if (instance == null)
			instance = new Window("EurockSims",700,700);
		return instance;
	}
	public void setEnvironment(WorldModel ev)
	{
		this.environment = ev;
	}
	public void run()
	{
		if (this.environment != null)
		{
			AgentBody aBody = null;
			for(SituatedObject obj : this.environment.getAllObjects())
			{
				if (obj.getType().equals("BODY"))
				{
					aBody = (AgentBody) obj;
					if (aBody.getName() == "ARTIST")
						this.addAgent(new GraphicArtist(aBody));
					if (aBody.getName() == "SECURITYAGENT")
						this.addAgent(new GraphicSecurityAgent(aBody));
					if (aBody.getName() == "SPECTATOR")
						this.addAgent(new GraphicSpectator(aBody));
				}
				else
				{
					this.addBuilding(new GraphicScene(obj.getShape()));

				}
			
			}
			Iterator it = this.environment.getSpatialDataStructureImmobile().dataIterator(); 
			while (it.hasNext())
			{
				SituatedObject obj = (SituatedObject)it.next();
				this.addBuilding(new GraphicScene(obj.getShape()));				
			}
			System.out.println("Fini de parcourir le QuadTree.");
		}
	}
	private Window(String title, int h, int w) {
		super(title, h, w);
		int wx, wy;
		wx = 700;
		wy = 700;
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


		this.setVisible(true);
		ZoomButton zplus = new ZoomButton("+", 0, 200, 40, 40, 10);
		ZoomButton zminus = new ZoomButton("-", 0, 240, 40, 40, -10);
		AddAgentButton busButt = new AddAgentButton("A", 0, 280, 40, 40);

		/*int[] px = { 250, 200, 550, 500 };
    	int[] py = { 100, 200, 200, 100 };
    	this.addBuilding(new GraphicScene(px, py));*/

		zplus.setLayout(this.getMap());
		zminus.setLayout(this.getMap());

		zplus.setLayout(this.getNetwork());
		zminus.setLayout(this.getNetwork());

		busButt.setLayout(this.getMap());

		this.addGUI(zplus);
		this.addGUI(zminus);
		this.addGUI(busButt);
	}
}
