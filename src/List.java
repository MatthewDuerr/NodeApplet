/*
 * @author Matthew Duerr
 * Class: List
 */
import java.awt.*;
import java.awt.event.*;


/**
 * The Class List.
 */
public class List {
	
	/** The head. */
	protected Node head; // A reference to the first node (if any)

	/** The y. */
	private int x, y; // To define the location of the list
	
	/** The delta. */
	private final// Defines the size and spacing
	int SIZE = Element.HEIGHT, // of the cells in the list
			DELTA = 2; // (for drawing purposes)

	/*
	 * Instantiates a list
	 */
	/**
	 * Instantiates a new list.
	 */
	public List() { // By default, we start
		this(143, 147); // at an arbitrary location
	}

	/*
	 * Initializes a list
	 */
	/**
	 * Instantiates a new list.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public List(int x, int y) {
		head = null; // No element at the "head", yet

		this.x = x; // We keep track of the location
		this.y = y;
	}

	/*
	 * Returns boolean variable on whether the list is empty or not
	 */
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/*
	 * Find length of list
	 */
	/**
	 * Length.
	 *
	 * @return the int
	 */
	public int length() { // It is easier determined
		return length(head); // through a utility method
	}

	/*
	 * The length's utility method finds the number of nodes in a list and
	 * returns the value as an integer
	 */
	/**
	 * Length.
	 *
	 * @param someHead the some head
	 * @return the int
	 */
	public int length(Node someHead) {
		int result;

		if (someHead == null) // If the sub-list is empty,
			result = 0; // there are no element
		else
			// otherwise, there is the first node
			result = 1 // then the rest
			+ length(someHead.getNext());

		return result;
	}

	/*
	 * adds a single instance of a character list to the list
	 */
	/**
	 * Adds the.
	 *
	 * @param value the value
	 */
	public void add(char value) {
		CharacterElement item;

		item = new CharacterElement(value, x + (int) (75 * Math.random()), y
				+ 2 * SIZE + (int) (300 * Math.random()), Color.green);

		add(item);
	}

	/*
	 * Adds a single instance of an integer element to the list
	 */
	/**
	 * Adds the.
	 *
	 * @param value the value
	 */
	public void add(int value) {
		IntegerElement item;

		item = new IntegerElement(value, x + (int) (75 * Math.random()), y + 2
				* SIZE + (int) (300 * Math.random()), Color.cyan);

		add(item);
	}

	/*
	 * The add method creates a new node and then sets its values then attaches
	 * it to the front of the list as head
	 */
	/**
	 * Adds the.
	 *
	 * @param someItem the some item
	 */
	protected void add(Comparable someItem) {
		Node placeHolder = new Node();

		placeHolder.setElement(someItem);

		placeHolder.setNext(head);

		head = placeHolder;
	}

	/*
	 * The remove method will first check if the list is empty, if it isn't then
	 * it removes the head, since at least on node is guaranteed
	 */
	/**
	 * Removes the.
	 *
	 * @return the comparable
	 * @throws ListException the list exception
	 */
	public Comparable remove() throws ListException {
		if (isEmpty())
			throw new ListException("List empty");

		Comparable result = head.getElement();

		head = head.getNext();

		return result;
	}

	/*
	 * Paints each element in list
	 */
	/**
	 * Paint.
	 *
	 * @param pane the pane
	 */
	public void paint(Graphics pane) {
		final int SIZE = Element.HEIGHT; // Defines the size of the cells
		// in a node (for drawing)

		final int DELTA = 2; // The offset within the box/frame

		pane.setColor(Color.black); // Drawing the box/frame of the list
		pane.drawRect(x, y, SIZE, SIZE);

		pane.setColor(Color.black); // Drawing the head's cell
		pane.drawRect(x + DELTA, y + DELTA, SIZE - 2 * DELTA, SIZE - 2 * DELTA);
		pane.setColor(Color.gray);
		pane.fillRect(x + 2 * DELTA, y + 2 * DELTA, SIZE - 4 * DELTA + 1, SIZE
				- 4 * DELTA + 1);

		if (head == null) {
			pane.setColor(Color.red);
			pane.drawLine(x + DELTA + 1, y + DELTA + 1, x + SIZE - DELTA - 1, y
					+ SIZE - DELTA - 1);
		} else {
			pane.setColor(Color.black);
			pane.drawOval(x + SIZE / 2 - 1, y + SIZE / 2 - 1, 2, 2);
			pane.drawLine(x + SIZE / 2, y + SIZE / 2, head.getX(), head.getY()
					+ SIZE / 2);

			head.paint(pane);
		}
	}

} // end of List