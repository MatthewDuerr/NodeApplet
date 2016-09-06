/*
 * @author Matthew Duerr
 * Class : Node
 * Basic outline of a node
 * 
 */

import java.awt.*;
import java.awt.event.*;


/**
 * The Class Node.
 */
public class Node {

	/*
	 * // A node is made up of
	 */
	/** The element. */
	private Comparable element; // a reference to an element
	// (which must be comparable), and
	/** The next. */
	private Node next; // a reference to the next node

	/** The y. */
	protected int x, y; // The location of the node
	
	/** The color. */
	protected Color color; // its color, and
	
	/** The hilite. */
	protected boolean hilite = true; // whether it is highlighted or not

	/*
	 * Instantiates a Node
	 */
	/**
	 * Instantiates a new node.
	 */
	public Node() {
		element = null;
		next = null;

		x = 275 + (int) (175 * Math.random());
		y = 50 + (int) (375 * Math.random());
		color = Color.gray;
		hilite = true;
	}

	/*
	 * Initializes a Node
	 */
	/**
	 * Instantiates a new node.
	 *
	 * @param someX the some x
	 * @param someY the some y
	 * @param someColor the some color
	 */
	public Node(int someX, int someY, Color someColor) {
		element = null;
		next = null;

		x = someX;
		y = someY;
		color = someColor;
		hilite = true;
	}

	/*
	 * Set element of Node to someElement that is passes
	 */
	/**
	 * Sets the element.
	 *
	 * @param someElement the new element
	 */
	public void setElement(Comparable someElement) {
		element = someElement;
	}

	/*
	 * Return the element
	 */
	/**
	 * Gets the element.
	 *
	 * @return the element
	 */
	public Comparable getElement() {
		return element;
	}

	/*
	 * set the reference to the next node as someNode passed
	 */
	/**
	 * Sets the next.
	 *
	 * @param someNode the new next
	 */
	public void setNext(Node someNode) {
		next = someNode;
	}

	/*
	 * Return the next node
	 */
	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/*
	 * Set the location of the node to someX and someY
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
	 * return the Node's x value
	 */
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/*
	 * Return the node's y value
	 */
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/*
	 * Paint a node
	 */
	/**
	 * Paint.
	 *
	 * @param pane the pane
	 */
	public void paint(Graphics pane) {
		// For the purpose of drawing the Node, we must "materialize"
		// the element in the node as an actual Element (in order
		// to access its location, paint method, etc.)

		Element item = (Element) element; // Explicit casting

		final int SIZE = Element.HEIGHT; // Defines the size of the cells
		// in a node (for drawing)

		final int DELTA = 2; // The offset within the box/frame

		pane.setColor(Color.black); // Drawing the box/frame of the node
		pane.drawRect(x, y, 2 * SIZE - DELTA, SIZE);

		pane.setColor(Color.black); // Drawing the element's cell
		pane.drawRect(x + DELTA, y + DELTA, SIZE - 2 * DELTA, SIZE - 2 * DELTA);
		pane.setColor(color);
		pane.fillRect(x + 2 * DELTA, y + 2 * DELTA, SIZE - 4 * DELTA + 1, SIZE
				- 4 * DELTA + 1);
		pane.setColor(Color.black);
		pane.drawOval(x + SIZE / 2 - 1, y + SIZE / 2 - 1, 2, 2);
		pane.setColor(Color.yellow);
		pane.drawLine(x + SIZE / 2, y + SIZE / 2, item.getX() + item.WIDTH,
				item.getY() + item.HEIGHT / 2);
		item.paint(pane); // Then drawing the element in question
		// and an arrow (or pointer)
		// between the cell and the element

		pane.setColor(Color.black); // Drawing the next node's cell
		pane.drawRect(x + SIZE, y + DELTA, SIZE - 2 * DELTA, SIZE - 2 * DELTA);
		pane.setColor(color);
		pane.fillRect(x + SIZE + DELTA, y + 2 * DELTA, SIZE - 4 * DELTA + 1,
				SIZE - 4 * DELTA + 1);
		if (next == null) {
			pane.setColor(Color.red);
			pane.drawLine(x + SIZE + 1, y + DELTA + 1, x + 2 * SIZE - 2 * DELTA
					- 1, y + SIZE - DELTA - 1);
		} else {
			pane.setColor(Color.black);
			pane.drawOval(x + 3 * SIZE / 2 - DELTA - 1, y + SIZE / 2 - 1, 2, 2);
			pane.drawLine(x + 3 * SIZE / 2 - DELTA, y + SIZE / 2, next.getX(),
					next.getY() + SIZE / 2);

			next.paint(pane);
		}
	}

} // end of Node