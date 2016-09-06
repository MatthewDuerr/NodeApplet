/* 
 * @author Matthew Duerr
 *This program illustrates a possible implementation of Merge Sort, using
 *linked lists.
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


/**
 * The Class SimpleApplet.
 */
public class SimpleApplet extends Applet {

	/** The app. */
	private AppTest theApp; // A demo, that's all we need

	/*
	 * initialize the app
	 */
	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	public void init() {
		theApp = new AppTest(this); // We instantiate the "demo"

		setBackground(new Color(189, 198, 222));
	}

	/*
	 * Paint app
	 */
	/* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paint(Graphics pane) {
		if (theApp != null)
			theApp.paint(pane);
	}

} // end Lab