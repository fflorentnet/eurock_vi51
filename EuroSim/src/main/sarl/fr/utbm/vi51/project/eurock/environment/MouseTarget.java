package fr.utbm.vi51.project.eurock.environment;

import java.util.UUID;

import fr.utbm.info.vi51.framework.environment.AbstractSituatedObject;
import fr.utbm.info.vi51.framework.math.Circle2f;

public final class MouseTarget extends AbstractSituatedObject {

	private static final long serialVersionUID = -7372943049564638811L;

	/**
	 * @param x
	 * @param y
	 */
	public MouseTarget(float x, float y) {
		super(UUID.randomUUID(), new Circle2f(0, 0, 5f), x, y);
		setType("TARGET");
	}
	
	/** Set the position of the mouse target.
	 * 
	 * @param x
	 * @param y
	 */
	public void setMousePosition(float x, float y) {
		// *** CAUTION ***
		// Changing directly the position of the target without going through the influence
		// solver may cause collision between the target and the agents.
		setPosition(x, y);
	}
	
}