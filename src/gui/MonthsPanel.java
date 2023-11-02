package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Settings;
import tools.Tools;

public class MonthsPanel extends JPanel implements ActionListener {

	private JButton buttonLeft, buttonRight;
	private JTextField textField;
	private int monthIndex = Calendar.getInstance().get(Calendar.MONTH);
	private final Window window;
	private JLabel timeLabel;
	private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	public MonthsPanel(Window window) {

		this.window = window;
		this.setPreferredSize(new Dimension(Settings.WIDTH, Settings.BUTTON_HEIGHT + Settings.PADDING));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBackground(Color.BLUE);
		addMonthSelection(this);
		this.setVisible(true);

	}

	private void addMonthSelection(JPanel panel) {

		buttonLeft = new JButton("<");
		buttonLeft.addActionListener(this);
		buttonLeft.setFont(Settings.BUTTON_FONT);
		buttonLeft.setForeground(Color.BLACK);
		buttonLeft.setPreferredSize(new Dimension(Settings.BUTTON_HEIGHT, Settings.BUTTON_HEIGHT));
		panel.add(buttonLeft);

		textField = new JTextField(Settings.months[monthIndex] + "-" + Settings.YEAR);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setFont(Settings.TEXTFIELD_FONT);
		textField.setForeground(Color.BLACK);
		textField.setPreferredSize(new Dimension(Settings.TEXTFIELD_WIDTH, Settings.BUTTON_HEIGHT));
		panel.add(textField);

		buttonRight = new JButton(">");
		buttonRight.addActionListener(this);
		buttonRight.setFont(Settings.BUTTON_FONT);
		buttonRight.setForeground(Color.BLACK);
		buttonRight.setPreferredSize(new Dimension(Settings.BUTTON_HEIGHT, Settings.BUTTON_HEIGHT));
		panel.add(buttonRight);

		this.setTime();

	}

	public void setTime() {

		if (timeLabel != null) {
			this.remove(timeLabel);
		}

		LocalDateTime localDateTime = LocalDateTime.now();

		String time = dateTimeFormatter.format(localDateTime);
		timeLabel = new JLabel(" " + time);
		timeLabel.setFont(Settings.LABEL_FONT);
		timeLabel.setForeground(Color.BLACK);
		this.add(timeLabel);

		this.revalidate();
		this.repaint();

	}
	
	public void updateTime() {
		
		LocalDateTime localDateTime = LocalDateTime.now();

		String time = dateTimeFormatter.format(localDateTime);
		
		timeLabel.setText(" " + time);
		
	}

	public int getMonthIndex() {
		return monthIndex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(buttonLeft)) {
			if (!(monthIndex <= 0)) {
				monthIndex--;
			} else {
				monthIndex = 11;
				Settings.YEAR--;
			}
			textField.setText(Settings.months[monthIndex] + "-" + Settings.YEAR);
			Tools.refreshDays(window.getDaysPanel(), Tools.getDaysInMonth(monthIndex), window);
			window.getDaysPanel().revalidate();
			window.getDaysPanel().repaint();
			window.repaint();
		}
		if (e.getSource().equals(buttonRight)) {
			if (!(monthIndex >= 11)) {
				monthIndex++;
			} else {
				monthIndex = 0;
				Settings.YEAR++;
			}
			textField.setText(Settings.months[monthIndex] + "-" + Settings.YEAR);
			Tools.refreshDays(window.getDaysPanel(), Tools.getDaysInMonth(monthIndex), window);
			window.getDaysPanel().revalidate();
			window.getDaysPanel().repaint();
			window.repaint();
		}

	}

}