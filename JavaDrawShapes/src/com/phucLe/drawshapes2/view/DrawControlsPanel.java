package com.phucLe.drawshapes2.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.phucLe.drawshapes2.shapes.BoundedShape;
import com.phucLe.drawshapes2.shapes.Line;
import com.phucLe.drawshapes2.shapes.Oval;
import com.phucLe.drawshapes2.shapes.Rectangle;
import com.phucLe.drawshapes2.shapes.Shape;
import com.phucLe.drawshapes2.shapes.Triangle;

@SuppressWarnings("serial")
public class DrawControlsPanel extends JPanel {
	private Shape[] shapes; // shapes to process
	private Shape currentShape;
	private int shapeCount;
	private int shapeType;
	private Color currentColor;
	private Color gradientSecondColor;
	
	private boolean filledShape;
	private boolean gradientShape;
	private JLabel statusLabel;

	// for Triangle
	int clicks = 0;
	final int[] xCoordinate = new int[3];
	final int[] yCoordinate = new int[3];

	public DrawControlsPanel(JLabel status) {
		shapes = new Shape[20]; // 20 maximum shapes to process
		shapeCount = 0; // no shapes initially to process

		setShapeType(0); // default shape type
		
		
		setFilledShape(false); // default fill state
		currentShape = null;

		setBackground(Color.WHITE);
		setGradientSecondColorComboBox(Color.CYAN);
		setDrawingColor(Color.BLACK); // default color
		// add the mouse listeners
		MouseHandler mouseHandler = new MouseHandler();
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);

		// set the status label for displaying mouse coordinates
		statusLabel = status;
	}

	// draw shapes
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < shapeCount; i++)
			shapes[i].draw(g);

		if (currentShape != null)
			currentShape.draw(g);
	}

	// set shape type to draw
	public void setShapeType(int shapeType) {
		if (shapeType < 0 || shapeType > 3)
			shapeType = 0;

		this.shapeType = shapeType;
	}

	public void setDrawingColor(Color c) {
		currentColor = c;
	}
	
	public void setGradientSecondColorComboBox(Color color) {
		gradientSecondColor = color;
		
	}

	public void clearLastShape() {
		if (shapeCount > 0) {
			shapeCount--;
			repaint();
		}
	}

	public void clearDrawing() {
		shapeCount = 0;
		repaint();
	}

	public void setFilledShape(boolean isFilled) {
		filledShape = isFilled;
	}
	
	public void setGradientShape(boolean value) {
		gradientShape = value;
	}

	// processes JPanel mouse events
	private class MouseHandler extends MouseAdapter implements
			MouseMotionListener {

		public void mousePressed(MouseEvent e) {
			if (currentShape != null)
				return;
			// process shape
			switch (shapeType) {
			case 0:
				currentShape = new Line(e.getX(), e.getY(), e.getX(), e.getY(),
						currentColor);
				break;
			case 1: //Rectangle
				currentShape = new Rectangle(e.getX(), e.getY(), e.getX(),
						e.getY(), currentColor, filledShape);
				((BoundedShape)currentShape).setSecondGradientColor(gradientSecondColor);
				((BoundedShape)currentShape).setGradientFilled(gradientShape);
				
				break;

			// added
			case 2: // Triangle

				xCoordinate[clicks] = e.getX();
				yCoordinate[clicks] = e.getY();
				repaint();
				clicks++;
				if (clicks % 3 == 0) {
					currentShape = new Triangle(xCoordinate[0], yCoordinate[0],
							xCoordinate[1], yCoordinate[1], xCoordinate[2],
							yCoordinate[2], currentColor, filledShape);
					((BoundedShape)currentShape).setSecondGradientColor(gradientSecondColor);
					((BoundedShape)currentShape).setGradientFilled(gradientShape);
					clicks = 0;
				}
				break;
			case 3:
				currentShape = new Oval(e.getX(), e.getY(), e.getX(), e.getY(),
						currentColor, filledShape);
				((BoundedShape)currentShape).setSecondGradientColor(gradientSecondColor);
				((BoundedShape)currentShape).setGradientFilled(gradientShape);
				break;
			}
		}

		// process shape
		public void mouseReleased(MouseEvent e) {
			if (currentShape == null)
				return;
			if (shapeType != 2) {
				// set the second point on the shape
				currentShape.setX2(e.getX());
				currentShape.setY2(e.getY());
			}
			// process shape if room in the array
			if (shapeCount < shapes.length) {
				shapes[shapeCount] = currentShape;
				shapeCount++;
			} // end if

			currentShape = null; // clear the temporary drawing shape
			repaint();
		}

		// update shape based on mouse position
		public void mouseDragged(MouseEvent e) {
			if (currentShape != null) {
				currentShape.setX2(e.getX());
				currentShape.setY2(e.getY());

				repaint();

			}
			mouseMoved(e); // update status bar
		}

		// updates the status bar to show the current mouse coordinates
		public void mouseMoved(MouseEvent e) {
			statusLabel.setText(String.format("(%d,%d)", e.getX(), e.getY()));
		}
	}

	

	
}
