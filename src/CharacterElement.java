/*
 * @author Matthew Duerr
 * SubClass: CharacterElement
 * 
 */

import java.awt.*;
import java.awt.event.*;


/**
 * The Class CharacterElement.
 */
public class CharacterElement extends Element {

	/** The value. */
	private char value; // The "value" of the element

	/*
	 * Constructor initializes all components of a character element.
	 */
	/**
	 * Instantiates a new character element.
	 *
	 * @param someValue the some value
	 * @param someX the some x
	 * @param someY the some y
	 * @param someColor the some color
	 */
	public CharacterElement(char someValue, int someX, int someY,
			Color someColor) {
		super(someX, someY, someColor); // We pass the buck for some of it,
		value = someValue; // and we deal with the rest
	}

	/*
	 * returns a string containing the character value
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.valueOf(value);
	}

	/*
	 * Paints an element that is a character
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

} // end of CharacterElement