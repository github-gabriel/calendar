package gui;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import settings.Settings;
import tools.Tools;

public class DaysPanel extends JPanel {

	Window window;

	public DaysPanel(Window window) {

		this.window = window;
		this.setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBackground(Color.BLUE);
		addDays(this, Tools.getDaysInMonth(Settings.CURRENT_MONTH));
		this.setVisible(true);

	}

	public void addDays(JPanel panel, int days) {

		Tools.refreshDays(panel, days, window);

	}

}
