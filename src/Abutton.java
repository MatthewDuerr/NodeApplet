/*
 * @author Matthew Duerr
 * Class: Abutton
 * An outline for a button, Jbutton could have been used here just as effectively
 * but a more customizable button was desired 
 * 
 */
import java.awt.*;
import java.awt.event.*;


/**
 * The Class Abutton.
 */
public class Abutton {
	
	/** The Constant BUTTON_HEIGHT. */
	public static final int BUTTON_WIDTH = 72, // To define a "standard" size
			// button
			BUTTON_HEIGHT = 30;

	/*
	 * Creates a default button
	 */
	/**
	 * Instantiates a new abutton.
	 */
	public Abutton() {
		this("?????", Color.black, 100, 100);
	}

	/*
	 * Creates a new button based on information passed by parameter The size of
	 * the button uses the default size
	 */
	/**
	 * Instantiates a new abutton.
	 *
	 * @param someLabel the some label
	 * @param someColor the some color
	 * @param someX the some x
	 * @param someY the some y
	 */
	public Abutton(String someLabel, Color someColor, int someX, int someY) {
		this(someLabel, someColor, someX, someY, BUTTON_WIDTH, BUTTON_HEIGHT);
	}

	/*
	 * Instantiates a new button given all its fields.
	 */
	/**
	 * Instantiates a new abutton.
	 *
	 * @param someLabel the some label
	 * @param someColor the some color
	 * @param someX the some x
	 * @param someY the some y
	 * @param someWidth the some width
	 * @param someHeight the some height
	 */
	public Abutton(String someLabel, Color someColor, int someX, int someY,
			int someWidth, int someHeight) {
		setup(someLabel, someColor, someX, someY, someWidth, someHeight);
	}

	/*
	 * Initializes the components of a button
	 */
	/**
	 * Setup.
	 *
	 * @param someLabel the some label
	 * @param someColor the some color
	 * @param someX the some x
	 * @param someY the some y
	 * @param someWidth the some width
	 * @param someHeight the some height
	 */
	public void setup(String someLabel, Color someColor, int someX, int someY,
			int someWidth, int someHeight) {
		theLabel = someLabel;
		theColor = someColor;
		x = someX;
		y = someY;
		width = someWidth;
		height = someHeight;
		up = true;
	}

	/*
	 * Changes the boolean flip value of a button
	 */
	/**
	 * Flip.
	 */
	public void flip() {
		up = !up;
	}

	/*
	 * test an xy coordinate to determine if it is within the button's boundries
	 */
	/**
	 * Checks if is inside.
	 *
	 * @param someX the some x
	 * @param someY the some y
	 * @return true, if is inside
	 */
	public boolean isInside(int someX, int someY) {
		return ((someX >= x) && (someX <= x + width) && (someY >= y) && (someY <= y
				+ height));
	}

	/*
	 * Paints button to screen
	 */
	/**
	 * Paint.
	 *
	 * @param pane the pane
	 */
	public void paint(Graphics pane) {
		final int DELTA = 2; // To define the space between the
		// frame and the inside of a button

		pane.setColor(Color.black); // Drawing the button frame
		pane.drawRect(x, y, width, height); // in black,

		pane.setColor(theColor); // and the inside of the button
		pane.fill3DRect(x + DELTA, y + DELTA, // in the button color
				width - (2 * DELTA - 1), height - (2 * DELTA - 1), up);

		pane.setColor(Color.black); // Finally, we put the label in black
		// ... and nicely centered
		int labelWidth = pane.getFontMetrics().stringWidth(theLabel);
		int labelHeight = pane.getFontMetrics().getAscent();
		pane.drawString(theLabel, x + (width - labelWidth) / 2, y
				+ (height + labelHeight) / 2);
	}

	/*
	 * our variables
	 */
	/** The label. */
	private String theLabel; // To hold the label,
	
	/** The color. */
	private Color theColor; // the color,
	
	/** The height. */
	private int x, y, // the location, and
			width, height; // the size of the button

	/** The up. */
	private boolean up; // To achieve 3-D effects

} // end Abutton