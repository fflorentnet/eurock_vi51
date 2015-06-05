package fr.utbm.vi51.project.eurock.behaviour;

import fr.utbm.info.vi51.framework.agent.BehaviourOutput;
import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.info.vi51.framework.math.Vector2f;



public interface Behaviour {

	/**
	 * Retourne le nouveau vecteur de déplacement
	 * @param position : Position de l'agent
	 * @param maxlinearSpeed : Maximum vitesse de l'agent
	 * @param maxAcceleration : Maximum acceleration de l'agent
	 * @param currentLinearSpeed : Vitesse actuelle
	 * @param target : Cible
	 * @return Vector2f, le nouveau vecteur de déplacement
	 */
	public BehaviourOutput runBehavior(Point2f position, float maxlinearSpeed,
			float maxAcceleration,float maxAngularSpeed, Vector2f currentLinearSpeed, Point2f target);
}
