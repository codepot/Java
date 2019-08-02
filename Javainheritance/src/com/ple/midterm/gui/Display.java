package com.ple.midterm.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import com.ple.midterm.Main;

public class Display {
	Main data;
	MammalTableModel model;
	public Display(Main aMain) {
		this.data = aMain;
		model = new MammalTableModel(aMain.getMammals());
		JTable table = new JTable(model);
		table.setSize(890, 360);
		JButton btn_sortByClass = new JButton("Sort by Class Name");
		JButton btn_sortById = new JButton("Sort by Id");
		JButton btn_sortByName = new JButton("Sort by Name");
		JButton btn_sortByCageCleanningStatus = new JButton("Sort by Cage Cleaning Status");
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(5).setPreferredWidth(15);
	
		table.setRowHeight(25);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JFrame frame = new JFrame("ABC Humane Society Mammal Project");
		frame.setSize(900, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());			
	    
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btn_sortByClass);
        buttonPanel.add(btn_sortById);
        buttonPanel.add(btn_sortByName);
        buttonPanel.add(btn_sortByCageCleanningStatus);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arrial", Font.BOLD, 10));
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(header, BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);	
        
        btn_sortById.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				data.reportSortedById();
				model.fireTableDataChanged();
			}
		});
        
        btn_sortByClass.setToolTipText("sort list of mammals by intance of class");
        btn_sortByClass.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				data.reportSortedByType();
				model.fireTableDataChanged();
			}
		});
        
        
        btn_sortByName.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				data.reportSortedByName();
				model.fireTableDataChanged();
			}
		});
        
       
        btn_sortByCageCleanningStatus.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				data.reportSortedByCageCleaningStatus();
				model.fireTableDataChanged();
			}
		});
        
	}
}
