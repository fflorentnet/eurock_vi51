package fr.utbm.vi51.project.eurock.behaviour2;

import fr.utbm.info.vi51.framework.agent.BehaviourOutput;
import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.info.vi51.framework.math.Vector2f;

/**
 * Arriving Behaviour.
 * 
 * @author Nicolas
 */

public interface ArrivingBehaviour {

	public BehaviourOutput runArriving(Point2f position, Vector2f velocity, Point2f target, float maxLinearAcc, float maxLinearSpeed, float targetRadius, float slowRadius);
	
}
