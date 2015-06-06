package fr.utbm.vi51.project.eurock.environment;

import fr.utbm.info.vi51.framework.math.Vector2f;

public class MobileObject extends WorldObject {

	private Vector2f currentLinearSpeed;

	private Vector2f currentAngularSpeed;

	private float maxLinearSpeed;

	private float maxAngularSpeed;

	private float maxAcceleration;
	
	private State state;	
	
	public Vector2f getCurrentLinearSpeed() {
		return currentLinearSpeed;
	}

	public void setCurrentLinearSpeed(Vector2f currentLinearSpeed) {
		this.currentLinearSpeed = currentLinearSpeed;
	}

	public Vector2f getCurrentAngularSpeed() {
		return currentAngularSpeed;
	}

	public void setCurrentAngularSpeed(Vector2f currentAngularSpeed) {
		this.currentAngularSpeed = currentAngularSpeed;
	}

	public float getMaxLinearSpeed() {
		return maxLinearSpeed;
	}

	public void setMaxLinearSpeed(float maxLinearSpeed) {
		this.maxLinearSpeed = maxLinearSpeed;
	}

	public float getMaxAngularSpeed() {
		return maxAngularSpeed;
	}

	public void setMaxAngularSpeed(float maxAngularSpeed) {
		this.maxAngularSpeed = maxAngularSpeed;
	}

	public float getMaxAcceleration() {
		return maxAcceleration;
	}

	public void setMaxAcceleration(float maxAcceleration) {
		this.maxAcceleration = maxAcceleration;
	}

}
