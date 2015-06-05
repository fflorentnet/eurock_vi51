package fr.utbm.vi51.project.eurock.behaviour2;

import fr.utbm.info.vi51.framework.agent.BehaviourOutput; 
import fr.utbm.info.vi51.framework.environment.DynamicType;
import fr.utbm.info.vi51.framework.math.Point2f;

public class SteeringArrivingBehaviour implements ArrivingBehaviour{
	@Override
	public BehaviourOutput runArriving(Point2f position, float linearSpeed, float maxLinearAcc, Point2f target) {
		BehaviourOutput output = new BehaviourOutput(DynamicType.STEERING);
		
	}
}
