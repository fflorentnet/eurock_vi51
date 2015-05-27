package fr.utbm.vi51.project.eurock.tree4d;

import java.util.Iterator;

import fr.utbm.vi51.framework.environment.SituatedObject;
import fr.utbm.vi51.framework.environment.SpatialDataStructure;
import fr.utbm.vi51.framework.math.Rectangle2f;
import fr.utbm.vi51.framework.math.Shape2f;

public class QuadTree <D extends SituatedObject>  {

	QuadTreeNode<D> root = null;
	Iterator<QuadTreeNode<D>> it =  null;
	public void initialize(Rectangle2f worldSize) {
		root = new QuadTreeNode<D>(worldSize);
//		it = new FrustrumCullerTreeIterator(root, new CircleFrustum());
//		it = new LeafTreeIterator(root);
	}

	public Rectangle2f getBounds() {
		if (root != null)
			return root.getBounds();
		return null;
	}

	public Iterator dataIterator() {
	//	return new LeafTreeIterator(root);
		return null,
	}

	public Iterable<D> getData() {
		return new Iterable<D>() {
			@Override
			public Iterator<D> iterator() {
				return dataIterator();
			}
		};
	}

	public void setRoot(QuadTreeNode<D> newRoot) {
		root = newRoot;
	}

	public QuadTreeNode<D> getRoot() {
		return root;
	}

	// retourne true si la valeur a bien été supprimée
	public boolean removeData(D data) {
		return root.remove(data);
	}

	public boolean addData(D data) {
		root.add(data);
		return true;
	}

	public Iterator iterator() {
		return it;
	}

}
