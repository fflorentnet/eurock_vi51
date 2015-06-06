package fr.utbm.vi51.project.eurock.GUI.Graphics.Buttons;

import java.awt.event.ActionEvent;

import fr.utbm.vi51.project.eurock.GUI.Graphics.CardinalSystem;
import fr.utbm.vi51.project.eurock.GUI.Graphics.Layout.AbstractLayout;

public class ZoomButton extends ButtonComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2765495561532237764L;
	protected double zoomFactor;
	public ZoomButton(String text, int x, int y, int h, int w, double zoom) {
		super(text, x, y, h, w);
		this.zoomFactor = zoom;
	}
	public ZoomButton(String text, int x, int y, int h, int w, CardinalSystem p, double zoom) {
		super(text, x, y, h, w, p);
		this.zoomFactor = zoom;
	}

	@Override
	public void action(ActionEvent evt) {
		for (AbstractLayout<?> m : this.m)
		{
			m.zoom(this.zoomFactor);
			m.repaint();
		}
	}
}
