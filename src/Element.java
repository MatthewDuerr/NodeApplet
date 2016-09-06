/*
 * @author Matthew Duerr
 * Abstract Class: Element 
 */

import java.awt.*;
import java.awt.event.*;


/**
 * The Class Element.
 */
public abstract class Element implements Comparable {

	/** The Constant HEIGHT. */
	public final static int WIDTH = 28, // 36, // To define the standard size
			HEIGHT = 20; // 24; // of the elements

	/** The y. */
	protected int x, y; // The location of the element
	
	/** The color. */
	protected Color color; // its color, and
	
	/** The hilite. */
	protected boolean hilite = true; // whether it is highlighted or not

	/*
	 * The default constructor instantiates all components
	 */
	/**
	 * Instantiates a new element.
	 */
	public Element() {
		x = 0;
		y = 0;
		color = Color.gray;
		hilite = true;
	}

	/*
	 * The following constructor initializes all components of an element
	 */
	/**
	 * Instantiates a new element.
	 *
	 * @param someX the some x
	 * @param someY the some y
	 * @param someColor the some color
	 */
	public Element(int someX, int someY, Color someColor) {
		x = someX;
		y = someY;
		color = someColor;
		hilite = true;
	}

	/*
	 * The following access method resets the location of an element
	 */
	/**
	 * Sets the location.
	 *
	 * @param someX the some x
	 * @param someY the some y
	 */
	public void setLocation(int someX, int someY) {
		x = someX;
		y = someY;
	}

	/*
	 * The following access methods return the location of an element
	 */
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/*
	 * The following method implements the comparable interface (we use the
	 * alphanumeric ordering on the string representation of the elements).
	 */
	/* (non-Javadoc)
	 * @see Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object element) {
		return toString().compareTo(element.toString());
	}

	/*
	 * Paints the elements
	 */
	/**
	 * Paint.
	 *
	 * @param pane the pane
	 */
	public void paint(Graphics pane) {
		final int DELTA = 2; // The offset within the box/frame

		pane.setColor(Color.black); // Drawing the box/frame of the element
		pane.drawRect(x, y, WIDTH, HEIGHT);

		pane.setColor(color); // and the inside of the element
		pane.fill3DRect(x + DELTA, y + DELTA, WIDTH - 2 * DELTA + 1, HEIGHT - 2
				* DELTA + 1, hilite);
	}

} // end of Element