package fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicBuilding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import fr.utbm.info.vi51.framework.math.Point2f;
import fr.utbm.info.vi51.framework.math.Shape2f;

public class GraphicScene extends AbstractGraphicBuilding {


	public GraphicScene(int x, int y, int radius) {
		super(x, y, radius);
	}
	public GraphicScene(int x, int y, int width, int height)
	{
		super(x, y, width, height);
	}
	public GraphicScene(int[] px, int[] py)
	{
		super(px, py);
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.cyan.brighter());
		g2d.fill(shp);
		g2d.setColor(Color.black);
		g2d.draw(shp);	
		
	}
}
