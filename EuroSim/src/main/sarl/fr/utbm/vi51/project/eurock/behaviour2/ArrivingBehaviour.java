package fr.utbm.vi51.project.eurock.behaviour2;

import fr.utbm.info.vi51.framework.agent.BehaviourOutput;
import fr.utbm.info.vi51.framework.math.Point2f;

/**
 * Arriving Behaviour.
 * 
 * @author Nicolas
 */

public interface ArrivingBehaviour {

	public BehaviourOutput runArriving(Point2f position, float linearSpeed, float maxLinearAcc, Point2f target);
	
}
