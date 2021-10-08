/**
 * Implementation of the Stack interface using 
 * linked list.
 * 
 * @author Richard Bryann Chua
 * 
 * Adapted from the book 
 * "Data Structures and Algorithms in Java"
 * by Michael Goodrich and Robert Tamassia
 *
 * ADDED GENERICS
 */
public class LinkedStack<T> implements Stack<T> {
	private Node<T> top;
	private int size;
	
	public LinkedStack() {
		top = null;
		size = 0;
	}

	/* (non-Javadoc)
	 * @see Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {		
		return (top == null);
	}

	/* (non-Javadoc)
	 * @see Stack#pop()
	 */
	@Override
	public T pop() throws StackEmptyException {
		if (isEmpty())
			throw new StackEmptyException("Stack is empty!");
		T temp = top.getElement();
		top = top.getNext();
		size--;
		return temp;
	}

	/* (non-Javadoc)
	 * @see Stack#push(java.lang.Object)
	 */
	@Override
	public void push(T element) {
		Node<T> v = new Node<T>(element, top);
		top = v;
		size++;
	}

	/* (non-Javadoc)
	 * @see Stack#size()
	 */
	@Override
	public int size() {		
		return size;
	}

	/* (non-Javadoc)
	 * @see Stack#top()
	 */
	@Override
	public T top() throws StackEmptyException {
		if (isEmpty())
			throw new StackEmptyException("Stack is empty!");
		
		return top.getElement();
	}

}
