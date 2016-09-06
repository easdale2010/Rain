package com.thecherno.rain.graphics.ui;

import java.awt.Color;
import java.awt.Graphics;

import org.w3c.dom.ranges.RangeException;

import com.thecherno.rain.util.Vector2i;

public class UIProgressBar extends UIComponent {

	private double progress;

	private Color foregroundColor;

	public UIProgressBar(Vector2i position, Vector2i size) {
		super(position);
		this.size = size;

		foregroundColor = new Color(0xff00ff);
	}

	public void setProgress(double progress) {
		if (progress < 0.0 || progress > 1.0) throw new RangeException(RangeException.BAD_BOUNDARYPOINTS_ERR, "Progress must be between 0.0 and 1.0!");

		this.progress = progress;
	}

	public void setForegroundColour(int colour) {
		foregroundColor = new Color(colour);
	}

	public double getProgress() {
		return progress;
	}

	public void update() {

	}

	public void render(Graphics g) {
		g.setColor(colour);
		g.fillRect(position.x + offset.x, position.y + offset.y, size.x, size.y);

		g.setColor(foregroundColor);
		g.fillRect(position.x + offset.x, position.y + offset.y, (int) (progress * size.x), size.y);
	}
}
