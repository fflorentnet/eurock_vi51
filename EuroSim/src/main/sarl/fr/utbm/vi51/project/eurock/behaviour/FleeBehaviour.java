package fr.utbm.vi51.project.eurock.behaviour;

import fr.utbm.vi51.project.eurock.general.Point2f;
import fr.utbm.vi51.project.eurock.general.Vector2f;

/**
 * Comportement fuir une position
 * @author elvil
 *
 */
public class FleeBehaviour implements Behaviour {


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vector2f runBehavior(Point2f position, float maxlinearSpeed,
			float maxAcceleration,float maxAngularSpeed, Vector2f currentLinearSpeed, Point2f target) {


		Vector2f direction = position.operator_minus(target);
		
		//Si l'acceleration prévu est trop importante
		if(direction.length() > (currentLinearSpeed.length() + maxlinearSpeed)){
			direction.setLength(currentLinearSpeed.length() + maxlinearSpeed);
		}else{
			//Si la désacceleration est trop importante
			if((currentLinearSpeed.length() - maxlinearSpeed) > direction.length()){
				direction.setLength(currentLinearSpeed.length() - maxlinearSpeed);
			}
			
		}
		
		//Ajouter la notion de maxAngularSpeed
		
		return direction;
		
	}

}
