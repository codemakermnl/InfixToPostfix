/**
 * Node class to be used for linked list
 * 
 * @author Richard Bryann Chua
 * 
 * Adapted from the book 
 * "Data Structures and Algorithms in Java"
 * by Michael Goodrich and Robert Tamassia
 *
 */
public class Node<T> {
	/**
	 * Holds the key or element of the node
	 */
	private T element;
	
	/**
	 * Points to the next node in the linked list
	 */
	private Node<T> next;
	
	/**
	 * Initializes the node with the element being null
	 * and next node also null
	 */
	public Node() {
		this(null, null);
	}
	
	/**
	 * Initializes the node
	 * 
	 * @param element the key or element of the node
	 * @param next the node where this node points to
	 */
	public Node(T element, Node<T> next) {
		this.element = element;
		this.next = next;
	}
	
	/** 
	 * @return the key or element of the node
	 */
	T getElement() {
		return element;
	}
	
	/**
	 * 
	 * @return the next node of this node in the list
	 */
	Node<T> getNext() {
		return next;
	}
	
	/**
	 * Sets the key or element of the node
	 * 
	 * @param element the new key or element of the node
	 */
	void setElement(T element) {
		this.element = element;
	}
	
	/**
	 * Sets the next node of this node
	 * 
	 * @param next the next node of this node
	 */
	void setNext(Node<T> next) {
		this.next = next;
	}
}
