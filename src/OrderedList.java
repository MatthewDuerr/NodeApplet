/*
 * @author Matthew Duerr
 * 
 *	Class: Ordered List
 */

/**
 * The Class OrderedList.
 */
public class OrderedList extends List {
	/*
	 * Class constructors
	 */
	/**
	 * Instantiates a new ordered list.
	 */
	public OrderedList() {
		super();
	}

	/**
	 * Instantiates a new ordered list.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public OrderedList(int x, int y) {
		super(x, y);
	}

	/*
	 * The sort method is called whenever a list is to be sorted.
	 */
	/**
	 * Sort.
	 */
	public void sort() {
		head = mergeSort(head);
	}

	/*
	 * The sort method calls our utility method
	 */
	/**
	 * Merge sort.
	 *
	 * @param someHead
	 *            the some head
	 * @return the node
	 */
	protected Node mergeSort(Node someHead) {

		if (someHead == null || someHead.getNext() == null)
			return someHead;
		Node left = someHead;
		Node right = someHead.getNext();
		while ((right != null) && (right.getNext() != null)) {
			someHead = someHead.getNext();
			right = (right.getNext()).getNext();
		}
		right = someHead.getNext();
		someHead.setNext(null);
		return merge(mergeSort(left), mergeSort(right));

	}

	/*
	 * When merge sort is used it needs a way to put the list and pairs back
	 * together
	 */
	/**
	 * Merge.
	 *
	 * @param left
	 *            the left
	 * @param right
	 *            the right
	 * @return the node
	 */
	public Node merge(Node left, Node right) {

		Node temp = new Node();
		Node head = temp;
		Node current = head;
		while ((left != null) && (right != null)) {
			if ((left.getElement().compareTo(right.getElement()) > 0)) {
				current.setNext(left);
				current = left;
				left = left.getNext();
			} else {
				current.setNext(right);
				current = right;
				right = right.getNext();
			}
		}

		if (left == null)
			current.setNext(right);
		else
			current.setNext(left);

		return head.getNext();
	}

} // end of OrderedList