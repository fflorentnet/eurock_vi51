package fr.utbm.vi51.project.eurock.frustrum;

import java.util.List;

import fr.utbm.vi51.framework.math.Point2f;
import fr.utbm.vi51.framework.math.Vector2f;

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
	
	/**
	 * Dès qu'il y a l'arbre on peut mettre à jours l'itérateur
	 * @author elvil
	 *
	 * @param <D>
	 */
	/*private static class frustumIterator implements Iterator<Shape>{
		
		//Iterateur sur les noeuds de l'arbre
		private IteratorAllNode iterateData;
		private Stack<Shape> stack = new Stack<Shape>();
		private Shape boundsFrustum;
		
		public frustumIterator(QuadTree root,Shape bounds) {
			iterateData = new IteratorAllNode(root);
			this.boundsFrustum = bounds;
			searchNext();
		}
		
		public void searchNext(){
			if(stack.isEmpty()){
				while(iterateData.hasNext() && stack.size() <= 2){
					QuadTreeNode tmp = iterateData.next();
					verifBound(tmp);				
				}
			}
		}
		
		public Boolean verifBound(QuadTreeNode tmp){
			Shape objectBounds;
			if(tmp.getData() != null && tmp.getData().size() > 0){
				
				if(this.boundsFrustum.intersects(tmp.getBounds())){
					
					for(Shape par : tmp.getData()){
						
						objectBounds = par.getShape();
						
						if(this.boundsFrustum.intersects(objectBounds)){
							stack.add(par);
						}
						
					}
					
				}
			}
			
			return null;
		}
		
		@Override
		public boolean hasNext() {
			if(stack.isEmpty()){
				return true;
			}else{
				return false;
			}
		}

		@Override
		public Shape next() {
			Shape tmp;
			tmp = stack.pop();
			searchNext();
			return tmp;
		}
		
	}*/

}
