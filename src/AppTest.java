/*
 * @author Matthew Duerr
 * Class: AppTest
 */
import java.awt.*; //	AWT = "Abstract Window Toolkit"
import java.awt.event.*; //		or "Another Window Toolkit"
import java.applet.Applet;


/**
 * The Class AppTest.
 */
public class AppTest // We want to handle the events
		implements MouseListener // from the mouse
{

	/** The applet. */
	private Applet theApplet; // To get a hold of the applet
	// associated with the main program

	/** The collection. */
	private OrderedList collection; // To hold our elements

	/** The sort button. */
	private Abutton charButton, // To add a character element
			intButton, // or an integer element,
			removeButton, // to remove an element,
			sortButton; // and to sort the whole list

	/** The last y. */
	private int lastX, lastY; // To keep the mouse location
	
	/** The delta. */
	private final int DELTA = 16; // Spacing for the buttons and elements

	/*
	 * Default Constructor
	 */
	/**
	 * Instantiates a new app test.
	 */
	public AppTest() {
	}

	/*
	 * Create buttons and add MouseListener
	 */
	/**
	 * Instantiates a new app test.
	 *
	 * @param mainProgram the main program
	 */
	public AppTest(Applet mainProgram) {
		theApplet = mainProgram;

		theApplet.addMouseListener(this); // To check on the mouse

		int x = DELTA;
		int y = DELTA;
		charButton = new Abutton("'a', 'b', 'c'", Color.green, x, y);
		y += Abutton.BUTTON_HEIGHT * 1.25;
		intButton = new Abutton("1, 2, 3", Color.cyan, x, y);

		y += Abutton.BUTTON_HEIGHT * 1.5;
		removeButton = new Abutton("Remove", Color.yellow, x, y);

		y += Abutton.BUTTON_HEIGHT * 1.5;
		sortButton = new Abutton("Sort", Color.orange, x, y);

		x += Abutton.BUTTON_WIDTH + DELTA; // We instantiate our list
		y = DELTA;
		collection = new OrderedList(x, y); // at the right location
	}

	/**
	 * Flip when inside.
	 */
	private void flipWhenInside() {
		if (charButton.isInside(lastX, lastY))
			charButton.flip();
		else if (intButton.isInside(lastX, lastY))
			intButton.flip();
		else if (removeButton.isInside(lastX, lastY))
			removeButton.flip();
		else if (sortButton.isInside(lastX, lastY))
			sortButton.flip();

		theApplet.repaint();
	}

	/*
	 * Paints the buttons
	 */
	/**
	 * Paint.
	 *
	 * @param pane the pane
	 */
	public void paint(Graphics pane) {
		if (charButton != null) // If instantiated,
			charButton.paint(pane); // we display the buttons
		if (intButton != null)
			intButton.paint(pane);
		if (removeButton != null)
			removeButton.paint(pane);
		if (sortButton != null)
			sortButton.paint(pane);

		if (collection != null) // and our collection of elements
			collection.paint(pane);
	}

	/*
	 * The check method will use the lastX and lastY values to handle a user's
	 * click
	 */
	/**
	 * Check.
	 */
	private void check() {
		theApplet.showStatus(" ");

		try {
			if (charButton.isInside(lastX, lastY)) {
				// We generate a random character
				char value = "abcdefghijklmnopqrstuvwxyz"
						.charAt((int) (26 * Math.random()));
				collection.add(value); // and we add it
			} else if (intButton.isInside(lastX, lastY)) {
				// We generate a random integer
				int value = (int) (100 * Math.random());
				collection.add(value); // and we add it
			} else if (removeButton.isInside(lastX, lastY)) {
				Element item; // We remove an element
				item = (Element) (collection.remove()); // and we print it out
				System.out.println("  --> " + item);

				theApplet.showStatus("  --> " + item);
			} else if (sortButton.isInside(lastX, lastY)) {
				collection.sort(); // We sort the whole list
			} else {
				theApplet.showStatus("What?");
			}
		} catch (Exception problem) {
			System.err.println("***** We caught an exception *****");
			System.err.println("Here is the message: " + problem.getMessage());
			System.err.println("Here is the stack:");
			problem.printStackTrace();
			System.err.println("**********************************");

			theApplet.showStatus("Exception: " + problem.getMessage());
		} finally {
			theApplet.repaint();
		}
	}

	/*
	 * 
	 * MouseListener events handle the different forms of input that comes from
	 * a user's mouse or track pad (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent event) {
		check(); // To handle the mouse click
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent event) {
		lastX = event.getX(); // Update the mouse location
		lastY = event.getY();

		flipWhenInside(); // Flip any button hit by the mouse
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent event) {
		flipWhenInside(); // Flip any button hit by the mouse
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent event) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent event) {
	}

} // end LabDemo