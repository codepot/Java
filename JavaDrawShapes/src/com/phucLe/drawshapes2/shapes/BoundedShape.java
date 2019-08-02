package com.phucLe.drawshapes2.shapes;

import java.awt.Color;

public abstract class BoundedShape extends Shape {
	private boolean filled; // filled shape state
	private Color secondGradientColor;
	private boolean gradientFilled;

	public Color getSecondGradientColor() {
		return secondGradientColor;
	}

	public void setSecondGradientColor(Color secondGradientColor) {
		this.secondGradientColor = secondGradientColor;
	}

	public boolean isGradientFilled() {
		return gradientFilled;
	}

	public void setGradientFilled(boolean gradientFilled) {
		this.gradientFilled = gradientFilled;
	}

	public BoundedShape() {
		super();
		setFilled(false);
	}

	public BoundedShape(int x1, int y1, int x2, int y2, Color color,
			boolean isFilled) {
		super(x1, y1, x2, y2, color);
		setFilled(isFilled);
	}

	// bounded shape getters and setters
	public int getUpperLeftX() {
		return Math.min(getX1(), getX2());
	}

	public int getUpperLeftY() {
		return Math.min(getY1(), getY2());
	}

	public int getWidth() {
		return Math.abs(getX2() - getX1());
	}

	public int getHeight() {
		return Math.abs(getY2() - getY1());
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean isFilled) {
		filled = isFilled;
	}
}