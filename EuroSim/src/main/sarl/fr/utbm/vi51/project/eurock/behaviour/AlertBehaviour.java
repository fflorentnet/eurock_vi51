package fr.utbm.vi51.project.eurock.behaviour;

import fr.utbm.info.vi51.framework.agent.BehaviourOutput;
import fr.utbm.info.vi51.framework.environment.DynamicType;

/**
 * @author Nicolas
 *
 */

public class AlertBehaviour {
	
	public BehaviourOutput runAlert(float alertRadius) {
		
		BehaviourOutput output = new BehaviourOutput(DynamicType.STEERING);
		
		// Calculate the circle center
		Vector2f circleCenter = orientation.toColinearVector(alertRadius);
		
		return output;
	}
}
