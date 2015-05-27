package fr.utbm.vi51.project.eurock.treeBSP;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.vi51.project.eurock.tree.Node;

public class BSPNode<D> extends Node<D, BSPNode<D> > {

	private static int FRONT = 0;
	private static int BACK  = 1;
	private BSPLine partition;
	private List<BSPPolygon> polygon;	
	public BSPNode()
	{
		children = new BSPNode[2];
		polygon = new ArrayList<BSPPolygon>();
	}
	public BSPNode<D> getFront()
	{
		return children[FRONT];
	}
	public BSPNode<D> getBack()
	{
		return children[BACK];
	}
	public void setFront(BSPNode<D> f)
	{
		children[FRONT] = f;
	}
	public void setBack(BSPNode<D> b)
	{
		children[BACK] = b;
	}	
	
	@Override
	public void add(BSPNode<D> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
