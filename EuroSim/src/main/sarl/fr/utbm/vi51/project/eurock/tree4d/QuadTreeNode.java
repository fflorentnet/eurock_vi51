package fr.utbm.vi51.project.eurock.tree4d;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.vi51.framework.environment.ShapedObject;
import fr.utbm.vi51.framework.math.Point2f;
import fr.utbm.vi51.framework.math.Rectangle2f;

public class QuadTreeNode<D extends ShapedObject> {
	List<D> lData;
	final int LIMITE = 4;
	Rectangle2f bounds = null;
	QuadTreeNode<D> parent = null;
	QuadTreeNode children[];

	private static int LEFTTOP = 1;
	private static int RIGHTTOP = 2;
	private static int LEFTBOTTOM = 3;
	private static int RIGHTBOTTOM = 0;
	

	// Création du root (parent = null)
	public QuadTreeNode(Rectangle2f r) {
		bounds = r;
		lData = new ArrayList<D>();
		children = new QuadTreeNode[4];
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
		if (nData.getShape().intersects(this.getBounds()))
		{
			Point2f Lower = bounds.getLower();
			Point2f Upper = bounds.getUpper();
			Point2f Center = bounds.getCenter();

			// Le noeud est une feuille avec des données:
			// -> Il faut créer les fils
			if (lData.isEmpty())
			{
				children[LEFTTOP] = new QuadTreeNode<D>(this, new Rectangle2f(Lower, Center));
				children[RIGHTTOP] = new QuadTreeNode<D>(this, new Rectangle2f(
						Center.getX(), Lower.getY(), 
						Upper.getX(),  Lower.getY()
						));
				children[LEFTBOTTOM] = new QuadTreeNode<D>(this, new Rectangle2f( 
						Center.getX(), Lower.getY(),
						Upper.getX(), Center.getY()
						));
				children[RIGHTBOTTOM] = new QuadTreeNode<D>(this, new Rectangle2f(Center, Upper));

				children[LEFTTOP].add(nData);

				children[RIGHTTOP].add(nData);

				children[LEFTBOTTOM].add(nData);

				children[RIGHTBOTTOM].add(nData);
			}

			// Le noeud n'est pas une feuille
			// OU il se trouve sur un axe/dans deux noeuds
			if (lData.size() < LIMITE)
			{
				lData.add(nData);
			}
		}

	}
	//}
	public QuadTreeNode<D> getParent() {
		return parent;
	}

	public List<D> getData() {
		return lData;
	}
	public boolean remove(D rData)
	{
		if (lData.contains(rData) || this.getBounds().intersects(rData.getShape()))
		{
			lData.remove(rData);
			
			children[LEFTTOP].remove(rData);
			children[RIGHTTOP].remove(rData);
			children[LEFTBOTTOM].remove(rData);
			children[RIGHTBOTTOM].remove(rData);		
		
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isLeaf() {
		return (children[LEFTTOP] == null) && (children[RIGHTTOP] == null) && (children[LEFTBOTTOM] == null) && (children[RIGHTBOTTOM] == null);
	}
	public QuadTreeNode<D>[] getChildren() {
		return children;
	}
}
