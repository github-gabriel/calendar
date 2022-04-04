package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import gui.Window;
import settings.Settings;
import tools.Tools;

public class CalendarMain {

	public static void main(String[] args) {

		Window window = new Window();

		while (window.isEnabled()) {

			window.getMonthsPanel().updateTime();
			
			Tools.refreshDays(window.getDaysPanel(), Tools.getDaysInMonth(window.getMonthsPanel().getMonthIndex()),
					window);
			
			window.getDaysPanel().revalidate();
			window.getDaysPanel().repaint();
			window.getMonthsPanel().revalidate();
			window.getMonthsPanel().repaint();
			
			window.repaint();
			
			window.revalidate();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
