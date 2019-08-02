package com.phucLe.drawshapes2;

import javax.swing.JFrame;

import com.phucLe.drawshapes2.view.DrawArea;

public class Main {
	public static void main(String[] args) {
		DrawArea application = new DrawArea();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(650, 500);
		application.setVisible(true);
	}

}
