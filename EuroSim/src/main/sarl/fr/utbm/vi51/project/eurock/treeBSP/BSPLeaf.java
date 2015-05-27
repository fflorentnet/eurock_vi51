package fr.utbm.vi51.project.eurock.treeBSP;

import java.awt.Rectangle;

public class BSPLeaf<D> extends BSPNode<D> {
	public float floorHeight;
	public float ceilHeight;
	public Rectangle bounds;
	public boolean isBack;
}