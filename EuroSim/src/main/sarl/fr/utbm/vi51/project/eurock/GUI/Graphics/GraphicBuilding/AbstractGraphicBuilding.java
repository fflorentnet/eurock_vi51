package fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicBuilding;

import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import fr.utbm.info.vi51.framework.math.Shape2f;
import fr.utbm.vi51.project.eurock.GUI.Graphics.AbstractGraphicElement;

public abstract class AbstractGraphicBuilding extends AbstractGraphicElement {

	protected Shape shp;
	public AbstractGraphicBuilding(Shape s) {
		this.shp = s;
	}
	public AbstractGraphicBuilding(int x, int y, int radius)
	{
		shp = new Ellipse2D.Double(x, y, radius, radius);
	}
	public AbstractGraphicBuilding(int x, int y, int width, int height)
	{
		shp = new Rectangle2D.Double(x,y,width,height);
	}
	public AbstractGraphicBuilding(int[] px, int[] py)
	{
		if (px.length == py.length)
		shp = new Polygon();
		for (int i = 0; i < px.length; ++i)
			((Polygon)shp).addPoint(px[i], py[i]);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean intersect(Shape2f<?> r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JComponent getSwingComponent() {
		// TODO Auto-generated method stub
		return null;
	}

}
