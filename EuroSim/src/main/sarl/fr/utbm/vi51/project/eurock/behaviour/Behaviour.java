package fr.utbm.vi51.project.eurock.behaviour;

import fr.utbm.vi51.project.eurock.general.Point2f;
import fr.utbm.vi51.project.eurock.general.Vector2f;



public interface Behaviour {

	/**
	 * Retourne la nouvelle vitesse
	 * @param position : Position de l'agent
	 * @param maxlinearSpeed : Maximum vitesse de l'agent
	 * @param maxAcceleration : Maximum acceleration de l'agent
	 * @param currentLinearSpeed : Vitesse actuelle
	 * @param target : Cible
	 * @return Vector2f, la nouvelle vitesse actuelle
	 */
	public Vector2f runBehavior(Point2f position, float maxlinearSpeed,
			float maxAcceleration,float maxAngularSpeed, Vector2f currentLinearSpeed, Point2f target);
}
