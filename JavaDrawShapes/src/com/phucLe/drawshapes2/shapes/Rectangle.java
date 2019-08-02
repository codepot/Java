package com.phucLe.drawshapes2.shapes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends BoundedShape {
	public Rectangle() {
		super();
	}

	public Rectangle(int x1, int y1, int x2, int y2, Color color,
			boolean isFilled) {
		super(x1, y1, x2, y2, color, isFilled);
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		if (isFilled())
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(),
					getHeight());
		else if(isGradientFilled()){
			GradientPaint gradient = new GradientPaint(getUpperLeftX(), getUpperLeftY(),getColor(),getWidth(),
					getHeight(),getSecondGradientColor(),true);
			Graphics2D g2d = (Graphics2D)g;
			  g2d.setPaint(gradient);
			  g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(),
						getHeight());
		}
		else
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(),
					getHeight());
	}
}