package settings;

import java.awt.Font;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public final class Settings {

	public static int YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	public static String[] months = new DateFormatSymbols().getMonths();
	
	public static final int CURRENT_MONTH = Calendar.getInstance().get(Calendar.MONTH);
	public static final int CURRENT_DAY = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	public final static boolean RESIZABLE = true;
	
	public static int WIDTH = 800;
	public static int HEIGHT = 600;

	public final static int PADDING = 15;

	public final static int BUTTON_WIDTH = 150;
	public final static int BUTTON_HEIGHT = 75;

	public final static int TEXTFIELD_WIDTH = 350;

	public final static Font BUTTON_FONT = new Font("Arial", Font.BOLD, 40);
	public final static Font TEXTFIELD_FONT = new Font("Arial", Font.BOLD, 45);
	public final static Font LABEL_FONT = new Font("Arial", Font.BOLD, 55);

}
