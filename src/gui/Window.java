package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

import settings.Settings;

public class Window extends JFrame {

	MonthsPanel monthsPanel = new MonthsPanel(this);
	DaysPanel daysPanel = new DaysPanel(this);

	public Window() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(Settings.RESIZABLE);
		this.setLayout(new BorderLayout());
		this.add(monthsPanel, BorderLayout.NORTH);
		this.add(daysPanel, BorderLayout.CENTER);
		this.getContentPane().setBackground(Color.BLUE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);

	}

	public MonthsPanel getMonthsPanel() {
		return monthsPanel;
	}

	public DaysPanel getDaysPanel() {
		return daysPanel;
	}

}