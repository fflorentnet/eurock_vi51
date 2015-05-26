package fr.utbm.vi51.project.eurock.frustrum;

import java.util.List;

import fr.utbm.vi51.project.eurock.general.Point2f;
import fr.utbm.vi51.project.eurock.general.Vector2f;

public class Frustrum {

	/**
	 * Stock les différents type de shapes du frustum
	 */
	private List<Shape> allShape;

	/**
	 * Je ne sais pas
	 * @return
	 */
	public Point2f getPosition() {
		return null;
	}

	/**
	 * Je ne sais pas
	 * @return
	 */
	public Vector2f getLinearSpeed() {
		return null;
	}

	/**
	 * Je ne sais pas
	 * @return
	 */
	public Vector2f getAngularSpeed() {
		return null;
	}
	
	/**
	 * Ajoute un shape dans la liste
	 * @param shapeAdd
	 */
	public void setShape(Shape shapeAdd){
		this.allShape.add(shapeAdd);
	}
	
	/**
	 * Récupère la liste de shape du frustum
	 * @return
	 */
	public List<Shape> getShape(){
		return this.allShape;
	}
	
	

}
