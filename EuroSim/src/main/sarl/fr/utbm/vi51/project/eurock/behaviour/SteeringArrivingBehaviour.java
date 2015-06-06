package fr.utbm.vi51.project.eurock.behaviour;

import fr.utbm.info.vi51.framework.agent.BehaviourOutput;
import fr.utbm.info.vi51.framework.environment.DynamicType;
import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.info.vi51.framework.math.Vector2f;

/**
 * Arriving Behaviour.
 * 
 * @author Nicolas
 */

public class SteeringArrivingBehaviour implements ArrivingBehaviour{
	@Override
	public BehaviourOutput runArriving(Point2f position, Vector2f velocity, Point2f target, float maxLinearAcc, float maxLinearSpeed, float targetRadius, float slowRadius) {
		BehaviourOutput output = new BehaviourOutput(DynamicType.STEERING);
		float targetSpeed;
		float distance;
		float timeToTarget = 0.1f;
		Vector2f outputLinear;
		Vector2f targetVelocity;
		
		// Get the direction to the target
		Vector2f direction = target.operator_minus(position);
		direction.setLength(maxLinearAcc);
		distance = direction.length();
		
		// Check if we are there, return nothing
		if (distance < targetRadius) {
			return null;
		}
		
		// If the agent is out of the slowRadius, then go maxSpeed
		if (distance > slowRadius) {
			targetSpeed = maxLinearSpeed;
		}
		else {
			targetSpeed = maxLinearSpeed * distance / slowRadius;
		}
		
		targetVelocity = direction;
		targetVelocity.normalize();
		targetVelocity.operator_multiply(targetSpeed);

		outputLinear = targetVelocity.operator_minus(velocity);
		outputLinear.operator_divide(timeToTarget);
		
		// Check if the acceleration is too fast
		if (outputLinear.length() > maxLinearAcc) {
			outputLinear.normalize(); 
			outputLinear.operator_multiply(maxLinearAcc);			
		}

		// Output the move result
		return output;	
	}
}
