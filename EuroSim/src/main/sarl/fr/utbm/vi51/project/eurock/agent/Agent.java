package fr.utbm.vi51.project.eurock.agent;

import fr.utbm.vi51.framework.math.Point2f;
import fr.utbm.vi51.framework.math.Vector2f;
import fr.utbm.vi51.project.eurock.behaviour.FleeBehaviour;
import fr.utbm.vi51.project.eurock.environment.Body;

public abstract class Agent {

	private Body body;
	
	public Agent(Body body){
		this.body = body;
	}

	public abstract void live();

	public abstract void kill();
	
	public Vector2f moveFlee(Point2f target){
		Point2f position = body.getPosition();
		float maxlinearSpeed = body.getMaxLinearSpeed();
		float maxAcceleration = body.getMaxAcceleration();
		float maxAngularSpeed = body.getMaxAngularSpeed();
		Vector2f currentLinearSpeed = body.getCurrentLinearSpeed();
		return new FleeBehaviour().runBehavior(position, maxlinearSpeed, maxAcceleration, maxAngularSpeed, currentLinearSpeed, target);
	}

	public Vector2f moveSeek(Point2f target){
		Point2f position = body.getPosition();
		float maxlinearSpeed = body.getMaxLinearSpeed();
		float maxAcceleration = body.getMaxAcceleration();
		float maxAngularSpeed = body.getMaxAngularSpeed();
		Vector2f currentLinearSpeed = body.getCurrentLinearSpeed();
		return new FleeBehaviour().runBehavior(position, maxlinearSpeed, maxAcceleration, maxAngularSpeed, currentLinearSpeed, target);
	}
	
	public Vector2f moveWander(){
		Point2f position = body.getPosition();
		float maxlinearSpeed = body.getMaxLinearSpeed();
		float maxAcceleration = body.getMaxAcceleration();
		float maxAngularSpeed = body.getMaxAngularSpeed();
		Vector2f currentLinearSpeed = body.getCurrentLinearSpeed();
		return new FleeBehaviour().runBehavior(position, maxlinearSpeed, maxAcceleration, maxAngularSpeed, currentLinearSpeed, null);
	}
}
