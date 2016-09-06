/*
 * @author Matthew Duerr
 * SubClass IntegerElement
 */
import java.awt.*;
import java.awt.event.*;


/**
 * The Class IntegerElement.
 */
public class IntegerElement extends Element {

	/** The value. */
	private int value; // The "value" of the element

	/*
	 * The following constructor initializes all the components of an element to
	 * hold a given integer, at a given location, in a given color.
	 */
	/**
	 * Instantiates a new integer element.
	 *
	 * @param someValue the some value
	 * @param someX the some x
	 * @param someY the some y
	 * @param someColor the some color
	 */
	public IntegerElement(int someValue, int someX, int someY, Color someColor) {
		super(someX, someY, someColor); // We pass the buck for some of it,
		value = someValue; // and we deal with the rest
	}

	/*
	 * Defines the textual representation of an integer element
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.valueOf(value);
	}

	/*
	 * Paint an integer element
	 */
	/* (non-Javadoc)
	 * @see Element#paint(java.awt.Graphics)
	 */
	public void paint(Graphics pane) {
		super.paint(pane); // We start with the basic element

		pane.setColor(Color.black);
		String theLabel = String.valueOf(value);
		int labelWidth = pane.getFontMetrics().stringWidth(theLabel);
		int labelHeight = pane.getFontMetrics().getAscent();
		pane.drawString(theLabel, x + (WIDTH - labelWidth) / 2, y
				+ (HEIGHT + labelHeight) / 2);
	}

} // end of IntegerElement