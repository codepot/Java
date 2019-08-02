package com.ple.stopwatch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Stopwatch implements ActionListener {

	JLabel aJLabel;
	long start = 0;
	double ellapsedTime = 0.0;
	boolean paused = false;
	boolean stopped = false;
	boolean started = false;

	public Stopwatch() {
		JFrame aJFrame = new JFrame("My Stopwatch");

		aJFrame.getContentPane().setLayout(new FlowLayout());
		aJFrame.setSize(280, 120);

		aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton startJButton = new JButton("Start");
		JButton stopJButton = new JButton("Stop");
		JButton pauseJButton = new JButton("Pause");

		aJLabel = new JLabel("Press Start");
		aJLabel.setFont(new Font("Courier New", Font.BOLD, 14));
		aJLabel.setForeground(Color.BLUE);

		startJButton.addActionListener(this);
		stopJButton.addActionListener(this);
		pauseJButton.addActionListener(this);

		aJFrame.getContentPane().add(startJButton);
		aJFrame.getContentPane().add(stopJButton);
		aJFrame.getContentPane().add(pauseJButton);
		aJFrame.getContentPane().add(aJLabel);

		// to Make JFrame center on screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		aJFrame.setLocation(dim.width / 2 - aJFrame.getSize().width / 2,
				dim.height / 2 - aJFrame.getSize().height / 2);

		aJFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Calendar aCalendar = Calendar.getInstance();
		if (actionEvent.getActionCommand().equals("Start")) {
			//started = true;
			start = aCalendar.getTimeInMillis();
			aJLabel.setText("Stopwatch is running...");

		} else if (actionEvent.getActionCommand().equals("Stop")) {
			if (!paused) {
				// start = aCalendar.getTimeInMillis();
				ellapsedTime += (double) (aCalendar.getTimeInMillis() - start) / 1000;

			}
			aJLabel.setText("Elapsed time is " + ellapsedTime);
			//started = false;
			stopped = true;
			//paused = true;
			ellapsedTime = 0;
			

		} else { // pause
			// start = aCalendar.getTimeInMillis();
			ellapsedTime += (double) (aCalendar.getTimeInMillis() - start) / 1000;
			aJLabel.setText("Stopwatch is pausing at "+ ellapsedTime);
			paused = true;
		}

		System.out.println("------\nstart = " + start + "\n" + "ellapsedTime = "
				+ ellapsedTime + "\n" + "paused = " + paused + "\n"
				+ "stopped = " + stopped + "------\n");
	}

}
