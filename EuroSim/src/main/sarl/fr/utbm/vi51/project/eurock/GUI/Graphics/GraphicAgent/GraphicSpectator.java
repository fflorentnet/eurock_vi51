package fr.utbm.vi51.project.eurock.GUI.Graphics.GraphicAgent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fr.utbm.info.vi51.framework.environment.AgentBody;
import fr.utbm.info.vi51.framework.math.Point2f;

public class GraphicSpectator extends AbstractGraphicAgent {

	private int step = 1;
	private boolean bStep = true;
	public GraphicSpectator(AgentBody r) {
		super(r);
	}
	public GraphicSpectator(AgentBody r, Point2f pos) {
		super(r, pos);
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		panic(g2d);
		g2d.setColor(Color.blue);
		g2d.fillOval((int)pos.getX(), (int)pos.getY(), 8, 8);
	}
	public void panic(Graphics2D g2d)
	{
		if (step < 1 || step > 9)
			bStep = !bStep;
		Color c = Color.red;
		switch(step/2){
			case 0 : c = new Color(255,170,170); break;
			case 1 : c = new Color(212,106,106); break;
			case 2 : c = new Color(170,57,57); break;
			case 3 : c = new Color(128,21,21); break;
			case 4 : c = new Color(85, 0, 0); break;
		}
		g2d.setColor(c);
		g2d.drawOval((int)(pos.getX() - step/2) , (int)(pos.getY() - step/2), 8+(step), 8+(step));

		if (bStep)
			step++;
		else
			step--;
	}

}
