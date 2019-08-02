package com.phucLe.drawshapes2.shapes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Triangle extends BoundedShape {
	private int x3;
	private int y3;
	Polygon polygon;

	public Triangle() {
		super();
	}

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3,
			Color color, boolean isFilled) {
		super(x1, y1, x2, y2, color, isFilled);
		this.x3 = x3;
		this.y3 = y3;

	}

	public int getX3() {
		return x3;
	}

	public void setX3(int x3) {
		this.x3 = x3;
	}

	public int getY3() {
		return y3;
	}

	public void setY3(int y3) {
		this.y3 = y3;
	}

	public void draw(Graphics g) {
		g.setColor(getColor());

		int[] x = { getX1(), getX2(), this.x3 };
		int[] y = { getY1(), getY2(), this.y3 };
		polygon = new Polygon(x, y, x.length);
		if (isFilled())
			g.fillPolygon(polygon);
		else if(isGradientFilled()){
			GradientPaint gradient = new GradientPaint(getUpperLeftX(), getUpperLeftY(),getColor(),getWidth(),
					getHeight(),getSecondGradientColor(),true);
			Graphics2D g2d = (Graphics2D)g;
			  g2d.setPaint(gradient);
			  g2d.fillPolygon(polygon);
		}
		else
			g.drawPolygon(polygon);

	}
}
