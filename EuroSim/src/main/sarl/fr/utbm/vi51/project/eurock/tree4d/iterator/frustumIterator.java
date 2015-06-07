package fr.utbm.vi51.project.eurock.tree4d.iterator;

import java.util.Iterator;
import java.util.Stack;

import fr.utbm.info.vi51.framework.environment.ShapedObject;
import fr.utbm.info.vi51.framework.math.Shape2f;
import fr.utbm.vi51.project.eurock.tree4d.QuadTree;
import fr.utbm.vi51.project.eurock.tree4d.QuadTreeNode;

public class frustumIterator<D extends ShapedObject> implements Iterator<D>{

	private iteratorNode<D> iterateData;
	private Stack<D> stack = new Stack<D>();
	private Shape2f<?> boundsFrustum;

	public frustumIterator(QuadTree<D> root,Shape2f<?> bounds) {
		iterateData = new iteratorNode<D>(root);
		this.boundsFrustum = bounds;
		searchNext();
	}

	public void searchNext(){
		if(stack.isEmpty()){
			while(iterateData.hasNext() && stack.size() <= 2){
				QuadTreeNode<D> tmp = iterateData.next();
				verifBound(tmp); 
			}
		}
	}

	public Boolean verifBound(QuadTreeNode<D> tmp){
		Shape2f<?> objectBounds;
		if(tmp.getData() != null && tmp.getData().size() > 0){

			if(this.boundsFrustum.intersects(tmp.getBounds())){

				for(D par : tmp.getData()){

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
		if(!stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public D next() {
		D tmp;
		tmp = stack.pop();
		searchNext();
		return tmp;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
