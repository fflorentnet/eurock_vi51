package fr.utbm.vi51.project.eurock.tree4d;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.vi51.framework.environment.SituatedObject;
import fr.utbm.vi51.framework.math.Point2f;
import fr.utbm.vi51.framework.math.Rectangle2f;


public class QuadTreeNode<D extends SituatedObject> {
	List<D> lData;
	final int LIMITE = 4;
	Rectangle2f bounds = null;
	QuadTreeNode<D> parent = null;
	QuadTreeNode<D> leftTop = null;
	QuadTreeNode<D> rightTop = null;
	QuadTreeNode<D> leftBottom = null;
	QuadTreeNode<D> rightBottom = null;
	
	// Création du root (parent = null)
	public QuadTreeNode(Rectangle2f r) {
		bounds = r;
		lData = new ArrayList<D>();
	}
	public QuadTreeNode(QuadTreeNode<D> pa, Rectangle2f r)
	{
		bounds = r;
		parent = pa;
		lData = new ArrayList<D>();
	}
	
	public Rectangle2f getBounds() {
		return bounds;
	}
	
	public void setParent(QuadTreeNode<D> p)
	{
		parent = p;
	}
	public void add(D nData)
	{
		Point2f Lower = bounds.getLower();
		Point2f Upper = bounds.getUpper();
		Point2f Center = bounds.getCenter();
		
		// Recherche de la position du noeud
		boolean nTop = (nData.getY() < Center.getY());
		boolean nLeft= (nData.getX()  < Center.getX());
		
		boolean onY = (nData.getY() == Center.getY());
		boolean onX = (nData.getX() == Center.getX());
		
		// Le noeud n'est pas une feuille
		// OU il se trouve sur un axe/dans deux noeuds
		if (lData.size() < LIMITE || !onY || !onX)
		{
			lData.add(nData);
		}
		// Le noeud est une feuille avec des données:
		// -> Il faut créer les fils
		else
		{
			leftTop = new QuadTreeNode<D>(this, new Rectangle2f(Lower, Center));
			rightTop = new QuadTreeNode<D>(this, new Rectangle2f(
					Center.getX(), Lower.getY(), 
					Upper.getX(),  Lower.getY()
					));
			leftBottom = new QuadTreeNode<D>(this, new Rectangle2f( 
					Center.getX(), Lower.getY(),
					Upper.getX(), Center.getY()
					));
			rightBottom = new QuadTreeNode<D>(this, new Rectangle2f(Center, Upper));
		if (nTop && nLeft)
			leftTop.add(nData);
		else if (nTop && !nLeft)
			rightTop.add(nData);
		else if (!nTop && nLeft)
			leftBottom.add(nData);
		else
			rightBottom.add(nData);
		}
	}
	public QuadTreeNode<D> getParent() {
		return parent;
	}
	
	public List<D> getData() {
		return lData;
	}
	public boolean remove(D rData)
	{
		if (lData.contains(rData))
		{
			lData.remove(rData);
			return true;
		}
		else
		{
			Point2f Center = bounds.getCenter();	
			// Recherche de la position de l'objet
			boolean nTop = (rData.getY() < Center.getY());
			boolean nLeft= (rData.getX()  < Center.getX());
			if (nTop && nLeft)
				return leftTop.remove(rData);
			else if (nTop && !nLeft)
				return rightTop.remove(rData);
			else if (!nTop && nLeft)
				return leftBottom.remove(rData);
			else
				return rightBottom.remove(rData);		
		}
	}
	public boolean isLeaf() {
		return (leftTop == null) && (rightTop == null) && (leftBottom == null) && (rightBottom == null);
	}
	public QuadTreeNode[] getChildren() {
		QuadTreeNode<D> lChildren[] = new QuadTreeNode[4];
		lChildren[0] = (leftTop);
		lChildren[1] = (rightTop);
		lChildren[2] = (leftBottom);
		lChildren[3] = (rightBottom);
		return lChildren;
	}
}
	