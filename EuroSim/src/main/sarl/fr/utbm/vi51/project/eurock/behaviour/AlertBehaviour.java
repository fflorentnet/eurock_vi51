package fr.utbm.vi51.project.eurock.behaviour;

import fr.utbm.info.vi51.framework.agent.BehaviourOutput;
import fr.utbm.info.vi51.framework.math.Vector2f;
import fr.utbm.info.vi51.framework.math.Point2f;

/**
 * @author Nicolas
 *
 */

public class AlertBehaviour {
	
	private final float alertRadius; 

	/**
	 * @param alertRadius 
	 */
	
	public AlertBehaviour(float alertRadius) {
		this.alertRadius = alertRadius;
	}
	
	public BehaviourOutput runAlert(Point2f position, Vector2f orientation) {
		
		BehaviourOutput output;
		
		// Calculate the circle center
		//Vector2f circleCenter = orientation.toColinearVector(alertRadius);
		
		return output;
	}
}
