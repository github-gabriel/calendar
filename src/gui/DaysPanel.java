package gui;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Graphics;

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
		addDays(this, Tools.getDaysInMonth(Settings.TODAYS_MONTH));
		this.setVisible(true);

	}

	public void addDays(JPanel panel, int days) {

		for (int i = 0; i < days + 1; i++) {

			if (i == Settings.TODAYS_DAY && window.getMonthsPanel().getMonthIndex() == Settings.TODAYS_MONTH
					&& Settings.year == Settings.TODAYS_YEAR) {

				JButton button = new JButton(String.valueOf(i));
				button.setFont(Settings.BUTTON_FONT);
				button.setForeground(Color.BLACK);
				button.setBackground(Color.RED);
				button.setPreferredSize(new Dimension(Settings.BUTTON_WIDTH, Settings.BUTTON_HEIGHT));
				panel.add(button);

			} else {

				JButton button = new JButton(String.valueOf(i));
				button.setFont(Settings.BUTTON_FONT);
				button.setForeground(Color.BLACK);
				button.setPreferredSize(new Dimension(Settings.BUTTON_WIDTH, Settings.BUTTON_HEIGHT));
				panel.add(button);

			}

			window.repaint();

		}

	}

}
