package fr.utbm.vi51.project.eurock.behaviour;

import java.util.Random;

import fr.utbm.info.vi51.framework.agent.BehaviourOutput;
import fr.utbm.info.vi51.framework.environment.DynamicType;
import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.info.vi51.framework.math.Vector2f;

/**
 * Comportement direction aléatoire
 * @author elvil
 *
 */
public class WanderBehaviour implements Behaviour {

	private final Random random = new Random();
	
	@Override
	public BehaviourOutput runBehavior(Point2f position, float maxlinearSpeed,
			float maxAcceleration,float maxAngularSpeed, Vector2f currentLinearSpeed, Point2f target) {

		BehaviourOutput output = new BehaviourOutput(DynamicType.STEERING);
		
		Vector2f direction = currentLinearSpeed;
		direction.setLength(maxlinearSpeed);
		
		//Si l'acceleration prévu est trop importante
		if(direction.length() > (currentLinearSpeed.length() + maxlinearSpeed)){
			direction.setLength(currentLinearSpeed.length() + maxlinearSpeed);
		}else{
			//Si la désacceleration est trop importante
			if((currentLinearSpeed.length() - maxlinearSpeed) > direction.length()){
				direction.setLength(currentLinearSpeed.length() - maxlinearSpeed);
			}
			
		}
		
		float randAngle = (float) this.random.nextGaussian() * maxAngularSpeed;
		direction.setOrientationAngle(randAngle);
		
		return output;

	}

}
