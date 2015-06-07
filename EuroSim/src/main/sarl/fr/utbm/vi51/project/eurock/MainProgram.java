package fr.utbm.vi51.project.eurock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.sarl.lang.core.Agent;
import fr.utbm.info.vi51.framework.FrameworkLauncher;
import fr.utbm.info.vi51.framework.environment.AgentBody;
import fr.utbm.info.vi51.framework.environment.DynamicType;
import fr.utbm.info.vi51.framework.environment.ImmobileObject;
import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.info.vi51.framework.math.Rectangle2f;
import fr.utbm.info.vi51.framework.util.LocalizedString;
import fr.utbm.info.vi51.framework.util.SpawnMapping;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Frame.Window;
import fr.utbm.vi51.project.eurock.agent.Artist;
import fr.utbm.vi51.project.eurock.agent.SecurityAgent;
import fr.utbm.vi51.project.eurock.agent.Spectator;
import fr.utbm.vi51.project.eurock.environment.WorldModel;
import fr.utbm.vi51.project.eurock.semantics.Semantics;

public class MainProgram {

	private static float WORLD_SIZE_X = 700;
	private static float WORLD_SIZE_Y = 700;
	private static int NUMBER_ARTIST = 4;
	private static int NUMBER_SPECTATOR = 500;
	private static int NUMBER_SECURITYAGENT = 3;

	/** Main program.
	 * 
	 * @param argv are the command line arguments.
	 * @throws Exception 
	 */	
	public static void main(String[] argv) throws Exception {

		System.out.println(LocalizedString.getString(MainProgram.class, "INTRO_MESSAGE")); //$NON-NLS-1$

		WorldModel environment = new WorldModel(WORLD_SIZE_X, WORLD_SIZE_Y);

		for (int i = 0; i < NUMBER_ARTIST; ++i) {
			environment.createArtist();
		}
		for (int i = 0; i < NUMBER_SPECTATOR; ++i) {
			environment.createSpectator();
		}
		for (int i = 0; i < NUMBER_SECURITYAGENT; ++i) {
			environment.createSecurityAgent();
		}
		
		List<ImmobileObject> listIm = new ArrayList<ImmobileObject>();
		
		listIm.add(new ImmobileObject(UUID.randomUUID(), new Rectangle2f(new Point2f(3, 2), new Point2f(6, 4)), new Point2f(200,234), "Scene"));
		listIm.add(new ImmobileObject(UUID.randomUUID(), new Rectangle2f(new Point2f(3, 2), new Point2f(6, 4)), new Point2f(250,234), "Scene"));
		listIm.add(new ImmobileObject(UUID.randomUUID(), new Rectangle2f(new Point2f(3, 2), new Point2f(6, 4)), new Point2f(500,234), "Scene"));
		listIm.add(new ImmobileObject(UUID.randomUUID(), new Rectangle2f(new Point2f(3, 2), new Point2f(6, 4)), new Point2f(300,234), "Scene"));
		listIm.add(new ImmobileObject(UUID.randomUUID(), new Rectangle2f(new Point2f(3, 2), new Point2f(6, 4)), new Point2f(400,234), "Scene"));
		
		environment.setImmobileObject(listIm);
		
		Window w = Window.getInstance();
		w.setEnvironment(environment);
		w.run();
		/*FrameworkLauncher.launchSimulation(
				environment,
				new ApplicationMapping(),
				DynamicType.KINEMATIC,
				w);*/
				
	}

	/**
	 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
	 * @version $Name$ $Revision$ $Date$
	 */
	private static class ApplicationMapping extends SpawnMapping {

		@Override
		public Class<? extends Agent> getAgentTypeForBody(AgentBody body) {
			//return null;
			if(body.getName() == "ARTIST") {
				return Artist.class;
			} else if (body.getName() == "SPECTATOR") {
				return Spectator.class;
			} else if (body.getName() == "SECURITYAGENT") {
				return SecurityAgent.class;
			}
			return null;
		}

	}

}
