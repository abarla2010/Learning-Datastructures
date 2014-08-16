package iterator;

import common.DoublyLinkedListNode;
import lists.DoublyLinkedList;

import java.util.NoSuchElementException;

/**
 * Linked list iterator class
 *
 */
public class LinkedListIterator implements LinkedListIteratorInterface {

	private DoublyLinkedListNode next;
	private DoublyLinkedListNode previous;
	private DoublyLinkedListNode temp;
	private DoublyLinkedListNode current;
	private DoublyLinkedListNode currentLast;
	private DoublyLinkedList doublyLinkedList;

	/**
	 * Constructor
	 */
	public LinkedListIterator(DoublyLinkedList doublyLinkedList){
		this.doublyLinkedList = doublyLinkedList;
		this.current = doublyLinkedList.getFirst();
		this.currentLast = doublyLinkedList.getLast();
	}

	/**
	 * Method to check if the list has a next element
	 * @return
	 */
	@Override
	public boolean hasNext() {
		return !doublyLinkedList.isEmpty() && current != null;
	}

	/**
	 * Method to get the next element
	 * @return
	 */
	@Override
	public Object next() {

		if (!hasNext()) throw new NoSuchElementException();
		temp = current;
		current = current.next;
		return temp.data;
	}

	/**
	 * Method to check if the list has a previous element
	 * @return
	 */
	@Override
	public boolean hasPrevious() {
		return currentLast != null;
	}

	/**
	 * Method to get the previous element
	 * @return
	 */
	@Override
	public Object previous() {
		temp = currentLast;
		currentLast = currentLast.previous;
		return temp.data;
	}
}
