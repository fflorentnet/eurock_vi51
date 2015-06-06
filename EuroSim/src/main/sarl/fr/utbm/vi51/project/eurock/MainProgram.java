package fr.utbm.vi51.project.eurock;

import io.sarl.lang.core.Agent;
import fr.utbm.info.vi51.framework.environment.AgentBody;
import fr.utbm.info.vi51.framework.environment.DynamicType;
import fr.utbm.info.vi51.framework.gui.BehaviorTypeSelector;
import fr.utbm.info.vi51.framework.util.LocalizedString;
import fr.utbm.info.vi51.framework.util.SpawnMapping;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Frame.Window;
import fr.utbm.vi51.project.eurock.environment.WorldModel;

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

		/*DynamicType type = BehaviorTypeSelector.open();
		if (type == null) {
			System.exit(0);
		}*/

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

		//FrameworkGUI gui = null; //new GUI(WORLD_SIZE_X, WORLD_SIZE_Y, environment.getTimeManager());

		/*FrameworkLauncher.launchSimulation(
				environment,
				new ApplicationMapping(),
				type,
				gui);*/
		Window w = Window.getInstance();
		
	}

	/**
	 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
	 * @version $Name$ $Revision$ $Date$
	 */
	private static class ApplicationMapping extends SpawnMapping {

		@Override
		public Class<? extends Agent> getAgentTypeForBody(AgentBody body) {
			return null;
			/*if(body == "ARTIST") {
				return Artist.class;
			} else if (body == "SPECTATOR") {
				return Spectator.class;
			} else if (body == "SECURITYAGENT") {
				return SecurityAgent.class;
			}*/
		}

	}

}
