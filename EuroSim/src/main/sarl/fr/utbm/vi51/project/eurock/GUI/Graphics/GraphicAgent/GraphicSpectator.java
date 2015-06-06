package fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fr.utbm.info.vi51.framework.environment.AgentBody;
import fr.utbm.info.vi51.framework.math.Point2f;

public class GraphicSpectator extends AbstractGraphicAgent {

	public GraphicSpectator(AgentBody r) {
		super(r);
	}
	public GraphicSpectator(AgentBody r, Point2f pos) {
		super(r, pos);
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		
		g2d.drawOval((int)pos.getX(), (int)pos.getY(), 8, 8);
		g2d.setColor(Color.red);
		
		g2d.fillOval((int)pos.getX(), (int)pos.getY(), 8, 8);

	}

}
