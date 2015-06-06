package fr.utbm.vi51.project.eurock.environment;

import fr.utbm.vi51.project.eurock.frustrum.Shape;

import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.vi51.project.eurock.semantics.Semantics;

/**
 * 
 * @author elvil
 *
 */
public class WorldObject {

	private Point2f position;

	private Enum<?> state;

	private Semantics[] semantics;

	private Shape shape;
	
	public Point2f getPosition() {
		return position;
	}

	public void setPosition(Point2f position) {
		this.position = position;
	}

	public Enum<?> getState() {
		return state;
	}

	public void setState(Enum<?> state) {
		this.state = state;
	}

	public Semantics[] getSemantics() {
		return semantics;
	}

	public void setSemantics(Semantics[] semantics) {
		this.semantics = semantics;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
