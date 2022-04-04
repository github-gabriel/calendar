package tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.time.YearMonth;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.Window;
import settings.Settings;

public final class Tools {

	public static int getDaysInMonth(int month) {
		month += 1;
		YearMonth yearMonthObject = YearMonth.of(Settings.year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		return daysInMonth;
	}

	public static void refreshDays(JPanel panel, int days, Window window) {

		panel.removeAll();

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

		}

		panel.revalidate();
		panel.repaint();
		window.repaint();

	}

}
