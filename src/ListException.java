
/*
	@author Matthew Duerr
	Class: ListException
 */

/**
 * The Class ListException.
 */
public class ListException extends Exception {
	/*
	 * If an exception is generated/instantiated with no specific message, we
	 * only signal a generic "list exception."
	 */

	/**
	 * Instantiates a new list exception.
	 */
	public ListException() {
		super("List exception");
	}

	/*
	 * But, if an exception is generated/instantiated with a specific message,
	 * we pass it up.
	 */
	/**
	 * Instantiates a new list exception.
	 *
	 * @param message the message
	 */
	public ListException(String message) {
		super(message);
	}
}