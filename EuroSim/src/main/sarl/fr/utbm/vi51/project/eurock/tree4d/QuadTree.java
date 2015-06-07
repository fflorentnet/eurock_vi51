package fr.utbm.vi51.project.eurock.tree4d;

import java.util.Iterator;

import fr.utbm.info.vi51.framework.environment.ShapedObject;
import fr.utbm.info.vi51.framework.environment.SpatialDataStructure;
import fr.utbm.info.vi51.framework.math.Rectangle2f;
import fr.utbm.info.vi51.framework.math.Shape2f;
import fr.utbm.vi51.project.eurock.tree4d.iterator.frustumIterator;
import fr.utbm.vi51.project.eurock.tree4d.iterator.iteratorData;

public class QuadTree <D extends ShapedObject> implements SpatialDataStructure<D>/*, Iterable<QuadTreeNode<D> > */ {

	QuadTreeNode<D> root = null;
	Iterator<QuadTreeNode<?>> it =  null;
	public void initialize(Rectangle2f worldSize) {
		root = new QuadTreeNode<D>(worldSize);
//		it = new FrustrumCullerTreeIterator(root, new CircleFrustum());
//		it = new LeafTreeIterator(root);
	}

	@Override
	public Rectangle2f getBounds() {
		if (root != null)
			return root.getBounds();
		return null;
	}
	public Iterator dataIterator() {
		return new iteratorData(this);
	}

	public Iterable<D> getData() {
		return new Iterable<D>() {
			@Override
			public Iterator<D> iterator() {
				return dataIterator();
			}
		};
	}

	public Iterator<D> dataIterator(Shape2f<?> bounds) {
		return new frustumIterator<D>(this, bounds);
	}

	public void setRoot(QuadTreeNode<D> newRoot) {
		root = newRoot;
	}

	public QuadTreeNode<D> getRoot() {
		return root;
	}

	// retourne true si la valeur a bien �t� supprim�e
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
