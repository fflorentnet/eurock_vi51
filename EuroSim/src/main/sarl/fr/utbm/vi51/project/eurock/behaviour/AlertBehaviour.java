package fr.utbm.vi51.project.eurock.behaviour;

import java.util.List;

import fr.utbm.info.vi51.framework.agent.BehaviourOutput;
import fr.utbm.info.vi51.framework.environment.Percept;
import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.info.vi51.framework.math.Vector2f;

/**
 * @author Nicolas
 *
 */

public class AlertBehaviour {
	
	public BehaviourOutput runAlert(Point2f position, List<Percept> perceptions) {
		Point2f targetPos;
		float distance;
		BehaviourOutput output; // A INITIALISER
		
		for (Percept p : perceptions) {
			// Get the position of each agent perceived
			targetPos = p.getPosition();

			// Calculate the distance between the agent who's alerting and the other agents perceived by him
			Vector2f direction = targetPos.operator_minus(position);
			distance = direction.length();
			
			// Change the state of the agents presents in the alert circle
			p.	
			return output;

		}
	}
}
