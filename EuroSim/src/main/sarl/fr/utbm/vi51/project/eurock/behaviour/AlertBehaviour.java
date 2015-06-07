package fr.utbm.vi51.project.eurock.behaviour;

import java.util.List;

import fr.utbm.info.vi51.framework.environment.Percept;
import fr.utbm.vi51.project.eurock.environment.State;

/**
 * @author Nicolas
 *
 */

public class AlertBehaviour {
	
	public boolean runAlert(List<Percept> perceptions) {
		
		for (Percept p : perceptions) {
			// Change the state of the agents present in the alert circle 
			if(p.getState() == State.ALERTED){
				return true;
			}
		}
		return false;
	}
}
