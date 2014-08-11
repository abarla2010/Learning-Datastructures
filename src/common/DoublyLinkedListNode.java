package common;

/**
 *
 * Node helper class for Doubly Linked List
 */
public class DoublyLinkedListNode {

	public Object data;
	public DoublyLinkedListNode next;
	public DoublyLinkedListNode previous;

	/**
	 * Constructor
	 * @param inputData
	 */
	public DoublyLinkedListNode(Object inputData){
		this.data = inputData;
	}
}
