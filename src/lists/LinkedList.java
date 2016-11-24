package lists;

import iterator.Node;

public class LinkedList<E>{


	public Node head;
	public int size;
	public LinkedList(){
		this.head = null;
		this.size = 0;
		}

	/**
	 * Method to add an element to the list
 	 * @param data
	 */
	public void add(Object data){
		Node input = new Node(data);
		Node temp = null;

			if(head == null){
				head = input;
			}
			else{
				temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = input;
			}
			size++;
		}

	/**
	 * Method to remove an element from the list
	 */
	public void remove() {
		Node temp = null;
		Object data = null;
		if (size == 0 || size == 1) {
			return;
		}
		else {
			temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}

			data = temp.next.data;
			temp.next = null;
		}
	}

	/**
	 * Method to check if the list is empty or not
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method to get the size of the list
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to get an element for a specified index
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		int count = 0;
		Node temp = null;

		if (size == 0 || index > size)
			return null;

		temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.next.data;
	}

	/**
	 * Method to get the first element
	 * @return
	 */
	public Object getFirst() {
		if (head == null) {
			return null;
		} else {
			return head.data;
		}
	}

	/**
	 * Method to get the last element
	 * @return
	 */
	public Object getLast() {
		Node temp = null;
		temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		return temp.data;
	}

	/**
	 * Removes all the nodes from the list
	 */
	public void clear(){
		head = null;
	}
}









